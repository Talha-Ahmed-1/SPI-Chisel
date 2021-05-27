package SPI

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import org.scalatest.flatspec.AnyFlatSpec



class PracticeTests extends AnyFlatSpec with ChiselScalatestTester {

  "Practice" should "do nothing" in {
    test(new Practice()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        c.clock.step(20)
    }
  }
}