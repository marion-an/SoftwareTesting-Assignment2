package zest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestIncreasingSubsequenceTest {

    LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();

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


}