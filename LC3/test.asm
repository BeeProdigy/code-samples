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

	

	HALT

;************ Date area *********************
PRMPT1	.STRINGZ	"Please enter a two-digit decimal number> "
PRMPT2	.STRINGZ	"The sum of the digits = "
CHAR	.FILL		1
CHAR1	.FILL		1
CLRF	.FILL		#10
	.END