package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._

class Interfaces(DW:Int) extends Bundle{
    val clk = Input(Clock())
    val rst_n = Input(Bool())

    val data_in = Input(UInt(DW.W))
    val start = Input(Bool())
    val spi_ready = Output(Bool())
    val data_out = Output(UInt(DW.W))
    val finish = Output(Bool())

    val cs_n = Output(Bool())
    val sclk = Output(Bool())
    val mosi = Output(Bool())
    val miso = Input(Bool())

}
class spi_master(implicit val config: Config) extends BlackBox(
    Map("CLK_FREQUENCE" -> config.CLK_FREQUENCE,
        "SPI_FREQUENCE" -> config.SPI_FREQUENCE,
        "DATA_WIDTH"    -> config.DW,
        "CPOL"          -> config.CPOL,
        "CPHA"          -> config.CPHA)) 
    with HasBlackBoxResource{

    val io = IO(new Interfaces(config.DW))
    addResource("/vsrc/spi_master.v")
}

class SpiMain(implicit val config: Config) extends Module{
    val io = IO(new Interfaces(config.DW))
    val spi = Module(new spi_master)
    spi.io <> io

}