package Leetcode.No_844_Backspace_Space_Compare;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        int index1 = S.length()-1;
        int back1 = 0;
        int back2 = 0;
        int index2 = T.length()-1;
        while (index1>=0||index2>=2){
            while (index1>=0){
                if (S.charAt(index1) == '#'){
                    back1++;
                    index1--;
                }else if (back1>0){
                    back1--;
                    index1--;
                }else {
                    break;
                }
            }
            while (index2>=0){
                if (T.charAt(index2) == '#'){
                    back2++;
                    index2--;
                }else if (back2 > 0){
                    back2--;
                    index2--;
                }else {
                    break;
                }
            }
            if (index1 >= 0 && index2 >= 0 && S.charAt(index1) != T.charAt(index2))
                return false;
            // If expecting to compare char vs nothing
            if ((index1 >= 0) != (index2 >= 0))
                return false;
            index1--; index2--;
        }
        return true;
    }
}
