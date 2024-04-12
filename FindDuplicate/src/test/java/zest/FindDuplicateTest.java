package zest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindDuplicateTest {
    @Test
    void minLength() {
        int[] nums = new int[]{1, 1};
        assertEquals(1, FindDuplicate.findDuplicate(nums));
    }

    @Test
    void longerThanMinLength() {
        int[] nums = new int[]{2, 3, 1, 4, 2, 7, 5, 6};
        assertEquals(2, FindDuplicate.findDuplicate(nums));
    }

    @Test
    void nDifferentIntegers() {
        int[] nums = new int[]{3, 1, 2, 1};
        assertEquals(1, FindDuplicate.findDuplicate(nums));
    }

    @Test
    void lessThanNDifferentIntegers() {
        int[] nums = new int[]{1, 1, 1};
        assertEquals(1, FindDuplicate.findDuplicate(nums));
    }

    @Test
    void ascendingOrder() {
        int[] nums = new int[]{1, 2, 3, 4, 3, 5, 6};
        assertEquals(3, FindDuplicate.findDuplicate(nums));
    }

    @Test
    void descendingOrder() {
        int[] nums = new int[]{6, 5, 4, 3, 2, 3, 1};
        assertEquals(3, FindDuplicate.findDuplicate(nums));
    }

    @Test
    void duplicatesAfterEachOther() {
        int[] nums = new int[]{3, 1, 1, 4, 2};
        assertEquals(1, FindDuplicate.findDuplicate(nums));
    }

}