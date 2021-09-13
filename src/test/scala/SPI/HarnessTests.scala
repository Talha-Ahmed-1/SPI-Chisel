// package SPI

// import chisel3._
// import caravan.bus.wishbone._
// import chisel3 . util._
// import org.scalatest._
// import chisel3.experimental._
// import chiseltest._
// import chisel3.experimental.BundleLiterals._
// import chiseltest.experimental.TestOptionBuilder._
// import chiseltest.internal.VerilatorBackendAnnotation
// // import org.scalatest.flatspec.AnyFlatSpec



// class HarnessTests extends FreeSpec with ChiselScalatestTester {
//   // implicit val config = WishboneConfig(10, 32)
//   "Harness" in {
//     implicit val config = WishboneConfig(10, 32)
//     test(new Harness()).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>

//       c.clock.step(5)
//       c.io.valid.poke(true.B)
//       c.io.addrReq.poke(0.U)
//       c.io.dataReq.poke("b1010101010101010101010100001101".U)
//       c.io.byteLane.poke("b1111111111111111111111111111111".U)
//       c.io.isWrite.poke(true.B)
//       c.clock.step(1)
//       c.io.valid.poke(false.B)


//         // c.io.data_in.poke("b1010101010101010101010100001101".U)
//         // c.clock.step(1)
//         // c.io.start.poke(1.B)
//         // c.clock.step(1)
//         // c.io.start.poke(0.B)
        

//         c.clock.step(1000)
//     }
//   }
// }