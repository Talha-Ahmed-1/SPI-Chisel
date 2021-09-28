package SPI
import SPI._

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class SPITests extends FreeSpec with ChiselScalatestTester {

  // implicit val config = Config()
  "SPI" in {
    implicit val spiConfig = Config()
    test(new SPI()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
        c.io.data_in.bits.poke(659.U)
        c.io.data_in.valid.poke(1.B)
        // c.io.start.poke(1.B)
        c.clock.step(1)
        c.io.data_in.bits.poke(200.U)
        c.io.data_in.valid.poke(1.B)
        c.clock.step(1)
        // c.io.data_in.valid.poke(1.B)
        // c.io.data_out.ready.poke(1.B)
        
        var count = 1
        while (count != 500){
          val mosi = c.io.mosi.peek()
          c.io.miso.poke(mosi)
          c.clock.step(1)
          count += 1
        }


        // c.io.miso.poke(1.B)
        // c.clock.step(1)
        // c.io.miso.poke(1.B)
        // c.clock.step(1)
        // c.io.miso.poke(0.B)
        // c.clock.step(1)
        // c.io.miso.poke(1.B)
        // c.clock.step(1)
        // c.io.miso.poke(0.B)
        // c.clock.step(1)
        // c.io.miso.poke(0.B)
        // c.clock.step(1)
        // c.io.miso.poke(1.B)
        // c.clock.step(1)
        // c.io.miso.poke(0.B)
        // c.clock.step(20)
    }
  }
}