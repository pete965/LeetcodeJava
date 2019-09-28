package Coding_Interview.Sword_Offer_034;

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
