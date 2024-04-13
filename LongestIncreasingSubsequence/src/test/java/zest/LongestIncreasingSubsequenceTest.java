package zest;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Report;
import net.jqwik.api.Reporting;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

    // Tests for specification-based testing and structural testing
    @Test
    void lengthZero() {
        int[] nums = new int[]{};
        assertEquals(0, lis.lengthOfLIS(nums));
    }

    @Test
    void lengthOne() {
        int[] nums = new int[]{1};
        assertEquals(1, lis.lengthOfLIS(nums));
    }

    @Test
    void lengthLargerThanOne() {
        int[] nums = new int[]{-1, 4, 3};
        int[] nums2 = new int[]{4, -1, 3};
        assertEquals(2, lis.lengthOfLIS(nums));
        assertEquals(2, lis.lengthOfLIS(nums2));
    }

    @Test
    void noDuplicates() {
        int[] nums = new int[]{-1, 0, 1, 4, 3};
        assertEquals(4, lis.lengthOfLIS(nums));
    }

    @Test
    void duplicates() {
        int[] nums = new int[]{-1, 0, 1, 1, 4, 3};
        assertEquals(4, lis.lengthOfLIS(nums));
    }

    @Test
    void onlyNegativeNumbers() {
        int[] nums = new int[]{-50, -13, -5, -33};
        assertEquals(3, lis.lengthOfLIS(nums));
    }

    @Test
    void onlyPositiveNumbers() {
        int[] nums = new int[]{50, 13, 5, 33};
        assertEquals(2, lis.lengthOfLIS(nums));
    }

    @Test
    void increasingOrder() {
        int[] nums = new int[]{1, 2, 3, 5, 8};
        assertEquals(5, lis.lengthOfLIS(nums));
    }

    @Test
    void decreasingOrder() {
        int[] nums = new int[]{16, 8, 4, 2, 1};
        assertEquals(1, lis.lengthOfLIS(nums));
    }

    @Test
    void singleValue() {
        int[] nums = new int[]{2, 2, 2, 2, 2, 2, 2, 2};
        assertEquals(1, lis.lengthOfLIS(nums));
    }


    //Test for Contracts
    @Test
    void preConditionMet() {
        assertEquals(4, lis.lengthOfLIS(new int[]{-1, 5, 3, 6, 7, -10}));
        assertEquals(4, lis.lengthOfLIS(new int[]{4, -1, 3, -1, -10, 30, 50}));
        assertEquals(0, lis.lengthOfLIS(new int[]{}));

    }

    @Test
    void nullInput() {
        Exception exception = assertThrows(RuntimeException.class, () -> lis.lengthOfLIS(null));
        assertEquals("Input cannot be null.", exception.getMessage());
    }

    @Test
    void postConditionHold() {
        assertEquals(1, lis.lengthOfLIS(new int[]{-1}));
        assertEquals(1, lis.lengthOfLIS(new int[]{5, 5, 5, 5}));
        assertEquals(2, lis.lengthOfLIS(new int[]{4, -1, 3}));
    }

    @Test
    void invariantsHold() {
        assertEquals(1, lis.lengthOfLIS(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1}));
        assertEquals(2, lis.lengthOfLIS(new int[]{1, 2, 1, 2, 1, 2}));
        assertEquals(3, lis.lengthOfLIS(new int[]{-3, -8, 3, 1, 7, 0}));
    }

    @Property
    @Report(Reporting.GENERATED)
    void nonNegativeReturn(@ForAll int[] nums) {
        assertTrue(lis.lengthOfLIS(nums) >= 0);
    }

    @Property
    @Report(Reporting.GENERATED)
    void returnWithinRange(@ForAll int[] nums) {
        assertTrue(lis.lengthOfLIS(nums) <= nums.length);
    }
}