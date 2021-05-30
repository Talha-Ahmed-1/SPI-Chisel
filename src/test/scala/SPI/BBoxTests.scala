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
        c.io.in1.poke(1.U)
        c.io.in2.poke(2.U)
        c.clock.step(20)
    }
  }
}