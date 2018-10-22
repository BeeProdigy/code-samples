;  Kristal VanEtten
;  E01194732
;  COSC 221 WINTER 2018
;  LAB # 7
;  This a program that reads in
;  two-digit decimal number whose
;  digits add up to less than
;  10 and display the sum of those
;  digits in the next line.

	.ORIG	x3000

	LEA	R0, PRMPT1	;  display first prompt
	PUTS

	GETC			;  read char
	OUT
	ST	R0, CHAR	;  safe keep char

	GETC			;  read char
	OUT
	ST	R0, CHAR1	;  safe keep char

	LD	R0, CLRF	;  execute a newline
	OUT

	LEA	R0, PRMPT2	;  display second prompt
	PUTS

	LD	R0, CHAR	;  reload char
	AND 	R1, R1, #0	;  clear r1
	ADD	R1, R1, R0	;  r1 = r1 + r0(char) || r1 = char1
	LD	R0, CHAR1	;  reload char
	ADD	R0, R1, R0	;  r1 = r1 (char) + r0(char1) || char = char1
	LD	R1, NEG48
	ADD	R0, R0, R1
	OUT	

	;LD	R0, CLRF	;  execute new line
	;OUT

	HALT

;************ Date area *********************
PRMPT1	.STRINGZ	"Please enter a two-digit decimal number> "
PRMPT2	.STRINGZ	"The sum of the digits = "
CHAR	.BLKW		1
CHAR1	.BLKW		1
NEG48	.FILL		#-48
NEG10	.FILL		#-10
CLRF	.FILL		#10
	.END