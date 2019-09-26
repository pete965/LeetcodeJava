package Coding_Interview.Sword_Offer_020;

import java.util.Stack;

public class Solution {
    int min;
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        if (stack.size()==0||node<min){
            min=node;
            minStack.push(node);
        }else {
            minStack.push(stack.peek());
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
