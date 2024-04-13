# FindDuplicate

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
    - T13: post-condition holds

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
