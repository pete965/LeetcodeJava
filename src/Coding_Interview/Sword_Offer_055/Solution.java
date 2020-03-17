package Coding_Interview.Sword_Offer_055;
import Tools.ListNode;

/*
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution {

    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead==null||pHead.next==null||pHead.next.next==null){
            return null;
        }
        ListNode slow = pHead.next;
        ListNode fast = pHead.next.next;
        while (slow!=fast){
            if (fast!=null&&fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }else {
                return null;
            }
        }
        fast=pHead;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
