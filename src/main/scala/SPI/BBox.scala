package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._


class IOs extends Bundle{
    val clk = Input(Bool())
    val rst = Input(Bool())
    val miso = Input(Bool())
    val mosi = Output(Bool())
    val sck = Output(Bool())
    val start = Input(Bool())
    val data_in = Input(SInt(8.W))
    val data_out = Output(SInt(8.W))
    val output = Output(Bool())
    val new_data = Output(Bool())
}
class spi_t extends BlackBox with HasBlackBoxResource{
    val io = IO(new IOs)
    addResource("/vsrc/spi_t.v")
}

class BBox extends Module{
    val io = IO(new IOs)
    val spi = Module(new spi_t)
    spi.io <> io

}