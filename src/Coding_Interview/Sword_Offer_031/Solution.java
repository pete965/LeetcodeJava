package Coding_Interview.Sword_Offer_031;

/*
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        if (n==0){
            return 0;
        }
        int[] dp = new int[n+1];
        int output = 1;
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2;i<=n;i++){
            if (i%10==1){
                dp[i] = dp[i/10] + 1;
            }else {
                dp[i] = dp[i/10];
            }
            output+=dp[i];
        }
        return output;
    }
}
