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
    implicit val config = Config()
    test(new SpiWrapper()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        c.io.dataRequest.bits.poke("b01110111".U)
        c.io.activeByteLane.poke("b11111111".U)
        c.io.dataRequest.valid.poke(1.B)
        c.io.dataResponse.ready.poke(1.B)
        c.clock.step(5)
        c.io.dataRequest.bits.poke("b11111000".U)
        // c.io.dataRequest.valid.poke(1.B)
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




  // "Spi Wrapper" in {
  //   test(new SpiWrapper()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
  //       c.io.dataRequest.bits.poke("b10111011101110111011101110111011".U)
  //       c.io.activeByteLane.poke("b11111111111111111111111111111111".U)
  //       c.io.dataRequest.valid.poke(1.B)
  //       c.io.dataResponse.ready.poke(1.B)
  //       c.clock.step(10)
  //       c.io.dataRequest.bits.poke("b11111110000000001111111111000000".U)
  //       // c.io.dataRequest.valid.poke(1.B)
  //       // c.io.dataResponse.ready.poke(1.B)
  //       var count = 1
  //       while(count != 2000) {
  //           val mosi = c.io.mosi.peek()
  //           c.io.miso.poke(mosi)
  //           // println("This is the real answer ************"+c.io.mosi.peek())
  //           c.clock.step(1)
  //           count += 1
  //       }
  //   }
  // }
}