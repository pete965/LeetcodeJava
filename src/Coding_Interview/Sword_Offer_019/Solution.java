package Coding_Interview.Sword_Offer_019;

import java.util.ArrayList;
public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        int[][] input={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        System.out.println(solution.printMatrix(input));
    }
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) {
            return arrayList;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return arrayList;
        }
        int up=0,down=row-1,left=0,right=col-1;
        while(true){
            for (int j=left;j<=right;j++){
                arrayList.add(matrix[up][j]);
            }
            up++;
            if (up>down){
                break;
            }
            for (int i=up;i<=down;i++){
                arrayList.add(matrix[i][right]);
            }
            right--;
            if (left>right){
                break;
            }
            for (int j=right;j>=left;j--){
                arrayList.add(matrix[down][j]);
            }
            down--;
            if (up>down){
                break;
            }
            for (int i=down;i>=up;i--){
                arrayList.add(matrix[i][left]);
            }
            left++;
            if (left>right){
                break;
            }
        }
        return arrayList;
    }
}
