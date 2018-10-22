;  Kristal VanEtten
;  COSC 221 WINTER 2018
;  LAB #8
;  LC3 program to read in a name
;  and spit it back to the user.

	.ORIG	x3000

	LEA	R0, PRMPT	;  display first prompt
	PUTS
	
	LEA	R2, INPUT	;  allocates input string to r2
	AND	R1, R1, #0	;  clear register r1
	LD	R1, REPS	;  load counter

AGAIN	GETC			;  read in char
	OUT
	ST	R0, CHAR
	STR	R0, R2, #0	;  store in LD
	ADD	R2, R2, #1
	LD	R0, CHAR
	ADD	R0, R0, #-11
	BRn	CHECK		;  if zero than check
	ADD	R1, R1, #-1	;  decrement counter
	BRp	AGAIN		;  repeat till end of counter

CHECK	LEA	R0, PRMPT1	;  display second prompt
	PUTS

	LEA	R0, INPUT
	PUTS

	HALT

; ********* Date area ********
PRMPT	.STRINGZ	"Please enter your name: "
PRMPT1	.STRINGZ	"You entered: "
REPS	.FILL		21
CHAR	.BLKW		1
INPUT	.BLKW		25
CLRF	.FILL		#10
	.END