# Analysis of Algorithms
This course covered recurrence relations, combinatorics, recursive algorithms, proofs of correctness. The focus was both on the mathematical side of proving the correctness of the algorithms and their run times as well as on implementing those same algorithms in usable computer code. I successfully mastered calculating time complexity of algorithms (Big- O, theta, and omega) and implementing resursive, iterative and heuristic algorithms.

A more extensive list of topics:
* Recursive algorithms
* Using difference equations
* Inductive proofs of correctness
* Timing of algorithms
* Search of algorithms
* NP completeness
* Divide and conquer algorithms
* Heuristics for NP-hard problems

All projects were group projects, hence 'we' insteaf of 'I'.

## Max Subset (MSS)
The goal of this project was to find the maximum subset of a given set of positive and negative integers. The program can be built and run with ``make prog`` and ``prog [input size in thousands] [input_file] [algorithm to use (1-4)] [debug flag, optional]``. The algorithms from 1 to 4 are enumeration, better enumeration, divide and conquer, and linear time. I have included two test filesm ``testfile1k.txt`` and ``testfile70k.txt``. Each file contains 10 sets of integers, each of size 1,000 and 70,000 respectively.
