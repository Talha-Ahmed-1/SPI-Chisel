module dummy(
  input   clock,
  input   reset
);
  wire [31:0] io_ioo_in1; // @[Main.scala 34:25]
  wire [31:0] io_ioo_in2; // @[Main.scala 34:25]
  wire [32:0] io_ioo_out; // @[Main.scala 34:25]
  wire [31:0] io_ioo_1_in1; // @[Main.scala 34:25]
  wire [31:0] io_ioo_1_in2; // @[Main.scala 34:25]
  wire [32:0] io_ioo_1_out; // @[Main.scala 34:25]
  wire [31:0] BBAdder_in1; // @[Main.scala 36:25]
  wire [31:0] BBAdder_in2; // @[Main.scala 36:25]
  wire [32:0] BBAdder_out; // @[Main.scala 36:25]
  BlackBoxAdder io_ioo ( // @[Main.scala 34:25]
    .in1(io_ioo_in1),
    .in2(io_ioo_in2),
    .out(io_ioo_out)
  );
  BlackBoxAdder io_ioo_1 ( // @[Main.scala 34:25]
    .in1(io_ioo_1_in1),
    .in2(io_ioo_1_in2),
    .out(io_ioo_1_out)
  );
  BlackBoxAdder BBAdder ( // @[Main.scala 36:25]
    .in1(BBAdder_in1),
    .in2(BBAdder_in2),
    .out(BBAdder_out)
  );
  assign io_ioo_in1 = 32'h0;
  assign io_ioo_in2 = 32'h0;
  assign io_ioo_1_in1 = 32'h0;
  assign io_ioo_1_in2 = 32'h0;
  assign BBAdder_in1 = 32'h0;
  assign BBAdder_in2 = 32'h0;
endmodule
