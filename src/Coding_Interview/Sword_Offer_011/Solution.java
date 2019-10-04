package Coding_Interview.Sword_Offer_011;

public class Solution {
    public int NumberOf1(int n) {
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1);
        }
        return count;
    }
}
