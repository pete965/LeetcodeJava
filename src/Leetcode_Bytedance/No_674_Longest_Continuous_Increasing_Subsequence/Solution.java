package Leetcode_Bytedance.No_674_Longest_Continuous_Increasing_Subsequence;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().findLengthOfLCIS(new int[]{2,1,3}));
    }
    public int findLengthOfLCIS(int[] nums) {
        int output = 1;
        int length = nums.length;
        if (length==0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int local = 0;
        while (right<length){
            System.out.println("right="+right);
            if (right==left||nums[right]>nums[right-1]){
                local++;
                right++;
                output=Math.max(local,output);
            }else {
                left=right;
                right=left;
                local=0;
            }
        }
        return output;
    }
}
