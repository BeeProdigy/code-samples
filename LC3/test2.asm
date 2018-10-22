.ORIG x3000 
LD R2, NUM1; 
LD R3, NUM2; 
NUM1 .FILL #3 
NUM2 .FILL #5 
NOT R4, R3 
ADD R4, R4, #1 
ADD R1, R4, R2	 
BRz Done 
BRn Reg3 
BRp Reg2 
BRnzp Done 
Reg3 ADD R1, R3, #0 
Reg2 ADD R1, R2, #0 
Done TRAP 0x25 
.END