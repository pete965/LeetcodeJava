package Coding_Interview.Sword_Offer_067;

import java.util.Map;

/*
给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.cutRope(4));
    }
    public int cutRope(int target) {
        int output = 0;
        int[][] dp = new int[target][target];
        for (int i=0;i<target;i++){
            dp[0][i] = i+1;
        }
        for (int i=1;i<target;i++){
            for (int j=0;j<target;j++){
                if (j<i){
                    dp[i][j] = -1;
                }else if (j==i){
                    dp[i][j] = 1;
                }else{
                    int max = 0;
                    for (int k=1;k<=j-1;k++){
                        if (dp[i-1][j-k]!=-1){
                            max = Math.max(max,dp[i-1][j-k]*k);
                        }
                    }
                    dp[i][j] = max;
                }
                if (j==target-1){
                    output = Math.max(output,dp[i][j]);
                }
            }
        }
        return output;
    }
}
