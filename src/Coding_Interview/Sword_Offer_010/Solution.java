package Coding_Interview.Sword_Offer_010;

/*
我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
比如n=3时，2*3的矩形块有3种覆盖方法：
 */
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
