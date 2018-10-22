;  Kristal VanEtten
;  E01194732
;  COSC 221 WINTER 2018
;  Lab # 6 
;  This is a program to read in
;  a lowercase character and display
;  the corresponding uppercase
;  for the first, middle & last initial 

	.ORIG  X3000

;  get the first initial

	LEA	R0, PRMPT1	;  display first prompt
	PUTS

	GETC			;  read char
	OUT
	ST	R0, CHAR	;  safe keep char

	;LD	R0, CLRF	; execute newline
	;OUT

	GETC			;  read char
	OUT
	ST	R0, CHAR1	;  safe keep char

	;LD	R0, CLRF	; execute newline
	;OUT

	GETC			;  read char
	OUT
	ST	R0, CHAR2	;  safe keep char

	LD	R0, CLRF	; execute newline
	OUT

	LEA	R0, PRMPT2	;  display second prompt
	PUTS

	LD	R0, CLRF	; execute newline
	OUT

	LD	R0, CHAR	;  reload char
	LD	R1, NEG32
	ADD	R0, R0, R1
	OUT			;  display uppercase

	LD	R0, CLRF	;  execute newline
	OUT

	LD	R0, CHAR1	;  reload char
	LD	R1, NEG32
	ADD	R0, R0, R1
	OUT			;  display uppercase

	LD	R0, CLRF	;  execute newline
	OUT

	LD	R0, CHAR2	;  reload char
	LD	R1, NEG32
	ADD	R0, R0, R1
	OUT			;  display uppercase

	LD	R0, CLRF	;  execute newline
	OUT

	HALT
;******* Date area **********
PRMPT1	.STRINGZ	"Enter 3 initials> "
PRMPT2	.STRINGZ	"Initials in uppercase> "
CHAR	.BLKW		1
CHAR1	.BLKW		1
CHAR2	.BLKW		1
NEG32	.FILL		#-32
CLRF	.FILL		#10
	.END