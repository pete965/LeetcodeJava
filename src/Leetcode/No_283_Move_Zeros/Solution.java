package Leetcode.No_283_Move_Zeros;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = new int[]{0,1,0,3,12};
        int[] test2 = new int[0];
        solution.moveZeroes(test1);
        System.out.println(Arrays.toString(test1));
        solution.moveZeroes(test2);
        System.out.println(Arrays.toString(test2));
    }
    public void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0;fast<nums.length;fast++){
            if (nums[fast]!=0){
                swap(nums,fast,slow);
                slow++;
            }
        }
    }

    private void swap(int[] nums, int fast, int slow) {
        int mid = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = mid;
    }
}
