package Coding_Interview.Sword_Offer_009;

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