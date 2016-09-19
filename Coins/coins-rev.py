import re
import os
import sys
from time import time
# import subprocess


def main():
    if len(sys.argv) != 3:
        print("Usage: python2.7 coins-rev.py [input_file] [algorithm to use (1, 2, 3)]")
        exit(1)

    fn = sys.argv[1]                                        # Input file name
    algo = int(sys.argv[2])                                 # Algorithm to run, 1=greedy, 2=dp, null=both

    filename, extension = os.path.splitext(fn)
    outfile = filename + "change.txt"
    of = open(outfile, 'w')

    with open(fn, 'r') as f:
        for line in f:
            line = line.rstrip('\n')
            line = line[1:-1]  # strip start and end brackets
            currArr = map(int, line.split(','))
            amt = int(f.next())

            if algo == 1:
                # greedy algorithm output
                of.write("Algorithm changegreedy:\n")
                t0 = time()
                coinArr, numCoins = changegreedy(currArr, amt)
                t1 = time()
                of.write(str(coinArr) + '\n')
                of.write(str(numCoins) + '\n')
                print("Running time (changegreedy): %f") %(t1-t0)
                # Used to print running time and coin amount to a file for statistical analysis
                # os.environ['time'] = str(t1 - t0)
                # os.environ['coins'] = str(numCoins)
                # os.environ['output_name'] = str(filename + "-output-data.txt")
                # subprocess.Popen("echo $time,$coins >> $output_name", shell=True, executable='/bin/bash')
            elif algo == 2:
                # dynamic programming algorithm output
                of.write("Algorithm changedp:\n")
                t0 = time()
                coinArr, numCoins = changedp(currArr, amt)
                t1 = time()
                of.write(str(coinArr) + '\n')
                of.write(str(numCoins) + '\n')
                print("Running time (changedp): %f") % (t1 - t0)
                # Used to print running time and coin amount to a file for statistical analysis
                # os.environ['time'] = str(t1 - t0)
                # os.environ['coins'] = str(numCoins)
                # os.environ['output_name'] = str(filename + "-output-data.txt")
                # subprocess.Popen("echo $time,$coins >> $output_name", shell=True, executable='/bin/bash')
            elif algo == 3:
                # greedy algorithm output
                of.write("Algorithm changegreedy:\n")
                t0 = time()
                coinArr, numCoins = changegreedy(currArr, amt)
                t1 = time()
                of.write(str(coinArr) + '\n')
                of.write(str(numCoins) + '\n')
                print("Running time (changegreedy): %f") % (t1 - t0)
                # dynamic programming algorithm output
                of.write("Algorithm changedp:\n")
                t2 = time()
                coinArr, numCoins = changedp(currArr, amt)
                t3 = time()
                of.write(str(coinArr) + '\n')
                of.write(str(numCoins) + '\n')
                print("Running time (changedp): %f") % (t3 - t2)
            else:
                print("Usage: python2.7 coins-rev.py [input file] [algorithm to use (1, 2, 3)]")
                print("\tAlgorithm usage: 1 - greedy, 2 - dynamic programming, 3 - both")
                exit(1)

    of.close()
    f.close()


# greedy algorithm, coinVal is an array of coin denominations to use, value is
# the amount to make change for. Returns tuple of array of coins used and number
# of coins used.
def changegreedy(coinVal, value):
    index = len(coinVal) - 1  # start with the largest coin
    coinList = [0] * len(coinVal)
    numCoins = 0

    while value > 0 and index >= 0:
        if coinVal[index] <= value:
            coinList[index] += 1
            value -= coinVal[index]
            numCoins += 1
        else:
            index -= 1

    return coinList, numCoins


# dynamic programming, coinVal is an array of coin denominations to use, value is
# the amount to make change for. Returns tuple of array of coins used and number
# of coins used
def changedp(coinVal, value):
    minCoins = [1000000000] * (value + 1)  # large number as we will be finding min
    minCoins[0] = 0
    usedCoins = [[0 for x in range(len(coinVal))] for i in range(value + 1)]  # store number of each coin type used

    # calculate min coins for each number from 0 to value
    for i in range(1, value + 1):
        for j in range(0, len(coinVal)):
            if coinVal[j] <= i:
                testMin = minCoins[i - coinVal[j]] + 1

                if testMin < minCoins[i]:
                    minCoins[i] = testMin

                    # store number of coins of each denomination needed for current value
                    for x in range(0, len(coinVal)):
                        usedCoins[i][x] = usedCoins[i - coinVal[j]][x]
                    usedCoins[i][j] += 1
                    temp = j - 1
                    while temp >= 0:
                        usedCoins[i][temp] = 0
                        temp -= 1

    return usedCoins[value], minCoins[value]


if __name__ == "__main__":
    main()
