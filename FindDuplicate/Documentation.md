# FindDuplicate
## Specification-based testing
According to the book chapter 3.2 structural testing complements specification-based testing and specification-based testing is done prior to structural testing. Therefore, we have decided to specification-based testing as well.

### 1. Understand the requirement, inputs, and outputs

Method: `findDuplicate(int[] nums)`

find the duplicate number in an array

- `nums`: integer array

return duplicate number

### 2. Explore the program
We wrote some tests to see how the program behaves

### 3. Explore possible inputs and outputs, and identify partitions
Input parameters:
- `nums` parameter: the integers in `nums` have to be in the range [1, `nums.length`]
    - integer array of length >= 2

- no combination of input parameters possible, as only 1 input parameter exists

Output parameters:
-  positive Integer 
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

## Mutation testing
- mutation coverage: 95% --> 20 out of 21 mutants were killed

  line 28: changed conditional boundary --> survived

- This case is already addressed T10 and T12.

  Because we get the same result when we evaluate the condition to true in line 28 in case the conditional operator is
  changed to '>=' or if it evaluates to false if the conditional operator is '>' for 2^31 - 1 and -2^31, the program
  doesn't realise that the mutant actually would be killed if the results would differ.
