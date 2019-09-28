package Coding_Interview.Sword_Offer_065;

public class Solution {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (rows==0||cols==0){
            return str.length==0;
        }
        if (str.length==0){
            return true;
        }
        for(int i=0;i<matrix.length;i++){
            if (matrix[i]==str[0]){

            }
        }
        return true;
    }
}