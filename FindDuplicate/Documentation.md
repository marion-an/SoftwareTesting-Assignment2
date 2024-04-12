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

### Post-conditions

- integer to be returned is present in `nums`
- integer to be returned is the duplicate number

### Invariants

- the integers in `nums` have to be in the range [1, `nums.length-1`]
- `nums` length doesn't change
