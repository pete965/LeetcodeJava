package Leetcode.No_283_Move_Zeros;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test1 = new int[]{0,1,0,3,12};
        int[] test2 = new int[0];
        solution.moveZeroes(test1);
        System.out.println(test1.toString());
        solution.moveZeroes(test2);
        System.out.println(test2.toString());
    }
    public void moveZeroes(int[] nums) {
        int mid = 0;
        int index = -1;
        int length = nums.length;
        for (int i=0;i<length;i++){
            if (nums[i] == 0){
                if (index == -1){

                }
            }
        }
    }
}
