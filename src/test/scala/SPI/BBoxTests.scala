package SPI

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class BBoxTests extends FreeSpec with ChiselScalatestTester {

  "BlackBox" in {
    test(new BBox).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        c.io.start.poke(1.B)
        c.io.data_in.poke(255.S)
        // c.io.miso.poke(1.B)
        c.clock.step(20)
    }
  }
}