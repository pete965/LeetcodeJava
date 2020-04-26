package Sorting.BubbleSort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,2,4};
        BubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void BubbleSort(int[] nums){
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int midValue = 0;
                if (nums[i]<nums[j]){
                    midValue = nums[i];
                    nums[i] = nums[j];
                    nums[j] = midValue;
                }
            }
        }
    }
}
