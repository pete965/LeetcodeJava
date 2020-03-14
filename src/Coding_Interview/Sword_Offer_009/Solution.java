package Coding_Interview.Sword_Offer_009;

/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
    public int JumpFloorII(int target) {
        if (target==0||target==1||target==2){
            return target;
        }
        int[] array=new int[target];
        array[0]=1;
        array[1]=2;
        for (int i=2;i<target;i++){
            int output=1;
            for(int j=i;j>=0;j--){
                output+=array[j];
            }
            array[i]=output;
        }
        return array[target-1];
    }
}