package Leetcode_Bytedance.No_3_Longest_Substring_Without_Repeating_Characters;

import java.util.*;

class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int n = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(n);
    }

    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int max = 0;
        int i=0;
        int j=0;
        Set<Character> set = new HashSet<>();
        while(i<length&&j<length){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(max,j-i);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}