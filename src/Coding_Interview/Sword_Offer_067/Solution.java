package Coding_Interview.Sword_Offer_067;

public class Solution {
    public int cutRope(int target) {
        float mul=target/3;
        int first=target/3;
        int mid;
        if (mul-first>first+1-mul){
            mid=first+1;
        }else{
            mid=first;
        }
        return 0;
    }
}
