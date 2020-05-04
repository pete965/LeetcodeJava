package Leetcode_Bytedance.No_60_Permutation_Sequence;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
//        LinkedList<Integer> arrayList = new LinkedList<>();
//        for (int i=1;i<5;i++){
//            arrayList.add(i);
//        }
//        System.out.println(arrayList.get(1));
//        arrayList.remove(1);
//        System.out.println(arrayList.get(1));
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(4,9));
        System.out.println(solution.getPermutation(3,0));
    }
    StringBuilder stringBuilder;
    public String getPermutation(int n, int k) {
        stringBuilder = new StringBuilder();
        LinkedList<Integer> arrayList = new LinkedList<>();
        for (int i=1;i<=n;i++){
            arrayList.add(i);
        }
        buildString(arrayList,k);
        return stringBuilder.toString();
    }

    private void buildString(LinkedList<Integer> arrayList, int k) {
        if (k==0){
            return;
        }
        if (k>cal(arrayList.size())){
            return;
        }
        if (arrayList.size()==0){
            return;
        }
        int length = arrayList.size();
        if (length==2){
            if (k==1){
                stringBuilder.append(arrayList.get(0));
                arrayList.remove(0);
            }else if (k==2){
                stringBuilder.append(arrayList.get(1));
                arrayList.remove(1);
            }
            buildString(arrayList,1);
            return;
        }
        if (length==1){
            stringBuilder.append(arrayList.get(0));
            arrayList.remove(0);
            return;
        }
        int index = ((k-1)/cal(length-1));
        stringBuilder.append(arrayList.get(index));
        arrayList.remove(index);
        buildString(arrayList,k-(index)*cal(length-1));
    }

    private int cal(int i) {
        int output = 1;
        while (i>0){
            output*=i;
            i--;
        }
        return output;
    }
}
