package zest;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null) {
            throw new RuntimeException("Input can not be null.");
        }

        int length = nums.length;

        if (nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1; // Each element is an increasing subsequence of length 1

            // Check all previous elements to find longer increasing subsequences
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLength = Math.max(maxLength, dp[i]);
        }

        if (maxLength < 0) {
            throw new RuntimeException("Value to be returned cannot be negative");
        }

        if (length != nums.length) {
            throw new RuntimeException("Integer array has changed");
        }
        return maxLength;
    }
}
