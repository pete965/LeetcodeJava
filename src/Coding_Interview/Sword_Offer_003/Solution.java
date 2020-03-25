package Coding_Interview.Sword_Offer_003;

/*
输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
*/

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> output = new ArrayList<>();
        Stack<Integer> stack=new Stack<>();
        ListNode current=listNode;
        while(current!=null){
            stack.push(current.val);
            current=current.next;
        }
        while(!stack.isEmpty()){
            output.add(stack.pop());
        }
        return output;
    }
}