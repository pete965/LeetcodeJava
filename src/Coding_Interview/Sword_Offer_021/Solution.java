package Coding_Interview.Sword_Offer_021;

import java.util.ArrayList;
import java.util.Stack;

/*
输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
（注意：这两个序列的长度是相等的）
 */
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
