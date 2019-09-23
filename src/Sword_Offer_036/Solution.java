package Sword_Offer_036;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1==null||pHead2==null){
            return null;
        }
        int length1=0;
        int length2=0;
        ListNode current1=pHead1;
        ListNode current2=pHead2;
        while(current1!=null){
            length1++;
            current1=current1.next;
        }
        while(current2!=null){
            length2++;
            current2=current2.next;
        }
        if (length1<length2){
            ListNode mid=pHead1;
            int exchange=length1;
            pHead1=pHead2;
            pHead2=mid;
            length1=length2;
            length2=exchange;
        }
        current1=pHead1;
        current2=pHead2;
        for (int i=0;i<length1-length2;i++){
            current1=current1.next;
        }
        while (current1!=current2){
            current1=current1.next;
            current2=current2.next;
        }
        return current1;
    }
}
