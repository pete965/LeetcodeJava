package Leetcode.Special_No_3_Leftmost_Column_with_at_Least_a_One;

import Beans.BinaryMatrix;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.binarySearchTest(new int[]{0,0,0,1,1,1},0,4));
//
        int[][] testMatrix = new int[][]{{1,1,1,1,1,1,1},{0,0,0,1,1,1,1},{0,0,1,1,1,0,0},{0,0,0,0,1,1,1},{0,0,0,0,0,1,1}};
        BinaryMatrix binaryMatrix = new BinaryMatrix(testMatrix);
        System.out.println(solution.leftMostColumnWithOne(binaryMatrix));
        System.out.println("Get "+binaryMatrix.getCount()+" times");
    }

    private int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0);
        int columns = list.get(1);
        int i=0;
        int j=columns-1;
        while (i<rows&&j>=0){
            if (binaryMatrix.get(i,j)==0){
                i++;
            }else {
                j--;
            }
        }
        if (j+1==columns){
            return -1;
        }
        return j+1;
    }

    public int leftMostColumnWithOneWithBinary(BinaryMatrix binaryMatrix) {
        List<Integer> list = binaryMatrix.dimensions();
        int rows = list.get(0);
        int columns = list.get(1);
        int output = columns;
        for (int i=0;i<rows;i++){
            int local = binarySearch(binaryMatrix,i,output-1);
            output = Math.min(output,local);
//            System.out.println("output:"+output);
        }
        if (output==columns){
            output=-1;
        }
        return output;
    }

    private int binarySearch(BinaryMatrix binaryMatrix, int row, int end) {
        int location = end + 1;
        int left = 0;
        int right = end;
        while (left<=right){
            if (binaryMatrix.get(row,right)==1){
                location = Math.min(location,right);
            }
            if (binaryMatrix.get(row,left)==1){
                location = Math.min(location,left);
            }
            int mid = (left+right)/2;
            int midValue = binaryMatrix.get(row,mid);
            if (midValue==0){
                left=mid+1;
            }else {
                right=mid-1;
                location = Math.min(location,mid);
            }
//            System.out.println("Location:"+location);
        }
        return location;
    }
    private int binarySearchTest(int[] nums,int begin,int end) {
        int location = end + 1;
        int left = begin;
        int right = end;

        while (left<=right){
            if (nums[right]==1){
                location = Math.min(location,right);
            }
            if (nums[left]==1){
                location = Math.min(location,left);
            }
            int mid = (left+right)/2;
            int midValue = nums[mid];
            if (midValue==0){
                left = mid + 1;
                System.out.println("Shift to right");
            }else {
                right = mid - 1;
                location = Math.min(location,mid);
                System.out.println("Location now:"+location);
            }
        }
        return location;
    }
}
