package Leetcode.No_278_Frist_Bad_Version;

import Beans.VersionControl;

public class Solution implements VersionControl {
    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{0,0,0,1,1,1});
        System.out.println(solution.firstBadVersion(6));
        System.out.println(Integer.MAX_VALUE);
    }
    int[] nums;
    public Solution(int[] nums){
        this.nums = nums;
    }
    public int firstBadVersion(int n) {
        int left = 0;
        int right = n-1;
        int location = n;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)){
                right = mid;
                location = mid;
            }else {
                left = mid + 1;
            }
        }
        return location;
    }

    @Override
    public boolean isBadVersion(int version) {
        if (this.nums[version]==1){
            return true;
        }
        return false;
    }
}
