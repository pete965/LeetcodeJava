package Coding_Interview.Sword_Offer_006;

import java.util.ArrayList;
public class Solution {
    public int minNumberInRotateArray(int [] array) {
        int length=array.length;
        if (length==0){
            return 0;
        }
        if (length==1){
            return array[0];
        }
        int former=array[0];
        for (int i=1;i<length;i++){
            if (array[i]<former){
                return array[i];
            }
            former=array[i];
        }
        return former;
    }
}
