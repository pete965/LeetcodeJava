package Leetcode_Bytedance.No_42_Trapping_Rain_Water;

public class Solution {
    public int trap(int[] height) {
        int count = 0;
        int length = height.length;
        if (length<=2){
            return 0;
        }
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = height[0];
        for (int i=1;i<length;i++){
            left[i] = Math.max(left[i-1],height[i]);
        }
        right[length-1] = height[length-1];
        for (int i=length-2;i>=0;i--){
            right[i] = Math.max(right[i+1],height[i]);
        }
        for (int i=1;i<length-1;i++){
            count+=Math.min(left[i],right[i])-height[i];
        }
        return count;
    }
}
