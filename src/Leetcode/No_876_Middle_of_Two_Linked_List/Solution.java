package Leetcode.No_876_Middle_of_Two_Linked_List;

import Leetcode_Bytedance.No_21_Merge_Two_Sorted_Lists.ListNode;
import Util.ArrayToList;
import Util.PrintList;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ArrayToList.convert(new int[]{3,5,7});
        ListNode head1 = null;
        PrintList.printNode(solution.middleNode(head));
        PrintList.printNode(solution.middleNode(head1));
    }
    public ListNode middleNode(ListNode head) {
        if (head==null){
            return head;
        }else if (head.next==null){
            return head;
        }
        if (head.next.next==null){
            return head.next;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if (fast.next==null){
            return slow;
        }else {
            return slow.next;
        }
    }
}
