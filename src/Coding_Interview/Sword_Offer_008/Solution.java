package Coding_Interview.Sword_Offer_008;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class Solution {
    public int JumpFloor(int target) {
        if (target==1||target==2){
            return target;
        }
        int[] array=new int[target];
        array[0]=1;
        array[1]=2;
        for (int i=2;i<target;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array[target-1];
    }
}
