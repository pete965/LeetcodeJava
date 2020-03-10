package RealInterviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class FirstBigNumber {
    public static void main(String[] args){
        System.out.println(Arrays.toString(findBig(new int[]{9,6,5,7,3,2,5,4,6,10})));
    }
    public static int[] findBig(int[] input){
        int length = input.length;
        int[] output = new int[length];
        if (length == 0) {
            return input;
        } else if (length == 1){
            return output;
        }
        Stack<Integer> stack =  new Stack<>();
        int i = 0;
        while(i < input.length){
            if(stack.isEmpty()||input[stack.peek()]>input[i]){
                stack.push(i);
                i++;
            }else{
                output[stack.pop()] = input[i];
            }
        }
        return output;
    }
}
