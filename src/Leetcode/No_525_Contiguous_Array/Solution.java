package Leetcode.No_525_Contiguous_Array;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMaxLength(new int[]{0,1}));
    }
    public int findMaxLength(int[] nums) {
        int output = 0;
        int length = nums.length;
        int count = 0;
        HashMap<Integer,Integer> hashMap = new HashMap();
        hashMap.put(0,-1);
        for (int i=0;i<length;i++){
            if (nums[i]==0){
                count--;
            }else {
                count++;
            }
            if (hashMap.containsKey(count)){
                output = Math.max(output,i-hashMap.get(count));
            }else {
                hashMap.put(count,i);
            }
        }
        return output;
    }
}
