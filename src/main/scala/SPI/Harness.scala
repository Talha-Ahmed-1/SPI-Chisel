package SPI

import caravan.bus.common.{AddressMap, BusDecoder, DeviceAdapter, Switch1toN, DummyMemController, Peripherals} // imported DummyMemController
import caravan.bus.wishbone._
import chisel3._
import chisel3.experimental.ChiselEnum
import chisel3.stage.ChiselStage
import chisel3.util.{Cat, Decoupled}
import chisel3.util.experimental.loadMemoryFromFile

class Harness/*(programFile: Option[String])*/(implicit val config: WishboneConfig) extends Module {
  val io = IO(new Bundle {
    val valid = Input(Bool())
    val addrReq = Input(UInt(config.addressWidth.W))
    val dataReq = Input(UInt(config.dataWidth.W))
    val byteLane = Input(UInt((config.dataWidth/config.granularity).W))
    val isWrite = Input(Bool())

    val validResp = Output(Bool())
    val dataResp = Output(UInt(32.W))

    //master spi
    // val cs_n = Output(Bool())
    // val sclk = Output(Bool())
    // val mosi = Output(Bool())
    // val miso = Input(Bool())

    //slave spi
    val data_in = Input(UInt(32.W))
    val data_out = Output(UInt(32.W))
    val data_valid = Output(Bool())
  })
//   implicit val config = WishboneConfig(10, 32)
  implicit val request = new WBRequest()    // implicit val for REQUEST
  implicit val response = new WBResponse()  // implicit val for RESPONSE

  val wbHost = Module(new WishboneHost())
  val wbSlave = Module(new WishboneDevice())
  val spi = Module(new SpiWrapper())
  val spiSlave = Module(new SpiSlave())

  wbHost.io.rspOut.ready := true.B  // IP always ready to accept data from wb host

  wbHost.io.wbMasterTransmitter <> wbSlave.io.wbMasterReceiver
  wbSlave.io.wbSlaveTransmitter <> wbHost.io.wbSlaveReceiver

  wbHost.io.reqIn.valid := Mux(wbHost.io.reqIn.ready, io.valid, false.B)
  wbHost.io.reqIn.bits.addrRequest := io.addrReq
  wbHost.io.reqIn.bits.dataRequest := io.dataReq
  wbHost.io.reqIn.bits.activeByteLane := io.byteLane
  wbHost.io.reqIn.bits.isWrite := io.isWrite



//   wbSlave.io.reqOut <> spi.io.req
//   wbSlave.io.rspIn <> spi.io.rsp

    spi.io.dataRequest.bits := wbSlave.io.reqOut.bits.dataRequest
    spi.io.dataRequest.valid := wbSlave.io.reqOut.valid
    wbSlave.io.reqOut.ready := spi.io.dataRequest.ready

    spi.io.addrRequest := wbSlave.io.reqOut.bits.addrRequest

    spi.io.isWrite := wbSlave.io.reqOut.bits.isWrite
    spi.io.activeByteLane := wbSlave.io.reqOut.bits.activeByteLane

    wbSlave.io.rspIn.bits.dataResponse := spi.io.dataResponse.bits
    wbSlave.io.rspIn.valid := spi.io.dataResponse.valid
    spi.io.dataResponse.ready := wbSlave.io.rspIn.ready

    wbSlave.io.rspIn.bits.error := spi.io.ackWrite


    //master spi
    // io.cs_n := spi.io.cs_n
    // io.sclk := spi.io.sclk
    // io.mosi := spi.io.mosi
    
    // spi.io.miso := io.miso


    io.dataResp := wbHost.io.rspOut.bits.dataResponse
    io.validResp := wbHost.io.rspOut.valid

    // Slave ports
    spiSlave.io.cs_n := spi.io.cs_n
    spiSlave.io.sclk := spi.io.sclk
    spiSlave.io.mosi := spi.io.mosi
    
    spi.io.miso := spiSlave.io.miso

    val clk_wire = WireInit(~clock.asUInt()(0))
    val rst_wire = WireInit(~reset.asUInt()(0))

    spiSlave.io.clk := clk_wire.asClock()
    spiSlave.io.rst_n := rst_wire

    spiSlave.io.data_in := io.data_in
    io.data_out := spiSlave.io.data_out
    io.data_valid := spiSlave.io.data_valid

}













































// import chisel3._
// import chisel3.util._
// import chisel3.experimental._


// class HarnessBundle extends Bundle{
//     val data_in = Input(UInt(32.W))
//     val start = Input(Bool())
//     val data_out = Output(UInt(32.W))
//     val finish = Output(Bool())

//     // val cs_n = Output(Bool())
//     // val sclk = Output(Bool())
//     // val mosi = Output(Bool())
//     // val miso = Input(Bool())
// }


// class Harness extends Module{
//     val io = IO(new HarnessBundle)
//     val spiMaster = Module(new SpiMain)
//     val spiSlave = Module(new SpiSlave)

//     val clk_wire = WireInit(~clock.asUInt()(0))
//     val rst_wire = WireInit(~reset.asUInt()(0))

//     spiMaster.io.clk := clk_wire.asClock()
//     spiMaster.io.rst_n := rst_wire

//     spiSlave.io.clk := clk_wire.asClock()
//     spiSlave.io.rst_n := rst_wire

//     io.data_out := spiMaster.io.data_out
//     io.finish := spiMaster.io.finish

//     spiSlave.io.data_in := DontCare

//     spiMaster.io.data_in := io.data_in
//     spiMaster.io.start := io.start

//     spiSlave.io.cs_n := spiMaster.io.cs_n
//     spiSlave.io.sclk := spiMaster.io.sclk
//     spiSlave.io.mosi := spiMaster.io.mosi
    
//     spiMaster.io.miso := spiSlave.io.miso
    
// }