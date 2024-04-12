package zest;

import java.util.Arrays;
import java.util.List;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        if (nums == null) {
            throw new RuntimeException("Integer array cannot be null.");
        }

        if (nums.length < 2) {
            throw new RuntimeException("Integer array must be at least of length 2.");
        }

        int range = nums.length - 1;
        for (int number : nums) {
            if (1 > number && number > range) {
                throw new RuntimeException(String.format("%d is out of range."));
            }
        }

        int tortoise = nums[0];
        int hare = nums[0];
        // Phase 1: Finding the intersection point of the two runners.
        do {
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while (tortoise != hare);

        // Phase 2: Finding the "entrance" to the cycle.
        tortoise = nums[0];
        while (tortoise != hare) {
            tortoise = nums[tortoise];
            hare = nums[hare];
        }

        int finalHare = hare;

        if (Arrays.stream(nums).noneMatch(number -> number == finalHare)) {
            throw new RuntimeException(String.format("Integer array does not contain %s, which is to be returned", hare));
        }

        long occurrences = Arrays.stream(nums).filter(number -> number == finalHare).count();
        if (occurrences < 2) {
            throw new RuntimeException("Integer to be returned is not the duplicated element");
        }

        if (nums.length != range + 1) {
            throw new RuntimeException("Length of integer array changed.");
        }
        for (int number : nums) {
            if (1 > number && number > range) {
                throw new RuntimeException(String.format("%d is out of range."));
            }
        }
        return hare;
    }
}
