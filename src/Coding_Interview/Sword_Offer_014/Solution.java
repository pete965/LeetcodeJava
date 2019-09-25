package Coding_Interview.Sword_Offer_014;


import java.util.Stack;

public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if (head==null){
            return null;
        }
        int length=0;
        Stack<ListNode> stack=new Stack<>();
        ListNode current=head;
        while(current!=null){
            length++;
            stack.push(current);
            current=current.next;
        }
        int index=0;
        while (!stack.isEmpty()){
            ListNode pop=stack.pop();
            index++;
            if (index==k){
                return pop;
            }
        }
        return null;
    }
}