package Leetcode.Special_No_1_Counting_Elements;

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countElements(new int[]{1,2,3}));
        System.out.println(solution.countElements(new int[]{1,1,3,3,5,5,7,7}));
        System.out.println(solution.countElements(new int[]{1,3,2,3,5,0}));
        System.out.println(solution.countElements(new int[]{1,1,2,2}));
    }
    public int countElements(int[] arr) {
        HashSet<Integer> hashSet = new HashSet<>();
        int output = 0;
        for (int i=0;i<arr.length;i++){
            hashSet.add(arr[i]);
        }
        for (int i=0;i<arr.length;i++){
            if (hashSet.contains(arr[i]+1)){
                output++;
            }
        }
        return output;
    }
}
