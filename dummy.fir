;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit dummy : 
  extmodule spixpress : 
    input i_clk : UInt<1>
    input i_reset : UInt<1>
    input i_wb_cyc : UInt<1>
    input i_wb_stb : UInt<1>
    input i_cfg_stb : UInt<1>
    input i_wb_we : UInt<1>
    input i_wb_addr : SInt<22>
    input i_wb_data : SInt<32>
    output o_wb_stall : UInt<1>
    output o_wb_ack : UInt<1>
    input o_wb_data : SInt<32>
    output o_spi_cs_n : UInt<1>
    output o_spi_sck : UInt<1>
    output o_spi_mosi : UInt<1>
    input i_spi_miso : UInt<1>
    
    defname = spixpress
    
    
  module dummy : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip i_clk : UInt<1>, flip i_reset : UInt<1>, flip i_wb_cyc : UInt<1>, flip i_wb_stb : UInt<1>, flip i_cfg_stb : UInt<1>, flip i_wb_we : UInt<1>, flip i_wb_addr : SInt<22>, flip i_wb_data : SInt<32>, o_wb_stall : UInt<1>, o_wb_ack : UInt<1>, flip o_wb_data : SInt<32>, o_spi_cs_n : UInt<1>, o_spi_sck : UInt<1>, o_spi_mosi : UInt<1>, flip i_spi_miso : UInt<1>}
    
    inst SPI of spixpress @[Main.scala 35:21]
    SPI.i_spi_miso is invalid
    SPI.o_spi_mosi is invalid
    SPI.o_spi_sck is invalid
    SPI.o_spi_cs_n is invalid
    SPI.o_wb_data is invalid
    SPI.o_wb_ack is invalid
    SPI.o_wb_stall is invalid
    SPI.i_wb_data is invalid
    SPI.i_wb_addr is invalid
    SPI.i_wb_we is invalid
    SPI.i_cfg_stb is invalid
    SPI.i_wb_stb is invalid
    SPI.i_wb_cyc is invalid
    SPI.i_reset is invalid
    SPI.i_clk is invalid
    SPI.i_spi_miso <= io.i_spi_miso @[Main.scala 36:8]
    io.o_spi_mosi <= SPI.o_spi_mosi @[Main.scala 36:8]
    io.o_spi_sck <= SPI.o_spi_sck @[Main.scala 36:8]
    io.o_spi_cs_n <= SPI.o_spi_cs_n @[Main.scala 36:8]
    SPI.o_wb_data <= io.o_wb_data @[Main.scala 36:8]
    io.o_wb_ack <= SPI.o_wb_ack @[Main.scala 36:8]
    io.o_wb_stall <= SPI.o_wb_stall @[Main.scala 36:8]
    SPI.i_wb_data <= io.i_wb_data @[Main.scala 36:8]
    SPI.i_wb_addr <= io.i_wb_addr @[Main.scala 36:8]
    SPI.i_wb_we <= io.i_wb_we @[Main.scala 36:8]
    SPI.i_cfg_stb <= io.i_cfg_stb @[Main.scala 36:8]
    SPI.i_wb_stb <= io.i_wb_stb @[Main.scala 36:8]
    SPI.i_wb_cyc <= io.i_wb_cyc @[Main.scala 36:8]
    SPI.i_reset <= io.i_reset @[Main.scala 36:8]
    SPI.i_clk <= io.i_clk @[Main.scala 36:8]
    
