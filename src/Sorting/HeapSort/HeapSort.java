package Sorting.HeapSort;

import java.util.ArrayList;

public class HeapSort {
    public static void main(String[] args){
        HeapSort solution=new HeapSort();
        System.out.println(solution.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},7).toString());
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        int length=input.length;
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (k>length||k==0){
            return arrayList;
        }
        if (k==length){
            for (int i=0;i<length;i++){
                arrayList.add(input[i]);
            }
            return arrayList;
        }
        int index=length-1;
        for (int i=0;i<k;i++){
            arrayList.add(makeHeap(input,index-i));
        }
        return arrayList;
    }

    private int makeHeap(int[] input, int index) {
        for (int i=index;i>=0;i--){
            int rootIndex = 0;
            if (i%2==0){
                rootIndex = (i-2)/2;
            }else {
                rootIndex = (i-1)/2;
            }
            if ((rootIndex>=0&&input[rootIndex]>input[i])){
                exchange(i,rootIndex,input);
            }
        }
        exchange(0,index,input);
        return input[index];
    }

    private void exchange(int i, int i1, int[] input) {
        int mid=input[i];
        input[i]=input[i1];
        input[i1]=mid;
    }
}
