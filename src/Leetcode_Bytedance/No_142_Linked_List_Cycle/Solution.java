package Leetcode_Bytedance.No_142_Linked_List_Cycle;

import Beans.ListNode;
import Beans.Util;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        ListNode head = Util.arrayToCicleList(new int[]{3,2,0,-4},1);
        ListNode head =new ListNode(1);
//        ListNode node1 = new ListNode(2);
//        ListNode node2 = new ListNode(0);
//        ListNode node3 = new ListNode(-4);
//        head.next=node1;
//        node1.next=node2;
//        node2.next=node3;
//        node3.next=node1;
//        ListNode current = head;
//        for (int i=0;i<5;i++){
//            System.out.println(current.val);
//            current=current.next;
//        }
        Solution solution = new Solution();
        solution.detectCycle(head);
    }
    public ListNode detectCycle(ListNode head) {
        if (head==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
//        System.out.println("______________________");
//        System.out.println("fast:"+fast.val);
//        System.out.println("slow:"+slow.val);
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                break;
            }
        }
        if (fast.next==null||fast.next.next==null){
            return null;
        }
        fast=head;
//        System.out.println("______________________");
//        System.out.println("fast:"+fast.val);
//        System.out.println("slow:"+slow.val);
        while (fast.next!=null&&fast!=slow){
            fast=fast.next;
            slow=slow.next;
        }
//        System.out.println("slow"+slow.val);
        return fast;
    }
}
