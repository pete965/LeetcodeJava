package Leetcode.No_9_Palindrome_Number;

import java.util.Stack;

class Solution {
    public boolean isPalindrome(int x) {
        boolean output = true;
        String number=String.valueOf(x);

        Stack<Character> stack=new Stack<>();
        for (int i=0;i<number.length();i++){
            stack.push(number.charAt(i));
        }
        int j=0;
        while(!stack.isEmpty()){
            Character pop = stack.pop();
            if(number.charAt(j)!=pop){
                output = false;
            }
            j++;
        }
        return output;
    }
}

//Improvement: Reverse the first half is enough