module dummy(
  input         clock,
  input         reset,
  input         io_i_clk,
  input         io_i_reset,
  input         io_i_wb_cyc,
  input         io_i_wb_stb,
  input         io_i_cfg_stb,
  input         io_i_wb_we,
  input  [21:0] io_i_wb_addr,
  input  [31:0] io_i_wb_data,
  output        io_o_wb_stall,
  output        io_o_wb_ack,
  input  [31:0] io_o_wb_data,
  output        io_o_spi_cs_n,
  output        io_o_spi_sck,
  output        io_o_spi_mosi,
  input         io_i_spi_miso
);
  wire  SPI_i_clk; // @[Main.scala 35:21]
  wire  SPI_i_reset; // @[Main.scala 35:21]
  wire  SPI_i_wb_cyc; // @[Main.scala 35:21]
  wire  SPI_i_wb_stb; // @[Main.scala 35:21]
  wire  SPI_i_cfg_stb; // @[Main.scala 35:21]
  wire  SPI_i_wb_we; // @[Main.scala 35:21]
  wire [21:0] SPI_i_wb_addr; // @[Main.scala 35:21]
  wire [31:0] SPI_i_wb_data; // @[Main.scala 35:21]
  wire  SPI_o_wb_stall; // @[Main.scala 35:21]
  wire  SPI_o_wb_ack; // @[Main.scala 35:21]
  wire [31:0] SPI_o_wb_data; // @[Main.scala 35:21]
  wire  SPI_o_spi_cs_n; // @[Main.scala 35:21]
  wire  SPI_o_spi_sck; // @[Main.scala 35:21]
  wire  SPI_o_spi_mosi; // @[Main.scala 35:21]
  wire  SPI_i_spi_miso; // @[Main.scala 35:21]
  spixpress SPI ( // @[Main.scala 35:21]
    .i_clk(SPI_i_clk),
    .i_reset(SPI_i_reset),
    .i_wb_cyc(SPI_i_wb_cyc),
    .i_wb_stb(SPI_i_wb_stb),
    .i_cfg_stb(SPI_i_cfg_stb),
    .i_wb_we(SPI_i_wb_we),
    .i_wb_addr(SPI_i_wb_addr),
    .i_wb_data(SPI_i_wb_data),
    .o_wb_stall(SPI_o_wb_stall),
    .o_wb_ack(SPI_o_wb_ack),
    .o_wb_data(SPI_o_wb_data),
    .o_spi_cs_n(SPI_o_spi_cs_n),
    .o_spi_sck(SPI_o_spi_sck),
    .o_spi_mosi(SPI_o_spi_mosi),
    .i_spi_miso(SPI_i_spi_miso)
  );
  assign io_o_wb_stall = SPI_o_wb_stall; // @[Main.scala 36:8]
  assign io_o_wb_ack = SPI_o_wb_ack; // @[Main.scala 36:8]
  assign io_o_spi_cs_n = SPI_o_spi_cs_n; // @[Main.scala 36:8]
  assign io_o_spi_sck = SPI_o_spi_sck; // @[Main.scala 36:8]
  assign io_o_spi_mosi = SPI_o_spi_mosi; // @[Main.scala 36:8]
  assign SPI_i_clk = io_i_clk; // @[Main.scala 36:8]
  assign SPI_i_reset = io_i_reset; // @[Main.scala 36:8]
  assign SPI_i_wb_cyc = io_i_wb_cyc; // @[Main.scala 36:8]
  assign SPI_i_wb_stb = io_i_wb_stb; // @[Main.scala 36:8]
  assign SPI_i_cfg_stb = io_i_cfg_stb; // @[Main.scala 36:8]
  assign SPI_i_wb_we = io_i_wb_we; // @[Main.scala 36:8]
  assign SPI_i_wb_addr = io_i_wb_addr; // @[Main.scala 36:8]
  assign SPI_i_wb_data = io_i_wb_data; // @[Main.scala 36:8]
  assign SPI_o_wb_data = io_o_wb_data; // @[Main.scala 36:8]
  assign SPI_i_spi_miso = io_i_spi_miso; // @[Main.scala 36:8]
endmodule
