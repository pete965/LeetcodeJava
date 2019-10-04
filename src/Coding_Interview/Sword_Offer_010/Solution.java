package Coding_Interview.Sword_Offer_010;

public class Solution {
    public int RectCover(int target) {
        if (target==1||target==0||target==2){
            return target;
        }
        return calN(target);
    }

    private int calN(int target) {
        if (target==1||target==2){
            return target;
        }else{
            return calN(target-1) + calN(target-2);
        }
    }
}
