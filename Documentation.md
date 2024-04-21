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


# MergeKSortedLists

## Specification-based testing
### 1. Understand the requirement, inputs, and outputs

Method: `mergeKLists(ListNode[] lists)`

merges k sorted in ascending order linked lists into one linked list
- `lists`: list or ListNodes

return one sorted, in ascending order, linked list containing all the nodes from lists

### 2. Explore the program

Wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:

- `lists`:
  - Can be null
  - Can be empty (length 0)
  - Can have length >= 1
  - the values of ListNodes in `lists` have to be in the range [-10000, 10000]
  - total amount of ListNodes all linked lists is in range  [0, 10000]
  - The lists in `lists` have to be sorted in ascending order

- no combination of input parameters possible, as only 1 input parameter exists

Output parameters:

- the head of the final linked list
- the final linked list is sorted in ascending order

### 4. Analyze the boundaries
- `lists` having length 1
- Amount of ListNodes is exactly 10000
- ListNode.value = 10000
- ListNode.value = -10000

### 5. Devise test cases
- T1: `lists` is null 
- T2: `lists` has length = 0
- T3: `lists` has length 1 and constraints are satisfied
- T4: `lists` has length 1 and linked list is not sorted in ascending order
- T5: `lists` has length > 1 and constraints are satisfied
- T6: `lists` has length > 1 and a value of a ListNode is > 10000
- T7: `lists` has length > 1 and value of a ListNode is < -10000
- T8: `lists` has length > 1 and amount of ListNodes is 10000
- T9: `lists` has length > 1 and amount of ListNodes is greater than 10000
- T10: `lists` has length = 1 and amount of ListNodes is 10000
- T11: `lists` has length = 1 and amount of ListNodes is greater than 10000
- T12: `lists` has length > 1 and contains a list that is not sorted in ascending order

### 6. Automate the test cases

see: `MergeKSortedListTest.java`

### 7. Augment the test suite with creativity and experience

- T13: there exists multiple nodes with the same values in `lists` 

## Structural testing

- line coverage: 14/14 lines covered 

## Designing contracts

### Pre-conditions

- Number of nodes in all the linked lists in `lists` can be at most 10000 
- -10000 <= node.val <= 10000 for all ListNodes 
- length of `lists` >= 1 -> remove line `if (lists == null || lists.length == 0) return null;` and replace with 
` assert lists.length >= 1  : "number of linkes lists has to be a positive integer";`
- all the linked lists in `lists` need to be sorted in ascending order

### Post-conditions

- the amount of nodes in the merged linked list needs to be the same as the initial amount of nodes
- returned linked list needs to be sorted in ascending order


## Testing contracts

### Pre-conditions

- Number of nodes in all the linked lists in `lists` can be at most 10000 -> `T9`, `T11`
- -10000 <= node.val <= 10000 for all ListNodes -> `T6`, `T7`
- length of `lists` >= 1 -> `T2` needs to be changed to check for thrown assertion error, `T1`
- all the linked lists in `lists` need to be sorted in ascending order -> `T4` and `T12`

### Post-conditions

- the amount of nodes in the merged linked list needs to be the same as the initial amount of nodes
-> create `T14` `finalAmountOfNodesSameAsInitial`
- returned linked list needs to be sorted in ascending order -> `T3` `T5`

-> Resulting Line Coverage: 48/48 lines

## Property-based testing

- `Property 1`: Valid Input:
Given a list `lists` of `k`  sorted (in ascending order) linked lists, in which all nodes combined are in the range [0, 10000]
and the values of the nodes is in the range [-10000, 10000] and where with `k` >= 1, the program should
merge all the nodes of the lists in `lists` into a single sorted (in ascending order) linked list and return it.
-> `T15` `validInput`

- `Property 2`: Invalid Input:
For all invalid instances of `lists` (Violating the constraints from `Property 1`) the program must throw an
error. -> `T16` `invalidInput`




# SortedArray2BST

## Specification-based testing
### 1. Understand the requirement, inputs, and outputs

Method: `sortedArrayToBST(int[] nums)` 

Given an array `nums` where elements are sorted in ascending order, `sortedArrayToBST` should `nums` to a height-balanced 
binary search tree (BST), where the depth of the two subtrees of every node never differs by more than 1. `sortedArrayToBST`
should return the obtained BST.

### 2. Explore the program

Wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions

Input parameters:

- `nums`:
  - Is null
  - Is empty (length 0)
  - Has length >= 1
  - Has length > 10'000
  - Elements of `nums` are sorted in ascending order
  - Elements of `nums` are not sorted in ascending order
  - `nums` contains only unique integers
  - `nums` contains duplicates
  - `nums` contains only integers < 0
  - `nums` contains only integers > 0
  - `nums` contains integers > 0 as well as <= 0

Output parameters:

- the root, a `TreeNode`, of the BST if `nums` has length >= 1
- null if `nums` is empty

### 4. Analyze the boundaries

- `nums` has length 1
- `nums` has length 10'000

### 5. Devise test cases
- T1: `nums` is null
- T2: `nums` has length = 0
- T3: `nums` has length 1 
- T4: `nums` has length >= 1 and <= 10'000 and is sorted in ascending order and contains only unique integers <= 0 and
as well as > 0
- T5: `nums` has length >= 1 and <= 10'000 and is not sorted in ascending order
- T6: `nums` has length >= 1 and <= 10'000 and contains duplicates
- T7: `nums` has length > 10'000
- T8: `nums` has length 10'000, is sorted in ascending order and has no duplicates
- T9: `nums` has length 10'000 and is not sorted in ascending order
- T10: `nums` has length 10'000 and contains duplicates
- T11: `nums` has length >= 1 and <= 10'000 and contains only negative integers
- T12: `nums` has length >= 1 and <= 10'000 and contains only positive integers

### 6. Automate the test cases

see: `SortedArrayToBSTTest.java`

### 7. Augment the test suite with creativity and experience


## Structural testing

- `T10`, `T9`, `T7`, `T6`, and `T5` -> fail -> test related to pre- and post-conditions

## Designing contracts

### Pre-conditions

- `nums` only contains unique integers
- `nums` is sorted in ascending order
- length of `nums` is in range [0, 10'000] 

### Post-conditions

- the return value `node` needs to be the head of a height balanced BST
- the BST needs to contain the same amount of nodes as `nums`


### Invariants

- `nums` cannot change throughout the whole lifetime of the `sortedArrayToBST` method.

## Testing contracts

### Pre-conditions

- `nums` only contains unique integers -> `T6`, `T10`
- `nums` is sorted in ascending order -> `T5`, `T9`
- length of `nums` is in range [0, 10'000] -> `T7`


### Post-conditions

-> `T3`, `T4`, `T8`, `T11`, `T12`

### Invariants

- Assign `nums` after precondition check to class variable `nums` and compare the
class variable `nums` to local variable `nums` after each recursive call of constructBSTRecursive.

Overall:
-> Resulting Line Coverage: 54/55 lines

-> can write `T13` that validates that `validBST` returns false in case of a not height balance BST
-> line coverage: 55/55 lines
## Property-based testing

- `Property 1`: Valid Input:
  Given a sorted (in ascending order) array `nums` with no duplicate, and at most 10'000 values `sortedArrayToBST` should return a height
balanced BST.
  -> `T14` `validInput`

- `Property 2`: Invalid Input:
  For all invalid instances of `nums` (Violating the constraints from `Property 1`) the program must throw an
  error. -> `T15` `invalidInputNotSorted`, `T16` `invalidInputDuplicates`
`T17` `invalidInputTooManyElements`



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


# UniquePathsGrid

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
- `integer m & n`
  - 1 (if either of the two values the result will always be 1)
  - 2 (if both go over 2 the result is stricly higher than 1)

### 5. Devise test cases
- `integer m` is 1
  - T1: `integer n` is 1
  - T2: `integer n` is 3
- `integer m` is 2
  - T3: `integer n` is 1
  - T4: `integer n` is 5
- `integer m` is 4
  - T5: `integer n` is 1
  - T6: `integer n` is 4

### 6. Automate the test cases

- have a look at [tests](UniquePathsGrid/src/test/java/zest/UniquePathsTest.java)

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
