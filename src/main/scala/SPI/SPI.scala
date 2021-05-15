package SPI

import chisel3._
import chisel3.util._

// val CommonIOs extends Bundle {
//     val out = Decoupled(UInt(4.W))
//     val in = Flipped(Decoupled(UInt(4.W)))
// }

class Buffer_IO extends Bundle{
    val out = Decoupled(UInt(4.W))
    val in = Flipped(Decoupled(UInt(4.W)))
}

class Buffer extends Module{
    val io = IO(new Buffer_IO)

    io.out.bits := DontCare
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
    // io.out.bits := DontCare
}

class TxBuffer extends Buffer{}
class RxBuffer extends Buffer{}

// class RxShiftRegister extends Bundle{
//     val out = Decoupled(UInt(4.W))
//     val in = Flipped(Decoupled(UInt(4.W)))
// }

// class RxShiftRegister extends Module{

// }

// class TxShiftRegister_IO extends Bundle{
//     val out = Decoupled(Bool())
//     val in = Flipped(Decoupled(UInt(4.W)))
// }

// class TxShiftRegister extends Module{
//     val io = IO(new TxShiftRegister_IO)

//     io.out.bits := 0.B
//     io.out.valid := 1.B
//     io.in.ready := 1.B
//     val state = RegInit (0.U(4.W))
//     val flag = RegInit(0.U(4.W))

//     when (flag =/= 0.U){
//         io.out.bits := state(0)
//         state := state >> 1
//     }.otherwise{
//         flag := flag + 1.U
//         state := io.in.bits
//     }
// }

class SPI_IO extends Bundle{
    val out = Decoupled(UInt(4.W))
    val in = Flipped(Decoupled(UInt(4.W)))
    // val mosi = Decoupled(Bool())

}

class SPI extends Module{
    val io = IO(new SPI_IO)
    // val buffer = Module(new Buffer)
    val buffer = Module(new TxBuffer)
    buffer.io.in <> io.in
    io.out <> buffer.io.out

    // val TxSR = Module(new TxShiftRegister)
    // TxSR.io.in.bits <> buffer.io.out.bits
    // TxSR.io.in.valid <> buffer.io.out.valid
    // io.mosi <> TxSR.io.out

}