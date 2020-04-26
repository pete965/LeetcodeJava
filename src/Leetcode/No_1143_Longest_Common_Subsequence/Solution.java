package Leetcode.No_1143_Longest_Common_Subsequence;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde","ade"));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        if (length1==0||length2==0){
            return 0;
        }
        int[][] dp = new int[length1+1][length2+1];
        for (int i=1;i<length1+1;i++){
            for (int j=1;j<length2+1;j++){
                int can1 = dp[i-1][j];
                int can2 = dp[i][j-1];
                int can3 = dp[i-1][j-1];
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    can3++;
                }
                dp[i][j] = Math.max(can1,can2);
                dp[i][j] = Math.max(dp[i][j],can3);
            }
        }
        return dp[length1][length2];
    }
}
