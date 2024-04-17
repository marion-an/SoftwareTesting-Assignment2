package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.UniqueElements;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayToBSTTest {

    SortedArrayToBST toBST = new SortedArrayToBST();

    private int[] populateSortedArray(int min, int max, int amt){
        int[] nums = new int[amt];
        for (int i = 0; i < amt; i++) {
            nums[i] = min + i;
        }
        return nums;
    }

    private int[] populateArrayRandomly(int amt){
        int[] nums = new int[amt];
        for(int i = 0; i<amt; i++){
            nums[i] = (int) ((Math.random()) * (5000));
        }
        return nums;
    }

    private boolean validBST(TreeNode head) {
        if (head == null) {
            return true;
        }

        int leftHeight = height(head.left);
        int rightHeight = height(head.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        return validBST(head.left) && validBST(head.right);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    @Test
    void numsIsNull(){
        assertThrows(NullPointerException.class, () -> toBST.sortedArrayToBST(null));
    }

    @Test
    void numsIsEmpty(){
        int [] input = new int[0];
        TreeNode head = toBST.sortedArrayToBST(input);
        assertNull(head);
    }

    @Test
    void numsHasLength1(){
        int[] input = new int[1];
        input[0] = 1;
        TreeNode head = toBST.sortedArrayToBST(input);
        assertEquals(1, head.val);
        assertNull(head.left);
        assertNull(head.right);
    }

    @Test
    void numsHasLengthLarger0AndSmaller10001SortedPositiveAndNegativeNoDuplicatesIntegers(){
        int[] input = populateSortedArray(-10, 10, 20);
        TreeNode head = toBST.sortedArrayToBST(input);
        assertTrue(validBST(head));
    }

    @Test
    void numsValidLengthNotSortedNoDuplicates(){
        int[] nums = {-10, 4, -3, 2, -6, 1, 10};
        assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

    @Test
    void numsValidLengthSortedContainsDuplicates(){
        int [] nums = {1, 1, 2, 3, 4, 5, 6};
        assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

    @Test
    void numsLengthLarger10000(){
        int[] nums = populateSortedArray(-5000, 5001, 10001);
        assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

    @Test
    void numsLength10000SortedNoDuplicates(){
        int[] nums = populateSortedArray(-5000, 5000, 10000);
        TreeNode head = toBST.sortedArrayToBST(nums);
        assertTrue(validBST(head));
    }

    @Test
    void numsLength10000NotSorted(){
        int[] nums = populateArrayRandomly(10000);
        assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

    @Test
    void numsLength10000ContainsDuplicates(){
        int[] nums = populateArrayRandomly(10000);
        nums[4] = 4;
        nums[1005] = 4;
        assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

    @Test
    void numsValidLengthOnlyNegativeIntegers(){
        int[] nums = populateSortedArray(-100, -1, 99);
        TreeNode head = toBST.sortedArrayToBST(nums);
        assertTrue(validBST(head));
    }

    @Test
    void numsValidLengthOnlyPositiveIntegers(){
        int[] nums = populateSortedArray(1, 100, 99);
        TreeNode head = toBST.sortedArrayToBST(nums);
        assertTrue(validBST(head));
    }

    @Test
    void BSTnotHeightBalanced(){
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        assertFalse(toBST.validBST(root));
    }

    @Property
    void validInput(
            @ForAll
            @Size(max = 10000) @UniqueElements
            List<@IntRange(min = -5000, max = 5000) Integer> numbers
    ){
        Collections.sort(numbers);
        int[] nums = convertListToArray(numbers);

        TreeNode head = toBST.sortedArrayToBST(nums);
        assertTrue(validBST(head));
    }

    private int[] convertListToArray(List<Integer> numbers) {
        int[] array = numbers
                .stream()
                .mapToInt(x -> x)
                .toArray();
        return array;
    }

    @Property
    void invalidInputTooManyElements(
            @ForAll
            @Size(min = 10001, max = 12000) @UniqueElements
            List<@IntRange(min = -10000, max = 50000) Integer> numbers
    ){

        Collections.sort(numbers);
        int[] nums = convertListToArray(numbers);

         assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

    @Property
    void invalidInputNotSorted(
            @ForAll
            @Size(min = 50, max = 10000) @UniqueElements
            List<@IntRange(min = -5000, max = 5000) Integer> numbers
    ){

        int[] nums = convertListToArray(numbers);

        assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

    @Property
    void invalidInputDuplicates(
            @ForAll
            @Size(min = 50, max = 12000)
            List<@IntRange(min = -25, max = 20) Integer> numbers
    ){

        Collections.sort(numbers);
        int[] nums = convertListToArray(numbers);

        assertThrows(AssertionError.class, () -> toBST.sortedArrayToBST(nums));
    }

}