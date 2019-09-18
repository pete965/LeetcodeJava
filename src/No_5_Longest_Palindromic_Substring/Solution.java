package No_5_Longest_Palindromic_Substring;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        int[][] pOrNot = new int[length][length];
        fullFill(pOrNot);
    }

    private void fullFill(int[][] pOrNot) {
        for(int i = 1;i<pOrNot.length)
        // TODO: 2019/9/18 查下二维数组怎么获取两个维度的大小
    }

    public int[][] calsss(){
        for (int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                if(i=j)
            }
        }

    }
    public int cal(int i,int j,String s,int[][] pOrNot){
        int length = s.length();
        if(i==j){
            pOrNot[i][j] = true;
        }else if(i+1==j){
            pOrNot[i][j] = (s.charAt(i)==s.charAt(j));
        }else{
            pOrNot[i][j] = cal(i+1,j-1,s);
        }
    }

}
