package Leetcode_Bytedance.No_567_Permutation_in_String;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkInclusion("ab","eidbaooo"));
    }
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        int length1=s1.length();
        int length2=s2.length();
        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];
        //填充 字符串1 和 字符串2的前一部分（长度等于字符串1）的频率数组
        for (int i=0;i<length1;i++){
            frequency1[s1.charAt(i)-'a']++;
            frequency2[s2.charAt(i)-'a']++;
        }

        for (int i=0;i<length2-length1;i++){
            if (compare(frequency1,frequency2)){
                return true;
            }
            frequency2[s2.charAt(i)-'a']--;
            frequency2[s2.charAt(i+length1)-'a']++;
        }
        return compare(frequency1, frequency2);
    }

    private boolean compare(int[] frequency1, int[] frequency2) {
        for (int i=0;i<26;i++){
            if (frequency1[i]!=frequency2[i]){
                return false;
            }
        }
        return true;
    }
}
