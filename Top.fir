;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Top : 
  module Add : 
    input in1 : UInt<8>
    input in2 : UInt<8>
    output out : UInt<8>
    
    node _out_T = add(in1, in2) @[Main.scala 21:15]
    node _out_T_1 = tail(_out_T, 1) @[Main.scala 21:15]
    out <= _out_T_1 @[Main.scala 21:9]
    
  module Sub : 
    input in1 : UInt<8>
    input in2 : UInt<8>
    output out : UInt<8>
    
    node _out_T = sub(in1, in2) @[Main.scala 27:15]
    node _out_T_1 = tail(_out_T, 1) @[Main.scala 27:15]
    out <= _out_T_1 @[Main.scala 27:9]
    
  module Top : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip in1 : UInt<8>, flip in2 : UInt<8>, out : UInt<8>}
    
    inst sub_Module of Add @[Main.scala 35:28]
    inst sub_Module1 of Sub @[Main.scala 36:29]
    sub_Module.in1 <= io.in1 @[Main.scala 38:19]
    sub_Module.in2 <= io.in2 @[Main.scala 39:19]
    io.out <= sub_Module.out @[Main.scala 40:12]
    sub_Module1.in1 <= io.in1 @[Main.scala 42:20]
    sub_Module1.in2 <= io.in2 @[Main.scala 43:20]
    io.out <= sub_Module1.out @[Main.scala 44:12]
    
