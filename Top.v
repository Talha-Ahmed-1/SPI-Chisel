module Sub(
  input  [7:0] in1,
  input  [7:0] in2,
  output [7:0] out
);
  assign out = in1 - in2; // @[Main.scala 27:15]
endmodule
module Top(
  input        clock,
  input        reset,
  input  [7:0] io_in1,
  input  [7:0] io_in2,
  output [7:0] io_out
);
  wire [7:0] sub_Module1_in1; // @[Main.scala 36:29]
  wire [7:0] sub_Module1_in2; // @[Main.scala 36:29]
  wire [7:0] sub_Module1_out; // @[Main.scala 36:29]
  Sub sub_Module1 ( // @[Main.scala 36:29]
    .in1(sub_Module1_in1),
    .in2(sub_Module1_in2),
    .out(sub_Module1_out)
  );
  assign io_out = sub_Module1_out; // @[Main.scala 44:12]
  assign sub_Module1_in1 = io_in1; // @[Main.scala 42:20]
  assign sub_Module1_in2 = io_in2; // @[Main.scala 43:20]
endmodule
