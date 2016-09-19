# project2-coins
Intro to Algorithms, Summ 2016, Oregon State University

## Usage
```python2.7 coins-rev.py [input file] [algorithm choice]```

Algorithm choice accepts 1 2 or 3. Using 1 makes coins.py use a greedy algorithm. Using 2 switches to dynamic programming. If 3 is used the program will use bother algorithms, first greedy then dynamic programming.

## File Format
Input file is text with the following format. Odd lines are arrays of ints with `[int, int, int]` ended with a new line character. Example: `[1, 5, 10, 25]`. Even lines are a single positive integer terminated with a new line character.

## Statistical Data
Remove the comment characters on lines 5, 37-40, and 51-54. This will allow the user to get the execution time and min. coin count for each execution of the selected algorithm. Data will be stored in `[input_file]-output-data.txt`. Each line is appended to this file, so running the program multiple times will result in very large files if the same input file is used.