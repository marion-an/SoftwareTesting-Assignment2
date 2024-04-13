package zest;

import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Size;
import net.jqwik.api.constraints.UniqueElements;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindDuplicateTest {

    //Tests for specification-based testing and structural testing
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

    // Tests for Contracts

    @Test
    void preConditionMet() {
        assertEquals(1, FindDuplicate.findDuplicate(new int[]{1, 1}));
        assertEquals(4, FindDuplicate.findDuplicate(new int[]{1, 2, 3, 4, 4}));
        assertEquals(3, FindDuplicate.findDuplicate(new int[]{3, 2, 4, 3, 1, 3}));
        assertEquals(2, FindDuplicate.findDuplicate(new int[]{2, 2, 2, 2, 2}));

    }

    @Test
    void nullInput() {
        Exception exception = assertThrows(RuntimeException.class, () -> FindDuplicate.findDuplicate(null));
        assertEquals("Integer array cannot be null.", exception.getMessage());
    }

    @Test
    void inputLengthOne() {
        Exception exception = assertThrows(RuntimeException.class, () -> FindDuplicate.findDuplicate(new int[]{1}));
        assertEquals("Integer array must be at least of length 2.", exception.getMessage());
    }

    @Test
    void withinRange() {
        assertEquals(2, FindDuplicate.findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    void outOfRange() {
        Exception exception = assertThrows(RuntimeException.class, () -> FindDuplicate.findDuplicate(new int[]{1, 3, 1}));
        assertEquals("3 is out of range.", exception.getMessage());

        Exception exception2 = assertThrows(RuntimeException.class, () -> FindDuplicate.findDuplicate(new int[]{1, 1, 0}));
        assertEquals("0 is out of range.", exception2.getMessage());
    }

    @Test
    void postConditionHoldIntPresent() {
        int[] nums = new int[]{6, 5, 4, 3, 2, 3, 1};
        int[] nums1 = new int[]{1, 4, 3, 5, 2, 3, 3, 3};
        int[] nums2 = new int[]{1, 1};

        assertTrue(Arrays.stream(nums).anyMatch(n -> n == FindDuplicate.findDuplicate(nums)));
        assertTrue(Arrays.stream(nums).anyMatch(n -> n == FindDuplicate.findDuplicate(nums1)));
        assertTrue(Arrays.stream(nums).anyMatch(n -> n == FindDuplicate.findDuplicate(nums2)));
    }

    @Test
    void postConditionHoldDuplicateNumber() {
        int[] nums = new int[]{6, 5, 4, 3, 2, 3, 1};
        int[] nums1 = new int[]{1, 4, 3, 5, 2, 3, 3, 3};

        assertTrue(Arrays.stream(nums).filter(number -> number == FindDuplicate.findDuplicate(nums)).count() >= 2);
        assertTrue(Arrays.stream(nums).filter(number -> number == FindDuplicate.findDuplicate(nums1)).count() >= 2);
    }

    @Test
    void invariantHold() {
        int[] nums = new int[]{1, 2, 3, 4, 2, 2};
        int length = nums.length;
        FindDuplicate.findDuplicate(nums);
        assertEquals(length, nums.length);
    }

    // Tests for property-based testing
    @Property
    @Report(Reporting.GENERATED)
    void duplicateNumber(
            @ForAll
            @Size(50)
            @UniqueElements
            List<@IntRange(min = 1, max = 50) Integer> numbers,
            @ForAll
            @IntRange(max = 49)
            int index,
            @ForAll
            @IntRange(min = 1, max = 50)
            int duplicate
    ) {

        int end = numbers.get(index);
        numbers.add(end);
        numbers.set(index, duplicate);
        int nums[] = numbers.stream().mapToInt(element -> element).toArray();
        assertEquals(duplicate, FindDuplicate.findDuplicate(nums));
    }

}