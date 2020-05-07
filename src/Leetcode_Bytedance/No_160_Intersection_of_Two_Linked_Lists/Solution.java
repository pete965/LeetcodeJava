package Leetcode_Bytedance.No_160_Intersection_of_Two_Linked_Lists;

import Beans.ListNode;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1 = 0;
        int length2 = 0;
        ListNode current1 = headA;
        ListNode current2 = headB;
        while (current1!=null){
            length1++;
            current1=current1.next;
        }
        while (current2!=null){
            length2++;
            current2=current2.next;
        }
        current1 = headA;
        current2 = headB;
        if (length1>length2){
            for (int i=0;i<length1-length2;i++){
                current1=current1.next;
            }
        }else {
            for (int i=0;i<length2-length1;i++){
                current2=current2.next;
            }
        }
        while (current1!=null&&current2!=null&&current1!=current2){
            current1=current1.next;
            current2=current2.next;
        }
        if (current1==null||current2==null){
            return null;
        }
        return current1;
    }
}
