package Coding_Interview.Sword_Offer_028;

import java.util.ArrayList;
import java.util.Arrays;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        int length=array.length;
        if (length==0){
            return 0;
        }
        if (length==1||length==2){
            return array[0];
        }
        Arrays.sort(array);
        int mid=array[length/2];
        if (moreThanHalf(mid,length,array)){
            return mid;
        }else {
            return 0;
        }
    }

    private boolean moreThanHalf(int mid,int length,int[] array) {
        int count=0;
        for (int i=0;i<length;i++){
            if (array[i]==mid){
                count++;
            }
        }
        if (count>length/2){
            return true;
        }else{
            return false;
        }
    }
}
