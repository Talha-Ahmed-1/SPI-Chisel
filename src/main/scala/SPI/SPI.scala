package SPI

import chisel3._
import chisel3.util._

class SPI extends Module{
    val io = IO(new SPI_IO)
    val buffer = Module(new Buffer)

    buffer.io.in <> io.in
    io.out <> buffer.io.out
}

class SPI_IO extends Bundle{
    val out = Decoupled(UInt(1.W))
    val in = Flipped(Decoupled(UInt(1.W)))
}

class Buffer_IO extends Bundle{
    val out = Decoupled(UInt(1.W))
    val in = Flipped(Decoupled(UInt(1.W)))
}

class Buffer extends Module{
    val io = IO(new Buffer_IO)

    val free :: busy :: Nil = Enum(2)
    val state = RegInit(free)
    val data = RegInit(0.U)

    io.in.ready := state === free
    io.out.valid := state === busy

    when(state === free){
        when(io.in.valid){
            data := io.in.bits
            state := busy
        }
    }.otherwise{
        when(io.out.ready){
            io.out.bits := data
            state := free
        }
    }
    io.out.bits := DontCare
}

class SPI extends Module{
    val io = IO(new SPI_IO)
    val buffer = Module(new Buffer)

    buffer.io.in <> io.in
    io.out <> buffer.io.out
}