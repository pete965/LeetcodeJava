package Leetcode_Bytedance.No_567_Permutation_in_String;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length1=s1.length();
        int length2=s2.length();
        int[] frequency = new int[26];
        for (int i=0;i<s1.length();i++){
            frequency[s1.charAt(i)-'a']+=1;
        }
        for (int i=0;i<s2.length();i++){
            int[] fre = frequency.clone();
            boolean local = true;
            for (int j=i;j<i+length1;j++){
                if (fre[s2.charAt(j)-'a']>0){
                    fre[s2.charAt(j)-'a']--;
                }else {
                    local = false;
                }
            }
            if (local){
                return true;
            }
        }
        return false;
    }
}
