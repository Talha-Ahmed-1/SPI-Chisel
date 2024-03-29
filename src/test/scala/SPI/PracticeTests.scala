package SPI

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
// import org.scalatest.flatspec.AnyFlatSpec



class PracticeTests extends FreeSpec with ChiselScalatestTester {

  "Practice" in {
    test(new Practice()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        // c.io.a.poke(44.U)
        // c.io.b.poke(99.U)
        // c.io.i_clk.poke(Clock().asInstanceOf[Bool])
        c.clock.step(20)
    }
  }
}