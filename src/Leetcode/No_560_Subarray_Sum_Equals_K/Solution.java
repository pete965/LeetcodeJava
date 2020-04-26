package Leetcode.No_560_Subarray_Sum_Equals_K;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(new int[]{28,54,7,-70,22,65,-6},100));
    }
    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        int localSum = 0;
        int count =0;
        for (int i=0;i<length;i++){
            for (int j=i;j<length;j++){
                localSum+=nums[j];
                if (localSum==k){
                    count++;
                }
            }
            localSum = 0;
        }
        return count;
    }
}
