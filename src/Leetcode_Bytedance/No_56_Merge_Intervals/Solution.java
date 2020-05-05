package Leetcode_Bytedance.No_56_Merge_Intervals;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1,4},{1,5}};
        for (int[] inter : solution.merge(intervals)){
            System.out.println(Arrays.toString(inter));
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][0];
        }
        mergeSort(intervals,0,intervals.length-1);
        for (int[] inter:intervals){
//            System.out.println(Arrays.toString(inter));
//            System.out.println("###########");
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
            arrayList.add(i);
            int local = i;
//            System.out.println("add:"+i);
            while (i<intervals.length-1&&intervals[local][1]>=intervals[i+1][0]){
                intervals[local][1] = Math.max(intervals[local][1],intervals[i+1][1]);
                i++;
            }
        }
        int[][] output = new int[arrayList.size()][2];
        for (int i =0;i<arrayList.size();i++){
            output[i][0] = intervals[arrayList.get(i)][0];
            output[i][1] = intervals[arrayList.get(i)][1];
        }
        return output;
    }

    private void mergeSort(int[][] intervals, int left, int right) {
        if (left==right){
            return;
        }else {
            int M = (right+left)/2;
            mergeSort(intervals,left,M);
            mergeSort(intervals,M+1,right);
            mergeAll(intervals,left,M+1,right);
        }
    }

    private void mergeAll(int[][] intervals, int left, int m, int right) {
        int[][] leftNums = new int[m-left][2];
        int[][] rightNums = new int[right-m+1][2];
        for (int i=left;i<m;i++){
            leftNums[i-left][0] = intervals[i][0];
            leftNums[i-left][1] = intervals[i][1];
        }
        for (int i=m;i<=right;i++){
            rightNums[i-m][0] = intervals[i][0];
            rightNums[i-m][1] = intervals[i][1];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i<leftNums.length&&j<rightNums.length){
            if (leftNums[i][0]<rightNums[j][0]){
                intervals[k][0] = leftNums[i][0];
                intervals[k][1] = leftNums[i][1];
                i++;
            }else {
                intervals[k][0] = rightNums[j][0];
                intervals[k][1] = rightNums[j][1];
                j++;
            }
            k++;
        }
        while (i<leftNums.length){
            intervals[k][0] = leftNums[i][0];
            intervals[k][1] = leftNums[i][1];
            i++;
            k++;
        }
        while (j<rightNums.length){
            intervals[k][0] = rightNums[j][0];
            intervals[k][1] = rightNums[j][1];
            k++;
            j++;
        }
    }
}
