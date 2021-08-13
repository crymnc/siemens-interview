# Distinct Letter Count

## Distinct Letter Count console application made for Siemens

### Installation

- Import the code to any IDE
- Wait for Maven to resolve dependencies
- Run com.siemens.interview.DistinctLetterCount.main()

### Built With

* [Maven](https://maven.apache.org/) - Dependency Management

### Task Description

Count the minimum number of letters that must be deleted from a word to create a word in which no two letters occur the same number of times.

### Specification
Write a program in Java, which can be run on the command line in order to solve this problem. The program should take one command line argument, 
which contains the path to a text file. This text file should contain several lines, each line describing one test case for the problem.


Each line contains a word S consisting of N lowercase letters. The minimum number of letters should be returned that must be deleted to obtain a 
word in which every letter occurs a unique number of times. The occurences of letters that appear at least one in result are the only considered ones.


In case of a constraint violation, your program should indicate this fact to the user, for example by throwing an exception with a descriptive message, 
allowing the user to address this problem.