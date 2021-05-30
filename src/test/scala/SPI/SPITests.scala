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
        c.io.in.bits.poke(3.U)
        c.io.in.valid.poke(1.B)
        c.io.out.ready.poke(1.B)
        c.io.miso.poke(1.B)
        c.clock.step(1)
        c.io.miso.poke(0.B)
        c.clock.step(1)
        c.io.miso.poke(1.B)
        c.clock.step(1)
        c.io.miso.poke(0.B)
        c.clock.step(1)
        c.clock.step(20)
    }
  }
}