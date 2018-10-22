;  Kristal VanEtten
;  COSC 221 WINTER 2018
;  LAB #9
;  A program to compute the largest number between two digits.
;  Computation of the largest number is performed
;  by subroutine STRLAR. The beginning of the address of the 
;  (in memory) is passed to the subroutine in R0.
;  The string is arranged largest to smallest and returned in R1.
;  Program works for a string length of 2.

	.ORIG	x3000
;  *******************  Main ***************************************

	LEA 	R0, PRMPT1	;  display first prompt
	PUTS

	LEA	R2, NUM		;  allocate input string to r2

	AND	R1, R1, #0	;  clear r1
	AND	R0, R0, #0	;  clear r0
	LD	R1, REPS

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


CHECK	LD	R0, CLRF
	PUTS
	LD	R0, NUM
	JSR	STRLAR
	ST	R0, LRG		;  safekeep largest number
	
	LEA	R0, PRMPT2	;  load second prompt
	PUTS
	
	LD	R0, LRG
	OUT

;	LD	R2, POS48
;	ADD	R0, R0, R2
	OUT	

	HALT

; *****************  Data area *************************************
PRMPT1	.STRINGZ	"Please enter two single digit numbers> "
PRMPT2	.STRINGZ	"The largest number is> "
LRG	.BLKW		1
CLRF	.FILL		#10
NUM	.BLKW		3
REPS	.FILL		3
CHAR	.BLKW		1

;  ****************  Subroutine ************************************
;  A subroutine to compute the largest number between
;  two digits. The beginning of the address of the string is passed
;  to the subroutine (by the main prog) in R0 as a string then
;  break apart.
;  The largest number is returned in R1. 
;  *****************************************************************

STRLAR	LD	R2, SaveR2
	LD	R1, SaveR1
	LD	R1, NUM
	GETC
	ST	R1, NUMB1
	GETC
	ST	R2, NUMB2
	
	AND	R0, R0, #0	;  clear r0
	AND 	R3, R3, #0	;  clear r3
	NOT	R1, R1		;  calc 2 compl
	NOT	R3, R3		;  flip the number
	ADD	R3, R3, #1	;  add 1 to make neg number
	ADD	R6, R3, R5	;  add the numbers
	BRn	MAX
	BRzp	MIN
	
MAX	LD	R1, NUMB1
	LD	R2, SaveR2
	LD	R1, SaveR1
	RET

MIN	LD	R1, NUMB2
	LD	R2, SaveR2
	LD	R1, SaveR1
	RET


;  register storage area

SaveR1	.BLKW	1
SaveR2	.BLKW	1
COUNT	.FILL	#-1
NUMB1	.BLKW	1
NUMB2	.BLKW	1
;  *****************************************************************

	.END