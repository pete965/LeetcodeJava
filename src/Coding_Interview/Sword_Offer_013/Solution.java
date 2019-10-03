package Coding_Interview.Sword_Offer_013;

public class Solution {
    public void reOrderArray(int [] array) {
        int length=array.length;
        if (length==0||length==1){
            return;
        }
        int odd=0,even=1;
        for (int i=0;i<length;i++){
            if (array[i]%2==0){
                even++;
            }
        }
    }
}
