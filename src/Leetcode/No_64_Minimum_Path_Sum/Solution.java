package Leetcode.No_64_Minimum_Path_Sum;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }
    public int minPathSum(int[][] grid) {
        if (grid.length==0){
            return 0;
        }else if (grid[0].length==0){
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                if (i==0&&j==0){
                    dp[i][j] = grid[0][0];
                }else {
                    if (i-1>=0){
                        if (dp[i][j]==0){
                            dp[i][j] = dp[i-1][j]+grid[i][j];
                        }else {
                            dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+grid[i][j]);
                        }
                    }
                    if (j-1>=0){
                        if (dp[i][j]==0){
                            dp[i][j] = dp[i][j-1]+grid[i][j];
                        }else {
                            dp[i][j] = Math.min(dp[i][j],dp[i][j-1]+grid[i][j]);
                        }
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
