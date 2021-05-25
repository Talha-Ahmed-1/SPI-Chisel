package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._

object Main extends App{
    // val BBAdder = Module(new BlackBoxAdder)
    println((new chisel3.stage.ChiselStage).emitVerilog(new dummy))
}

class BlackBoxAdder1 extends BlackBox with HasBlackBoxInline{
    val io = IO (new Bundle{
        val in1 = Input ( UInt (32. W ) )
        val in2 = Input ( UInt (32. W ) )
        val out = Output ( UInt (33. W ) )
    })
    setInline ("BlackBoxAdder.v" ,
    s"""
    | module BlackBoxAdder (
    | input [32:0] in1 ,
    | input [32:0] in2 ,
    | output [33:0] out
    |) ;
    | always @* begin
    | out <= ((in1) + (in2));
    | end
    | endmodule
    """.stripMargin )
}

class dummy extends Module{
    val io = IO (new Bundle() {
    })
    val BBAdder = Module(new BlackBoxAdder1)

    // BBAdder.io.out := io.out
}
