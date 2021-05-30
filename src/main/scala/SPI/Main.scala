package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._

object Main extends App{
    println((new chisel3.stage.ChiselStage).emitVerilog(new dummy))
}

// class Interface3 extends Bundle{
//     val i_clk = Input(Bool())
//     val i_reset = Input(Bool())
//     val i_wb_cyc = Input(Bool())
//     val i_wb_stb = Input(Bool())
//     val i_cfg_stb = Input(Bool())
//     val i_wb_we = Input(Bool())
//     val i_wb_addr = Input(SInt(22.W))
//     val i_wb_data = Input(SInt(32.W))
//     val o_wb_stall = Output(Bool())
//     val o_wb_ack = Output(Bool())
//     val o_wb_data = Input(SInt(32.W))
//     val o_spi_cs_n = Output(Bool())
//     val o_spi_sck = Output(Bool())
//     val o_spi_mosi = Output(Bool())
//     val i_spi_miso = Input(Bool())
// }
// class BlackBoxSpi extends BlackBox with HasBlackBoxResource{
//     val io = IO(new Interface)
//     addResource("/vsrc/spii.v")
// }

class dummy extends Module{
    val io = IO(new Interface)
    val SPI = Module(new spixpress)
    io <> SPI.io

}













// trait ModuleIO {
//     def in1:UInt
//     def in2:UInt
//     def out:UInt
// }
// class Add extends RawModule with ModuleIO {
//     val in1 =IO(Input(UInt(8.W)))
//     val in2 =IO(Input(UInt(8.W)))
//     val out =IO(Output(UInt(8.W)))
//     out := in1+in2
// }
// class Sub extends RawModule with ModuleIO {
//     val in1 =IO(Input(UInt(8.W)))
//     val in2 =IO(Input(UInt(8.W)))
//     val out =IO(Output(UInt(8.W)))
//     out := in1-in2
// }
// class Top[T <: BaseModule with ModuleIO] (genT: =>T, genT1: =>T) extends Module{
//     val io = IO(new Bundle{
//         val in1=Input(UInt(8.W))
//         val in2=Input(UInt(8.W))
//         val out=Output(UInt(8.W))
//     })
//     val sub_Module = Module(genT)
//     val sub_Module1 = Module(genT1)
    
//     sub_Module.in1:=io.in1
//     sub_Module.in2:=io.in2
//     io.out := sub_Module.out
    
//     sub_Module1.in1:=io.in1
//     sub_Module1.in2:=io.in2
//     io.out := sub_Module1.out
// }



// class Interface2 extends Bundle{
//   val in1 = Input(UInt(8.W))
//   val in2 = Input(UInt(8.W))
//   val out = Output(UInt(8.W))
// }
// class Add extends Module{
//   val io = IO(new Interface2)
//   io.out := io.in1 + io.in2
// }
// class Sub extends Module{
//   val io = IO(new Interface2)
//   io.out := io.in1 + io.in2
// }
// class Top[T <: Module](mod:T) extends Module{
//   val io = IO(new Interface2)
//   val sub_mod = Module(mod)
//   sub_mod.io.in1 := io.out
//   sub_mod.io.in2 := io.out
//   io.out := sub_mod.io.out
// }
