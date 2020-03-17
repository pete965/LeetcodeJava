package Coding_Interview.Sword_Offer_034;

/*
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）
 */
public class Solution {
    public int FirstNotRepeatingChar(String str) {
        int[] count = new int[256];
        int length = str.length();
        if (length==0){return -1;}
        for(int i=0;i<length;i++){
            count[str.charAt(i)]++;
        }
        for (int i=0;i<length;i++){
            if (count[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }
}
