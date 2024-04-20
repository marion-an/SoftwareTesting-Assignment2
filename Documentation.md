# ClimbingStairs

## Specification-based testing

According to the book chapter 3.2 structural testing complements specification-based testing and specification-based
testing is done prior to structural testing. Therefore, we have decided to specification-based testing as well.

### 0. Notes and comments

We'll add a line in the code, if the input is negative, we return an error (so the output is non-negative)
-> if (n < 0) {return 0;}

if the input is too big for integer, we return an error
if (n > 45) {throw new RuntimeException("Integer too big.");}

made climbStairs static
-> public static long climbStairs(int n)

### 1. Understand the requirement, inputs, and outputs

Method: `climbStairs(int n)`

how many distinct ways can you climb to the top of n stairs when you can either climb 1 or 2 steps.

input:
- `n`: positive integer

output:
we return a non-negative integer (number of distinct way to climb stairs)

### 2. Explore the program

We wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:

- `n` parameter: a positive integers

- no combination of input parameters possible, as only 1 input parameter exists


Output parameters:

- non-negative integer

### 4. Analyze the boundaries

- `n` = 0 (lower bound)


### 5. Devise test cases

- T1: `n` = 0
- T2: `n` = 1
- T3: `n` = 2
- T4: `n` = 3
- T5: `n` = 4
- T6: `n` = 5
- T7: `n` = -1 and `n` = 46


### 6. Automate the test cases

see: [ClimbStairsTest.java](ClimbingStairs/src/main/java/zest/ClimbingStairs.java)

### 7. Augment the test suite with creativity and experience

- T8: `n` = 10

## Structural testing

- line coverage: 100% (91% overall, because the method is static. The class is never instantiated)

## Designing contracts

### Pre-conditions

- `n` should be a positive integer

### Post-conditions

- integer to be returned is non negative
- integer to be returned is number of distinct ways to climb n stairs


### Invariants

- `allWays` is correctly updated throughout the loop to compute the distinct ways to climb n stairs.

## Testing contracts

### Pre-conditions

- `n` should be a positive integer
  - T9: pre-condition not met
  - T10: pre-condition met

### Post-conditions

- integer to be returned is non negative
  - T11: pre-condition met

- integer to be returned is number of distinct ways to climb n stairs

### Invariants

- `allWays` is correctly updated throughout the loop to compute the distinct ways to climb i_th stairs.
  - T12: invariant maintained

## Property-based testing
### 1. Property:

- the output is correctly updated each floor ascendingly (we output the i_th distinct ways to climb i_th stairs)
  This property has to hold true for every input.


# FindDuplicate

## Specification-based testing

According to the book chapter 3.2 structural testing complements specification-based testing and specification-based
testing is done prior to structural testing. Therefore, we have decided to specification-based testing as well.

### 1. Understand the requirement, inputs, and outputs

Method: `findDuplicate(int[] nums)`

find the duplicate number in an array

- `nums`: integer array

return duplicate number

### 2. Explore the program

We wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:

- `nums` parameter: the integers in `nums` have to be in the range [1, `nums.length-1`]
    - integer array of length >= 2

- no combination of input parameters possible, as only 1 input parameter exists

Output parameters:

- positive Integer

### 4. Analyze the boundaries

- `nums` having length 2
- `nums` contains `n` different integer with length `n + 1`

### 5. Devise test cases

- T1: `nums` has length 2
- T2: `nums` has length > 2
- T3: `nums` contains `n` different integer with length `n + 1`
- T4: `nums` contains less than `n` different integer with length `n + 1`

### 6. Automate the test cases

see: [FindDuplicateTest.java](FindDuplicate/src/main/java/zest/FindDuplicate.java)

### 7. Augment the test suite with creativity and experience

- T5: the integers in `nums` are in ascending order
- T6: the integers in `nums` are in descending order
- T7: duplicates in `nums` are right after each other

## Structural testing

- line coverage: 100% (92% overall, because the method is static. The class is never instantiated)

## Designing contracts

### Pre-conditions

- `nums` should not be null
- `nums` has to contain at least 2 elements
- the integers in `nums` have to be in the range [1, `nums.length-1`]

### Post-conditions

- integer to be returned is present in `nums`
- integer to be returned is the duplicate number

### Invariants

- `nums` length doesn't change

## Testing contracts

### Pre-conditions

- `nums` should not be null
    - T8: pre-condition met
    - T9: pre-condition not met
- `nums` has to contain at least 2 elements
    - pre-condition met covered by T8
    - T10: pre-condition not met
- The integers in `nums` have to be in the range [1, `nums.length-1`]
  - T11: pre-condition met
  - T12: pre-condition not met


### Post-conditions

- integer to be returned is present in `nums`
    - T13: post-condition holds
- integer to be returned is the duplicate number
    - T14: post-condition holds

### Invariants

- `nums` length doesn't change
    - T15: invariant maintained

## Property-based testing
### 1. Property:
- the value to be returned is the duplicate number
This property has to hold true for every input.
- T16


# Longest Increasing Subsequence

## Specification-based testing

According to the book chapter 3.2 structural testing complements specification-based testing and specification-based
testing is done prior to structural testing. Therefore, we have decided to specification-based testing as well.

### 1. Understand the requirement, inputs, and outputs

Method: `lengthOfLIS(int[] nums)`

find the longest strictly increasing subsequence

- `nums`: integer array

return length of the longest strictly increasing subsequence

### 2. Explore the program

We wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:

- `nums` parameter: integer array can contain any integer (negative and positive)

- no combination of input parameters possible, as only 1 input parameter exists

Output parameters:

- positive Integer

### 4. Analyze the boundaries

- `nums` having length 1
- `nums` contains no duplicates

### 5. Devise test cases

- T1: `nums` has length 0
- T2: `nums` has length 1
- T3: `nums` has length > 1
- T4: `nums` contains no duplicates
- T5: `nums` contains duplicates

### 6. Automate the test cases

see: [LongestIncreasingSubsequence.java](LongestIncreasingSubsequence/src/test/java/zest/LongestIncreasingSubsequenceTest.java)

### 7. Augment the test suite with creativity and experience

- T6: `nums` contains only negative numbers
- T7: `nums` contains only positive numbers
- T8: `nums` is in increasing order
- T9: `nums` is in decreasing order
- T10: `nums` contains only a single value

## Structural testing

- line coverage: 100%

## Designing contracts

### Pre-conditions

- `nums` is not null

### Post-conditions

- integer to be returned is non-negative (>=0)

### Invariants

- `nums` length doesn't change
- length of the strictly increasing subsequence is non-negative (>=0)

## Testing contracts

### Pre-conditions

- `nums` is not null
    - T11: pre-condition met
    - T12: pre-condition not met

### Post-conditions

- integer to be returned is non-negative (>=0)
    - T13: post-condition hold

### Invariants

- `nums` length doesn't change
    - T14: invariant maintained
- length of the strictly increasing subsequence is non-negative (>=0)
    - covered by T13

## Property-based testing

### 1. Property:

- the value to be returned is non-negative (>=0):

This property has to hold true for every input because it is not possible that the subsequence has a negative length.

- T15

### 2. Property:

- the value to be returned is not greater than the length of `nums`

This property has to hold true for every input because it is not possible that the subsequence is larger than the whole
sequence.

- T16


# SumOfTwoIntegers

### 1. Understand the requirement, inputs, and outputs

The class SumOfTwoIntegers contains one method called getSum which takes two integers as input and will give the result of adding the two as output.

### 2. Explore the program

Wrote some simple print statements and some method calls to see how to program runs

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:

- `integer a & b`
  - can both be positive
  - either one can be 0
  - one can be negative
  - both can be negative
  - Note: it is assumed the integers are in the 32 bit range

Output parameters:

- `integer c`
  - can be positive
  - can be 0
  - can be negative
  - can need less bits than `a or b`
  - can use more bits than `a or b`

### 4. Analyze the boundaries
- `integer a & b`
  - 0 => 1, 0, -1
  - null => null

### 5. Devise test cases

- `integer a` is null
  - `integer b` is positive (nothing specified how to handle this in readme => will not be covered)
- `integer a` is positive
  - T1: `integer b` is positive and has more bits than a
  - T2: `integer b` is positive and has less bits than a
  - T3: `integer b` is 0
  - T4: `integer b` is negative and has more bits than a
  - T5: `integer b` is negative and has less bits than a
- `integer a` is 0
  - T6: `integer b` is 0
- `integer a` is negative
  - T7: `integer b` is positive
  - T8: `integer b` is negative and has more bits than a
  - T9: `integer b` is negative and has less bits than a


### 6. Automate the test cases

have a look at [Tests](SumofTwoIntegers/src/test/java/zest/SumOfTwoIntegersTest.java)

### 7. Augment the test suite with creativity and experience

- T10: since the adding is done in binary we derive another test case where `integer a` is 0 and `integer b` has some negative value since the order could make a difference for the result

## Structural testing

- line coverage of 100%
- branch coverage of 100%
- mutation tests 7/7 mutants killed

## Designing contracts

### Pre-conditions

- Inputs `a & b` are both integers and not null (since the type is int which can't be null this is already satisfied with Integer instead of int it could be done explicit)

### Post-conditions

- The output `c` is an integer which is not null (also int type, therefore same logic as above)

### Invariants

- None which are useful

## Testing contracts

### Pre-conditions

- T11: Check that a null value raises NullPointerException

### Post-conditions

- T12: If no null values are provided the result gives the correct integer

### Invariants

- Intentionally empty

## Property-based testing
### 1. Property:
- the return value is a positive integer if both inputs are positive
- Note here that the tests fail and give an error if we check this since if one of the values is the highest possible integer the program will not be able to handle it, probably since the underlying system uses 32 bit integers and therefore if we add to this number it behaves not as wanted, but becomes negative. Therefore for the tests to pass a maximum of 5000 is set.
- T13

### 2. Property
- the return value is a negative integer if both inputs are negative
- this holds for all negative input values
- T14

### 3. Property
- the return value is always the addition of the two values
- T13/T14


# SumOfTwoIntegers

### 1. Understand the requirement, inputs, and outputs

The class UniquePaths contains a single function called uniquePaths which recursively finds the number of paths which exists to get from a grid from the top left to the bottom right. The function takes two integers as input which define the size of the grid and returns the number of unique paths as the output.
### 2. Explore the program

Wrote some simple print statements and some method calls to see how to program runs

### 3. Explore possible inputs and outputs, and identify partitions

input parameters:
- `integer m & n`
  - are both strictly positive
  - are both not null

output parameters:
- `integer dp`
  - is a strictly positive value
  - is not null

### 4. Analyze the boundaries
- `integer a & b`
  - 1 (if either of the two values the result will always be 1)
  - 2 (if both go over 2 the result is stricly higher than 1)

### 5. Devise test cases
- `integer a` is 1
  - T1: `integer b` is 1
  - T2: `integer b` is 3
- `integer a` is 2
  - T3: `integer b` is 1
  - T4: `integer b` is 5
- `integer a` is 4
  - T5: `integer b` is 1
  - T6: `integer b` is 4

### 6. Automate the test cases

- have a look at [tests](UniquePathsGrid/src/test/java/zest/uniquePathsTest.java)

### 7. Augment the test suite with creativity and experience
- T7: use some high numbers to verify calculation is actually correct

## Structural testing

- Line coverage 100%
- Branch coverage 100%
- Mutants killed 14/14
- Note the coverage measure is before the invariantchecks

## Designing contracts

### Pre-conditions

- `integer m & n` both need to be positive integers strictly greater than 0

### Post-conditions

- the returned value will always be positive and strictly greater than 0
- if either of the inputs is 1 the output will be 1 aswell

### Invariants
- once instantiated the grid size never changes
- values in the grid are either the sum of the values above and to the left or 0

## Testing contracts

### Pre-conditions

- Soft return, the method will return 0 if the inputs are below 1
- T8: input below 1

### Post-conditions

- T1,T2,T5 prove the point regarding one value being 1
- The other tests show that the return value is always positive

### Invariants

- since the variant is enforced with assert statements all the tests would fail if the condition would not hold
- a failing test can't be provided since the invariant is always true

## Property-based testing
### 1. Property:
- the value to be returned is 1
this property holds true as long as at least one of the two input values is 1
- T9

### 2. Property
- the value to be returned is strictly positive
this property holds for all input values
- T10

### 3. Property
- the value to be returned is 0
this is by design, as soon as either of the inputs goes below 1