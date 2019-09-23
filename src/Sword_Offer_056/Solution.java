package Sword_Offer_056;

public class Solution {
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode output=pHead;
        if (pHead==null){
            return null;
        }else if (pHead.next==null){
            return pHead;
        }else if (pHead.val==pHead.next.val&&pHead.next.next==null){
            return null;
        }else if (pHead.next.next.next==null&&pHead.val==pHead.next.val){
            return pHead.next.next;
        }
        ListNode current1=pHead;
        ListNode current2=pHead.next;
        ListNode current3=pHead.next.next;
        while (current3.next!=null){
            if (current2.val==current3.val){
                current1.next=current3.next;
                current2=current1.next;
            }else {
                current1=current1.next;
                current2=current2.next;
            }
        }
        return output;
    }
}
