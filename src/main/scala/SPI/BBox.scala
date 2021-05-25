package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._


class BlackBoxAdder extends BlackBox with HasBlackBoxInline{
    val io = IO (new Bundle{
        val in1 = Input ( UInt (32. W ) )
        val in2 = Input ( UInt (32. W ) )
        val out = Output ( UInt (32. W ) )
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

class BBox extends Module{
    val io = IO (new Bundle() {
        val in1 = Input ( UInt (32. W ) )
        val in2 = Input ( UInt (32. W ) )
        val out = Output ( UInt (32. W ) )
        // val ioo = Module(new BlackBoxAdder)
    })
    val BBAdder = Module(new BlackBoxAdder)

    BBAdder.io.in1 := io.in1
    BBAdder.io.in2 := io.in2

    io.out := BBAdder.io.out
}