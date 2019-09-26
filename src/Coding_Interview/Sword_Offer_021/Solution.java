package Coding_Interview.Sword_Offer_021;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length!=popA.length){
            return false;
        }
        if (pushA.length==1){
            return pushA[0]==popA[0];
        }
        int firstOut=popA[0];
        Stack<Integer> stack=new Stack<>();
        int i;
        for (i=0;i<pushA.length;i++){
            if (pushA[i]==firstOut){
                break;
            }
            stack.push(pushA[i]);
        }
        int j = 1;
        while (true){
            if (j==popA.length){
                return true;
            }
            if (popA[j]==stack.peek()){
                j++;
                stack.pop();
            }else {
                if (i+1<pushA.length){
                    i++;
                    stack.push(pushA[i]);
                }else {
                    return false;
                }
            }
        }
    }
}
