package Leetcode.No_383_Ransom_Note;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canConstruct("a","b"));
        System.out.println(solution.canConstruct("aa","ab"));
        System.out.println(solution.canConstruct("aa","aab"));
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransom = new int[26];
        int[] mag = new int[26];
        for (int i=0;i<ransomNote.length();i++){
            ransom[ransomNote.charAt(i)-'a']++;
        }
        for (int i=0;i<magazine.length();i++){
            mag[magazine.charAt(i)-'a']++;
        }
        for (int i=0;i<26;i++){
            if (ransom[i]>mag[i]){
                return false;
            }
        }
        return true;
    }
}
