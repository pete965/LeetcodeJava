package Leetcode_Bytedance.No_120_Triangle;

<<<<<<< Updated upstream
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int length = triangle.size();
        if (length==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[length][length];
        for (int i=0;i<length;i++){
            if (i==0){
                dp[0][0] = triangle.get(0).get(0);
            }else {
                for (int j=0;j<=i;j++){
                    if (j-1>=0){
                        dp[i][j]+=dp[i-1][j-1]+triangle.get(i).get(j);
                        if (j<i){
                            dp[i][j]=Math.min(dp[i][j],triangle.get(i).get(j)+dp[i-1][j]);
                        }
                    }else {
                        dp[i][j]=triangle.get(i).get(j)+dp[i-1][j];
                    }

                }
            }
        }

        for (int num:dp[length-1]){
            min = Math.min(min,num);
        }
        return min;
    }
=======
public class Solution {
>>>>>>> Stashed changes
}
