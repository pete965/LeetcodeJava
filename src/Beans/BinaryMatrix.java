package Beans;

import java.util.LinkedList;
import java.util.List;

public class BinaryMatrix {
    int count=0;
    int[][] matrix;
    public int get(int row, int col){
        this.count++;
        return matrix[row][col];
    }
    public List<Integer> dimensions(){
        int row = matrix.length;
        int col = matrix[0].length;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(row);
        list.add(col);
        return list;
    };
    public BinaryMatrix(int[][] matrix){
        this.matrix = matrix;
    }

    public int getCount() {
        return count;
    }
}
