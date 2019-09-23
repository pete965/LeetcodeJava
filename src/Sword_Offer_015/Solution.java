package Sword_Offer_015;


import java.util.Stack;

public class Solution {
    public ListNode ReverseList(ListNode head) {
        if (head==null){
            return null;
        }
        Stack<ListNode> stack=new Stack<>();
        ListNode current=head;
        while(current!=null){
            stack.push(current);
            current=current.next;
        }
        current=stack.pop();
        ListNode output=current;
        while (!stack.isEmpty()){
            current.next=stack.pop();
            current=current.next;
        }
        current.next=null;
        return output;
    }
}