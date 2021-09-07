package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._


class HarnessBundle extends Bundle{
    val data_in = Input(UInt(32.W))
    val start = Input(Bool())
    val data_out = Output(UInt(32.W))
    val finish = Output(Bool())

    // val cs_n = Output(Bool())
    // val sclk = Output(Bool())
    // val mosi = Output(Bool())
    // val miso = Input(Bool())
}


class Harness extends Module{
    val io = IO(new HarnessBundle)
    val spiMain = Module(new SpiMain)
    val spiSlave = Module(new SpiSlave)

    val clk_wire = WireInit(~clock.asUInt()(0))
    val rst_wire = WireInit(~reset.asUInt()(0))

    spiMain.io.clk := clk_wire.asClock()
    spiMain.io.rst_n := rst_wire.asAsyncReset()

    spiSlave.io.clk := clk_wire.asClock()
    spiSlave.io.rst_n := rst_wire.asAsyncReset()

    io.data_out := spiMain.io.data_out
    io.finish := spiMain.io.finish

    spiSlave.io.data_in := DontCare

    spiMain.io.data_in := io.data_in
    spiMain.io.start := io.start

    spiSlave.io.cs_n := spiMain.io.cs_n
    spiSlave.io.sclk := spiMain.io.sclk
    spiSlave.io.mosi := spiMain.io.mosi
    
    spiMain.io.miso := spiSlave.io.miso
    
}