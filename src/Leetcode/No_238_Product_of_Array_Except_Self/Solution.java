package Leetcode.No_238_Product_of_Array_Except_Self;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.productExceptSelf(new int[]{1,2,3,4})));
    }
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        int[] right = new int[length];
        for (int i=0;i<length;i++){
            if (i==0){
                left[i] = 1;
            }else {
                left[i] = left[i-1] * nums[i-1];
            }
        }
        for (int i=length-1;i>=0;i--){
            if (i==length-1){
                right[i] = 1;
            }else {
                right[i] = right[i+1] * nums[i+1];
            }
        }
        int[] output = new int[length];
        for (int i=0;i<length;i++){
            output[i] = left[i] * right[i];
        }
        return output;
    }
}
