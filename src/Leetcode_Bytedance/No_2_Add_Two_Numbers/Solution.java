package Leetcode_Bytedance.No_2_Add_Two_Numbers;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode returnHead = new ListNode(0);
        ListNode current3 = returnHead;
        int carry = 0;
        while (current1!=null||current2!=null||carry!=0){
            ListNode newNode = new ListNode(0);
            current3.next = newNode;
            int output = carry;
            if (current1!=null){
                output+=current1.val;
            }
            if (current2!=null){
                output+=current2.val;
            }
            if (output>=10){
                carry=1;
                output-=10;
                newNode.val=output;
            }else{
                carry=0;
                newNode.val=output;
            }
            if (current1!=null){
                current1 = current1.next;
            }
            if (current2!=null){
                current2 = current2.next;
            }
            current3 = current3.next;
        }
        return returnHead.next;
    }
}
