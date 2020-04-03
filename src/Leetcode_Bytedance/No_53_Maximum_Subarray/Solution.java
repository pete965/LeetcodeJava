package Leetcode_Bytedance.No_53_Maximum_Subarray;

class Solution {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        int length =nums.length;
        if (length==0){
            return 0;
        }
        if (length == 1){
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i=1;i<length;i++){
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            if (dp[i]>max){
                max=dp[i];
            }
        }
        return max;
    }
}
