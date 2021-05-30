package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._

class Interface extends Bundle{
    val i_clk = Input(Bool())
    val i_reset = Input(Bool())
    val i_wb_cyc = Input(Bool())
    val i_wb_stb = Input(Bool())
    val i_cfg_stb = Input(Bool())
    val i_wb_we = Input(Bool())
    val i_wb_addr = Input(SInt(22.W))
    val i_wb_data = Input(SInt(32.W))
    val o_wb_stall = Output(Bool())
    val o_wb_ack = Output(Bool())
    val o_wb_data = Input(SInt(32.W))
    val o_spi_cs_n = Output(Bool())
    val o_spi_sck = Output(Bool())
    val o_spi_mosi = Output(Bool())
    val i_spi_miso = Input(Bool())
}
class spixpress extends BlackBox with HasBlackBoxResource{
    val io = IO(new Interface)
    addResource("/vsrc/spixpress.v")
}

class Practice extends Module{
    val io = IO(new Interface)
    val SPI = Module(new spixpress)
    SPI.io <> io

}