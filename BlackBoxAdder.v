
 module BlackBoxAdder (
 input [32:0] in1 ,
 input [32:0] in2 ,
 output [33:0] out
) ;
 always @* begin
 out <= ((in1) + (in2));
 end
 endmodule
    