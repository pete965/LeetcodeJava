package Leetcode_Bytedance.No_15_3SUM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1,0,1,2,-1,-4}).toString());
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        if (length<=2){
            return lists;
        }
        Arrays.sort(nums);
        for (int i=0;i<length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i+1;
            int right = length-1;
            while (left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    lists.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while (left<right&&nums[right]==nums[right+1]){
                        right--;
                    }
                    while (left<right&&nums[left]==nums[left-1]){
                        left++;
                    }
                }else if (sum > 0){
                    right--;
                }else {
                    left++;
                }
            }
        }
        return lists;
    }
}
