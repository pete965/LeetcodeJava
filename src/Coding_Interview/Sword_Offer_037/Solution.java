package Coding_Interview.Sword_Offer_037;

import java.util.Arrays;

/*
统计一个数字在排序数组中出现的次数。
 */
public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.GetNumberOfK(new int[]{1,3,3,3,3,4,5},2));
    }
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        int length = array.length;
        if (length == 0){
            return 0;
        }
        if (length == 1){
            if (k == array[0]){
                return 1;
            }else{
                return 0;
            }
        }
        int left = 0;
        int right = length-1;
        int mid = 0;
        System.out.println("Begin Binary Search");
        while(left!=right){
            mid = (left + right)/2;
//            System.out.println("Mid is:"+ mid);
            System.out.println("Left is:"+left);
            System.out.println("Right is:"+right);
            if (array[mid] > k){
                right = mid-1;
            }else if (array[mid] < k){
                left = mid+1;
            }else{
                count++;
                break;
            }
        }
        int index = mid;


//        int index = Arrays.binarySearch(array,k);


        System.out.println(index);
        int rightIndex = index;
        if (count>0){
            while(rightIndex+1<length&&array[rightIndex] == array[rightIndex+1]){
                count++;
                rightIndex++;
            }
            while (index-1>=0&&array[index] == array[index-1]){
                count++;
                index--;
            }
        }
        return count;
    }
}
