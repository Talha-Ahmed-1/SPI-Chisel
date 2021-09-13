package SPI

case class Config(
    FREQUENCE        : Int = 1,
    // CLK_FREQUENCE : Int = 50000000,
    // SPI_FREQUENCE : Int = 5000000,
    CPOL          : Int = 0,
    CPHA          : Int = 0,
    DW            : Int = 8
)