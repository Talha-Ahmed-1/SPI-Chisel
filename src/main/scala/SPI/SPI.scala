package SPI
import SPI._

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

class SPI_IO extends Bundle{
    val miso = Input(Bool())
    val mosi = Output(Bool())
    val ss = Output(Bool())
    val sck = Output(Clock())
    val start = Input(Bool())
    val get = Output(Bool())
    val data_in = Input(SInt(8.W))
    val data_out = Output(SInt(8.W))
    // val busy = Output(Bool())
    // val new_data = Output(Bool())
}

class SPI(implicit val config: Config) extends Module{
    val io = IO(new SPI_IO)
    
    if (!config.CPOL & !config.CPHA){
        val idle :: busy :: Nil = Enum(2)
        val state = RegInit(idle)

        val miso_dataReg = RegInit(0.U(8.W))
        val count = RegInit(0.U(4.W))
        val dataReg = RegInit(0.S(8.W))

        io.sck := clock
        io.get := 0.B
        io.data_out := 0.S
        io.ss := 1.B
        io.mosi := 0.B

        // Transmission
        switch(state){
            is(idle){
                when (io.start){
                    io.ss := 0.B
                    dataReg := io.data_in
                    state := busy
                    // miso_dataReg := miso_dataReg << 1 | io.miso
                }
            }
            is(busy){
                when (count === 8.U){
                    io.ss := 1.B
                    state := idle
                    count := 0.U
                }.otherwise{
                    io.ss := 0.B
                    io.mosi := dataReg(0)
                    dataReg := dataReg >> 1
                    count := count + 1.U
                    // miso_dataReg := miso_dataReg << 1 | io.miso
                }
            }
        }

        // Receiving
        val count1 = RegInit(0.U(4.W))
        switch(state){
            is(busy){
                when (count === 8.U){
                    io.data_out := Reverse(miso_dataReg).asSInt
                    io.get := 1.B
                    count1 := 0.U
                }.otherwise{
                    miso_dataReg := miso_dataReg << 1 | io.miso
                    count1 := count1 + 1.U
                }
            }
        }
    }
}


