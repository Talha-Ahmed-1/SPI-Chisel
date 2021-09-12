package SPI

import chisel3._
import chisel3 . util._
import org.scalatest._
import chisel3.experimental._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
// import org.scalatest.flatspec.AnyFlatSpec



class SpiWrapperTests extends FreeSpec with ChiselScalatestTester{

  "Spi Wrapper" in {
    test(new SpiWrapper()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        c.io.dataRequest.bits.poke("b10111011101110111011101110111011".U)
        c.io.dataRequest.valid.poke(1.B)
        c.clock.step(1)
        c.io.dataRequest.valid.poke(0.B)
        c.io.dataResponse.ready.poke(1.B)
        // c.io.dataResponse.ready.poke(1.B)
        var count = 1
        while(count != 1000) {
            val mosi = c.io.mosi.peek()
            c.io.miso.poke(mosi)
            // println("This is the real answer ************"+c.io.mosi.peek())
            c.clock.step(1)
            count += 1
        }
    }
  }
}