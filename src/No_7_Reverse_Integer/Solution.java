package No_7_Reverse_Integer;

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.reverse(123));
    }
    public int reverse(int x) {
        int output;
        int push;
        Stack<Integer> stack = new Stack<Integer>();
        int divide=1;
        do {
            push = x/divide;
            divide = divide * 10;
            stack.push(push);
            if (x==0){
                break;
            }
        }while(!(Math.abs(push)>=1&&Math.abs(push)<10));
        int multiply=10;
        output = stack.pop();
        int last = output;
        int nop = 0;
        while(!stack.empty()){
            int pop = stack.pop();
            int next = pop - 10*last;
            if(next>Integer.MAX_VALUE/multiply||nop>10){
                System.out.println("1");
                return 0;
            }
            if(next<Integer.MIN_VALUE/multiply){
                System.out.println("2");
                return 0;
            }
            if(output>Integer.MAX_VALUE-multiply*next&&pop>0){
                System.out.println("3");
                return 0;
            }
            if(output<Integer.MIN_VALUE-multiply*next&&pop<0){
                System.out.println(output);
                System.out.println("4");
                return 0;
            }
            output = output+multiply*next;
            multiply=multiply*10;
            last=pop;
            nop++;
        }
        return output;
    }
}