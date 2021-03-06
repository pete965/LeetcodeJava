package Coding_Interview.Sword_Offer_042;

import java.util.ArrayList;

/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 */
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer>  arrayList = new ArrayList<>();
        int length = array.length;
        if (length == 0 || length == 1){
            return arrayList;
        }
        int left = 0;
        int right = length - 1;
        while (left!=right) {
            if (array[left] + array[right] == sum){
                arrayList.add(array[left]);
                arrayList.add(array[right]);
                break;
            }else if (array[left] + array[right] > sum){
                right--;
            }else{
                left++;
            }
        }
        return arrayList;
    }
}
