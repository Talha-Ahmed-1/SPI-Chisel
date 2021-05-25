package SPI

import chisel3._
import chisel3.util._
import chisel3.experimental._


    











class Interface extends Bundle{


    ///////////////////////////
    val miso = Input(SInt(8.W))

    val ss = Output(Bool())
    // val mosi = Output(SInt())
    // val wp = Outpuut(Bool())
    // val reset = Output(Bool())
    // val sck = Output(Bool())
    //////////////////////////
}




// Transmission
class Practice extends Module{
    val io = IO(new Interface)

    io.ss := io.miso(0)
}