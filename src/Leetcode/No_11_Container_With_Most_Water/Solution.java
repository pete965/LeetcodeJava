package Leetcode.No_11_Container_With_Most_Water;

class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int begin = 0, end = height.length-1;
        while(begin!=end){
            maxArea = Math.max(maxArea,Math.min(height[begin],height[end])*(end-begin));
            if(height[begin]<height[end]){
                begin++;
            }else{
                end--;
            }
        }
        return maxArea;
    }
}