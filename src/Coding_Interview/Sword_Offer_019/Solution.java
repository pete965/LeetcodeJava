package Coding_Interview.Sword_Offer_019;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix.length==0){
            return arrayList;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        if (col==0){
            return arrayList;
        }
        int rowIndex=0;
        int colIndex=0;
        boolean normal=true;
        while (rowIndex!=row){
            for (int i=0;i<col;i++){
                arrayList.add(matrix[rowIndex][i]);
            }
            rowIndex++;
            if (rowIndex==row){
                break;
            }
            for (int i=col-1;i>=0;i--){
                arrayList.add(matrix[rowIndex][i]);
            }
            rowIndex++;
        }
        return arrayList;
    }
}
