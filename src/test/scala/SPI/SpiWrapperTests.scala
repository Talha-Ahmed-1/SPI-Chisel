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



class SpiWrapperTests extends FreeSpec with ChiselScalatestTester {

  "Spi Wrapper" in {
    test(new SpiWrapper()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        
        c.clock.step(100)
    }
  }
}