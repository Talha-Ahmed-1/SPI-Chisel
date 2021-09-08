package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._

class Wrap_IO extends Bundle{
    val dataRequest = Flipped(Decoupled(UInt(32.W)))
    val addrRequest = Input(UInt(32.W))
    val isWrite = Input(Bool())

    val dataResponse = Decoupled(UInt(32.W))
    val ackWrite = Output(Bool())

    val cs_n = Output(Bool())
    val sclk = Output(Bool())
    val mosi = Output(Bool())
    val miso = Input(Bool())
}

class SpiWrapper extends Module{
    val io = IO(new Wrap_IO)
    val spiMaster = Module(new SpiMain)

    spiMaster.io.data_in := io.dataRequest.bits
    spiMaster.io.start := RegNext(io.dataRequest.valid)
    io.dataRequest.ready := spiMaster.io.spi_ready

    // TODO: addrRequest and isWrite 

    io.dataResponse.bits := Mux(~io.dataResponse.ready & ~spiMaster.io.finish, spiMaster.io.data_out, DontCare)
    
    // TODO: ackWrite
    io.ackWrite := DontCare


}