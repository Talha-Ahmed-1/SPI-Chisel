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

class RxShiftRegister_IO extends Bundle{
    val out = Output(Bool())
    val in = Input(UInt(4.W))
}

class RxShiftRegister extends Module{
    val io = IO(new RxShiftRegister_IO)

    val state = RegInit(1.U(4.W))
    val nextState = state << 1 | io.in
    state := nextState
    io.out := state
}

// class TxShiftRegister_IO extends Bundle{
//     val out = Output(Bool())
//     val in = Input(UInt(4.W))
// }

// class TxShiftRegister extends Module{
//     val io = IO(new TxShiftRegister_IO)

//     io.out := 0.B
//     val state = RegInit (0.U(4.W))
//     val flag = RegInit(0.U(4.W))

//     when (flag =/= 0.U){
//         io.out := state(0)
//         state := state >> 1
//     }.otherwise{
//         flag := flag + 1.U
//         state := io.in
//     }
// }

class SPI_IO extends Bundle{
    val out = Decoupled(UInt(4.W))
    val in = Flipped(Decoupled(UInt(4.W)))
    // val mosi = Output(Bool())
    val miso = Input(Bool())
    val out1 = Output(UInt(4.W))

}

class SPI extends Module{
    val io = IO(new SPI_IO)
    // val buffer = Module(new Buffer)
    val buffer = Module(new RxBuffer)
    buffer.io.in <> io.in
    io.out <> buffer.io.out

    val RxSR = Module(new RxShiftRegister)
    buffer.io.in.bits := RxSR.io.out
    RxSR.io.in := 123.U
    io.out1 := buffer.io.out.bits


    // val TxSR = Module(new TxShiftRegister)
    // TxSR.io.in := buffer.io.out.bits
    // io.mosi := TxSR.io.out

}