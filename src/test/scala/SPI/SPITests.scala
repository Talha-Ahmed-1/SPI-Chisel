package SPI

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class SPITests extends FreeSpec with ChiselScalatestTester {

  "SPI" in {
    test(new SPI).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        c.io.data_in.poke(170.S)
        c.io.start.poke(1.B)
        c.clock.step(1)
        c.io.start.poke(0.B)
        c.io.miso.poke(1.B)
        c.clock.step(1)
        c.io.miso.poke(1.B)
        c.clock.step(1)
        c.io.miso.poke(0.B)
        c.clock.step(1)
        c.clock.step(20)
    }
  }
}