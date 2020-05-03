package Leetcode_Bytedance.No_128_Longest_Consecutive_Sequence;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
//        System.out.println(solution.longestConsecutive());
//        System.out.println(solution.longestConsecutive());
//        System.out.println(solution.longestConsecutive());
    }
    public int longestConsecutive(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int output = 1;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i:nums){
            hashSet.add(i);
        }
        for (int i:nums){
            System.out.println("For number:"+i);
            if (hashSet.contains(i+1)){
                continue;
            }else if (hashSet.contains(i-1)){
//                System.out.println("Begin to count elements");
                //Counting Elements
                int local = i;
                int count = 1;
                while (hashSet.contains(local-1)){
//                    System.out.println("Count++");
                    count++;
                    local--;
                }
                output = Math.max(count,output);
            }
        }
        return output;
    }
}
