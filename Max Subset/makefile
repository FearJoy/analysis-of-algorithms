# ===========================================================================
# Title       : CS325 Project 1 Group 27 - Analysis of Algorithms
# Members	  : John Fitzpatrick, Nicholas Hartley
# Date	      : 07/10/2016
# Subject     : Project 1 makefile
# Description : makefile to build our c program to test algorithms
# 				Use 'make all' to build the program, and 'prog' to run
# ===========================================================================
all: prog

prog: four_algorithms.o
	gcc -g -Wall -std=c99 -o prog four_algorithms.o

four_algorithms.o: four_algorithms.c
	gcc -g -Wall -std=c99 -c four_algorithms.c

clean:
	rm four_algorithms.o
	rm prog