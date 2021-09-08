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



class HarnessTests extends FreeSpec with ChiselScalatestTester {

  "Harness" in {
    test(new Harness()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        // c.io.a.poke(44.U)
        // c.io.b.poke(99.U)
        // c.io.i_clk.poke(Clock().asInstanceOf[Bool])
        
        // c.io.clk.poke(clock.asUInt()(0).asClock())
        // c.io.rst_n.poke(0.B)
        c.io.data_in.poke("b1010101010101010101010100001101".U)
        c.clock.step(1)
        c.io.start.poke(1.B)
        c.clock.step(1)
        c.io.start.poke(0.B)
        // c.clock.step(1)
        // c.io.data_in.poke("b0".U)


        // c.io.clk.poke(1.B)
        // c.clock.step(1)
        // c.io.clk.poke(0.B)
        // c.clock.step(1)
        // c.io.clk.poke(1.B)
        // c.clock.step(1)
        // c.io.clk.poke(0.B)
        // c.clock.step(1)
        // c.io.clk.poke(1.B)
        // c.clock.step(1)
        // c.io.clk.poke(0.B)
        // c.clock.step(1)
        // c.io.clk.poke(1.B)
        // c.clock.step(1)
        // c.io.clk.poke(0.B)
        // c.clock.step(1)
        // c.io.clk.poke(1.B)
        // c.clock.step(1)
        // c.io.clk.poke(0.B)

        c.clock.step(1000)
    }
  }
}