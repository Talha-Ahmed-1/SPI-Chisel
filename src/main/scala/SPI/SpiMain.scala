package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._

class Interfaces extends Bundle{
    val clk = Input(Clock())
    val rst_n = Input(Reset())

    val data_in = Input(UInt(32.W))
    val start = Input(Bool())
    val data_out = Output(UInt(32.W))
    val finish = Output(Bool())

    val cs_n = Output(Bool())
    val sclk = Output(Bool())
    val mosi = Output(Bool())
    val miso = Input(Bool())

}
class spi_master extends BlackBox with HasBlackBoxResource{
    val io = IO(new Interfaces)
    addResource("/vsrc/spi_master.v")
}

class SpiMain extends Module{
    val io = IO(new Interfaces)
    val spi = Module(new spi_master)
    spi.io <> io

}