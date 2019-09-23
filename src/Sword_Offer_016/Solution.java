package Sword_Offer_016;

public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode current1=list1;
        ListNode current2=list2;
        ListNode output=null;
        ListNode outputCurrent=null;
        if (current1!=null&&current2!=null){
            if (current1.val<current2.val){
                output=current1;
                current1=current1.next;
                outputCurrent=output;
            }else {
                output=current2;
                current2=current2.next;
                outputCurrent=output;
            }
        }else if(current1==null&&current2!=null){
            return current2;
        }else if (current1!=null&&current2==null){
            return current1;
        }else {
            return null;
        }
        while (current1!=null||current2!=null){
            if (current1==null){
                outputCurrent.next=current2;
                current2=current2.next;
                outputCurrent=outputCurrent.next;
            }else if (current2==null){
                outputCurrent.next=current1;
                current1=current1.next;
                outputCurrent=outputCurrent.next;
            }else {
                if (current1.val<current2.val){
                    outputCurrent.next=current1;
                    current1=current1.next;
                    outputCurrent=outputCurrent.next;
                }else {
                    outputCurrent.next=current2;
                    current2=current2.next;
                    outputCurrent=outputCurrent.next;
                }
            }
        }
        return output;
    }
}
