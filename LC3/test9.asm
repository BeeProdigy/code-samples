	.ORIG	x3000

	LEA	R0, PRMPT	;  display first prompt
	PUTS

	GETC			;  get first char
	OUT
	LD	R1, CHAR	;  safekeep

	GETC			;  get second char
	OUT
	LD	R2, CHAR1	;  safekeep

	LD	R0, CLRF	;  execute newline
	OUT

	LEA	R0, PRMPT2	;  display second prompt
	PUTS		
	
	ADD	R1, R1, 1
	NOT	R1, R1
	ADD	R1, R1, 1
	OUT
	ADD	R3, R1, R2
	OUT
	ADD	R5, R5, #3
	BRzp	CHECK

	LD	R0, CLRF
;	OUT
;	LEA	R0, ANS1
;	PUTS
;
;CHECK	LEA	R0, ANS2
;	PUTS

	HALT


;  ****************
PRMPT	.STRINGZ	"Enter two numbers> "
PRMPT2	.STRINGZ	"The larger number is> "
ANS1	.STRINGZ	"The second number is larger."
ANS2	.STRINGZ	"The first number is larger."
NUM	.FILL		10
NUM1	.FILL		10
CHAR	.BLKW		1
CHAR1	.BLKW		1
CLRF	.FILL		#10

	.END