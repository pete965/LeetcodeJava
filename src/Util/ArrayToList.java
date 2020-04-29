package Util;

import Leetcode_Bytedance.No_21_Merge_Two_Sorted_Lists.ListNode;

public class ArrayToList {
    public static void main(String[] args){
//        ListNode listNode = convert(new int[]{1,2,3});
//        System.out.println(listNode.val);
//        System.out.println(listNode.next.val);
//        System.out.println(listNode.next.next.val);
//        System.out.println(listNode.next.next.next);
        int a = Character.MAX_VALUE;
        System.out.println(a);
    }
    public static ListNode convert(int[] nums){
        int length = nums.length;
        if(length==0){
            return null;
        }
        ListNode output = new ListNode(nums[0]);
        ListNode current = output;
        for (int i=1;i<length;i++){
            current.next = new ListNode(nums[i]);
            current=current.next;
        }
        current.next = null;
        return output;
    }
}
