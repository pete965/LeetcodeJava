package Leetcode_Bytedance.No_206_Reverse_Linked_List;

import Beans.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode front = head;
        ListNode fast = head.next;
        head.next = null;
        while (fast!=null){
            ListNode nextNode = fast.next;
            fast.next=front;
            front = fast;
            fast = nextNode;
        }
        return front;
    }
}
