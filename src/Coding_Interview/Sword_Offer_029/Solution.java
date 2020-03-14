package Coding_Interview.Sword_Offer_029;

import java.util.ArrayList;

/*
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
        System.out.println(solution.GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4).toString());
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
        for (int i=0;i<=index;i++){
            if ((2*(i+1)-1<=index&&input[2*(i+1)-1]<input[i])||(2*(i+1)<=index&&input[2*(i+1)]<input[i])){
                if (input[2*(i+1)-1]<input[2*(i+1)]){
                    exchange(i,2*(i+1)-1,input);
                }else{
                    exchange(i,2*(i+1),input);
                }
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
