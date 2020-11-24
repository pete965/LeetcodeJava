package Leetcode_Bytedance.No_221_Maximal_Square;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}});
    }
    public int maximalSquare(char[][] matrix) {
        if (matrix.length==0){
            return 0;
        }
        int max = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0;i<matrix[0].length;i++){
            if (matrix[0][i]=='1'){
                dp[0][i] = 1;
                max=1;
            }
        }
        for (int i=0;i<matrix.length;i++){
            if (matrix[i][0]=='1'){
                dp[i][0] = 1;
                max=1;
            }
        }
        for (int i=1;i<matrix.length;i++){
            for (int j=1;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1]))+1;
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        for (int[] i:dp){
            System.out.println(Arrays.toString(i));
        }

        return max*max;
    }
}
