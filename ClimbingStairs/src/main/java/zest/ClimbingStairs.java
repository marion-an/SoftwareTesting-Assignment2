package zest;

public class ClimbingStairs {
    public static long climbStairs(int n) {

        if (n < 0) {
            throw new RuntimeException("Integer cannot be negative.");
        }

        if (n > 45) {
            throw new RuntimeException("Integer too big.");
        }

        if (n <= 2) {
            return n;
        }

        long oneStepBefore = 2;
        long twoStepsBefore = 1;
        long allWays = 0;

        for (int i = 2; i < n; i++) {
            allWays = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        return allWays;
    }
}

