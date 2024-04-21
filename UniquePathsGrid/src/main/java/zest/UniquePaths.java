package zest;

public class UniquePaths {
    public int uniquePaths(int m, int n) {

        if(m < 1 || n < 1){
            return 0;
        }

        int[][] dp = new int[m][n];
        assert gridGreaterCheck(dp);

        // Initialize the first row and column to 1 since there's only one way to reach any cell in the first row or column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        assert gridGreaterCheck(dp);

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        assert gridGreaterCheck(dp);

        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // The number of paths to the current cell is the sum of the paths to the cell above and to the left
            }
        }

        assert gridGreaterCheck(dp);

        if(dp[m-1][n-1] < 0){
            throw new ArithmeticException();
        }

        if((m == 1 || n == 1) && dp[m-1][n-1] != 1){
            throw new ArithmeticException();
        }

        return dp[m - 1][n - 1]; // The bottom-right cell contains the total number of unique paths
    }

    private boolean gridGreaterCheck(int[][] grid){
        int rows = grid.length;
        int columns = grid[0].length;
        int old;

        for(int i=1; i<rows;i++){
            for(int j=1;j<columns;j++){
                if(grid[i][j] != 0 && grid[i][j] != grid[i-1][j] + grid[i][j-1]){
                    return false;
                }
            }
        }
        return true;
    }
}
