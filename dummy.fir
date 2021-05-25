;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit dummy : 
  extmodule BlackBoxAdder : 
    input in1 : UInt<32>
    input in2 : UInt<32>
    output out : UInt<33>
    
    defname = BlackBoxAdder
    
    
  extmodule BlackBoxAdder_1 : 
    input in1 : UInt<32>
    input in2 : UInt<32>
    output out : UInt<33>
    
    defname = BlackBoxAdder
    
    
  extmodule BlackBoxAdder_2 : 
    input in1 : UInt<32>
    input in2 : UInt<32>
    output out : UInt<33>
    
    defname = BlackBoxAdder
    
    
  module dummy : 
    input clock : Clock
    input reset : UInt<1>
    output io : {}
    
    inst io_ioo of BlackBoxAdder @[Main.scala 34:25]
    io_ioo.out is invalid
    io_ioo.in2 is invalid
    io_ioo.in1 is invalid
    inst io_ioo_1 of BlackBoxAdder_1 @[Main.scala 34:25]
    io_ioo_1.out is invalid
    io_ioo_1.in2 is invalid
    io_ioo_1.in1 is invalid
    inst BBAdder of BlackBoxAdder_2 @[Main.scala 36:25]
    BBAdder.out is invalid
    BBAdder.in2 is invalid
    BBAdder.in1 is invalid
    
