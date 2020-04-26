package Leetcode.No_55_Jump_Game;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canJump(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
        System.out.println(solution.canJump(new int[]{3,2,1,0,4}));
        System.out.println(solution.canJump(new int[]{3,0,8,2,0,0,1}));
        System.out.println(solution.canJump(new int[]{1,0,1,0}));
        System.out.println(solution.canJump(new int[]{2,0,0}));
        System.out.println(solution.canJump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5}));
    }
    public boolean canJump(int[] nums) {
        int length = nums.length;
        if (length==0){
            return false;
        }
        if (length==1){
            return true;
        }
        boolean output = true;
        int far = 0;
        for (int i=0;i<length-1;i++){
            if (nums[i]!=0){
                far = Math.max(far,i+nums[i]);
            }else {
                if (far <= i){
                    return false;
                }
            }
        }
        return true;
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        for (int i = 0; i < length-1; i++) {
//            if (nums[i] == 0&&(nums[i+1]!=0)) {
//                arrayList.add(i);
////                System.out.println("0 at:"+i);
//            }
//        }
//        if (nums[length-1]==0){
//            arrayList.add(length-1);
//        }
//        int far = -1;
//        for (int i = 0; i < arrayList.size(); i++) {
//            boolean localFlag = false;
//            if (arrayList.get(i)<=far){
//                System.out.println("already jumped over this 0 at index:"+arrayList.get(i));
//                System.out.println("Far is:"+far);
//                continue;
//            }
//            if (i == 0) {
//                for (int j = 0; j < arrayList.get(i); j++) {
//                    far = Math.max(far,j + nums[j]);
//                    if ((j + nums[j] >= nums.length-1)){
//                        return true;
//                    }
//                    if (j + nums[j] > arrayList.get(i)) {
//                        localFlag = true;
////                        System.out.println("can jump from "+j+" to "+arrayList.get(i));
//                        break;
//                    }
//                }
//            } else {
//                for (int j = arrayList.get(i - 1) + 1; j < arrayList.get(i); j++) {
//                    far = Math.max(far,j + nums[j]);
//                    if ((j + nums[j] >= nums.length-1)&&output){
//                        return true;
//                    }
//                    if (j + nums[j] > arrayList.get(i)) {
//                        localFlag = true;
////                        System.out.println("can jump from "+j+" to "+arrayList.get(i));
//                        break;
//                    }
//                }
//            }
//            if (localFlag){
//                System.out.println("Successfully jump over the index:"+arrayList.get(i));
//            }else {
//                System.out.println("Failed to jump over the index:"+arrayList.get(i));
//            }
//            output = output&&localFlag;
////            System.out.println("output this round is:"+output);
//        }
    }
}
