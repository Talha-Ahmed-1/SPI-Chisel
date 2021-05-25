package SPI

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class PracticeTests extends FreeSpec with ChiselScalatestTester {

  "Practice" in {
    test(new Practice).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        // c.io.miso.poke(1.S)
        c.clock.step(20)
    }
  }
}