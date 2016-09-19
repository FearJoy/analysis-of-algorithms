import os
import sys

def main():
    print("Making numbers...")

    # Replace this name with the name of the problem you are generating numbers to solve
    outfile = "problem6.txt"
    of = open(outfile, 'w')

    # Use a1 and a2 to specify the value/amount range that needs to be calculated
    # Step is the amount to increase i by
    a1 = 2000
    a2 = 2200
    step = 1

    # This will print the coins in array format, a new line, the value at i, a new line
    # a2 + step is used to include the last number in the range, otherwise it gets dropped
    for i in range(a1, a2+step, step):
        of.write("[1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30]")
        of.write("\n")
        of.write(str(i))
        of.write("\n")

    # Close the output stream
    of.close()

    print("Done!")


if __name__ == "__main__":
    main()
