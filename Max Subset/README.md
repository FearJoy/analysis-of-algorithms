# Algorithms Project 1 - MSS

## Description
For this project, you will design, implement and analyze (both experimentally and mathematically) four algorithms for the maximum subarray problem - enumeration, better enumeration, divide and conquer, and linear-time.

## Building
Put ``makefile`` and ``four_algorithms.c`` into the same directory.
Use ``make`` on the command line to build the file ``prog``.
To clean the directory, use ``make clean``. This will remove all ``*.o`` and ``prog``.

## Usage
~~~
prog input_size_in_thousands input_file algorithm_switch [debug_switch]
~~~

* input_size_in_thousands - provide a positive integer that reflects (array_size)/1000
  * Use 0 if the file has arrays of various sizes
  * Example: array of 100,000 integers, then use array_size_in_thousands = 100
* input_file - name of the file to read from in current directory
* algorithm_switch - a number of 1, 2, 3, or 4.
  * The algorithms are: (1) enumeration, (2) better enumeration, (3) divide & conquer, (4) linear time
* debug_switch - optional, use 1 to enable debug output

## Sample Input
Sample input from the provided file, MSS_TestProblems.txt
~~~
[1, 4, -9, 8, 1, 3, 3, 1, -1, -4, -6, 2, 8, 19, -10, -11]
[2, 9, 8, 6, 5, -11, 9, -11, 7, 5, -1, -8, -3, 7, -2]
[10, -11, -1, -9, 33, -45, 23, 24, -1, -7, -8, 19]
[31, -41, 59, 26, -53, 58, 97, -93, -23, 84]
[3, 2, 1, 1, -8, 1, 1, 2, 3]
[12, 99, 99, -99, -27, 0, 0, 0, -3, 10]
[-2, 1, -3, 4, -1, 2, 1, -5, 4]

~~~


## Sample Output
All output is stored in the current working directory as ``results.txt``.
### For MSS_TestProblems.txt to results.txt
Console output for the first line
~~~
Writing computation time results for MSS_TestProblems.txt, line #1, array size 500..
betterEnumeration: 	0 seconds 0 milliseconds
~~~
Output for the first array, written to results.txt
~~~
[1, 4, -9, 8, 1, 3, 3, 1, -1, -4, -6, 2, 8, 19, -10, -11]
[8, 1, 3, 3, 1, -1, -4, -6, 2, 8, 19]
34
~~~

### For Larger Files
Sample output for a test file with one line and an array with 70,000 integers in [-100,100] using the better enumeration algorithm
~~~
Writing computation time results for testfile70k.txt, line #1, array size 70000..
betterEnumeration: 	5 seconds 989 milliseconds
~~~

