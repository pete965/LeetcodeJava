package Leetcode.No_33_Search_in_Rotated_Sorted_Array;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},4));
        System.out.println(solution.search(new int[]{4,5,6,7,0,1,2},3));
    }
    public int search(int[] nums, int target) {
        int length = nums.length;
        int output = -1;
        if (length==0){
            return -1;
        }
        int index = 0;
        for (int i=0;i<length-1;i++){
            if (nums[i]>nums[i+1]){
                index=i;
            }
        }
        output = biSearch(0,index,nums,target);
        if (output!=-1){
            return output;
        }else {
            output = biSearch(index + 1,length-1,nums,target);
        }
        return output;
    }

    private int biSearch(int i, int index,int[] nums,int target) {
        int left = i;
        int right = index;
        while (left<=right){
            int mid = (left + right)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }
}
