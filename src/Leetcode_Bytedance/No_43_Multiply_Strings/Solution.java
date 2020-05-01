package Leetcode_Bytedance.No_43_Multiply_Strings;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("0","0"));
    }
    public String multiply(String num1, String num2) {
        int length1=num1.length();
        int length2=num2.length();
        int[] output = new int[length1+length2];
        for (int i=0;i<length1;i++){
            for (int j=0;j<length2;j++){
                int a = num1.charAt(length1-1-i)-'0';
                int b = num2.charAt(length2-1-j)-'0';
//                System.out.println("a="+a+",b="+b);
                mulAndAdd(output,i+j,a*b);
//                System.out.println(Arrays.toString(output));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<output.length;i++){
            stringBuilder.append(output[i]);
        }
//        System.out.println(stringBuilder.toString());
        while (stringBuilder.length()>1){
            if (stringBuilder.charAt(0)=='0'){
                stringBuilder.deleteCharAt(0);
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }

    private void mulAndAdd(int[] output, int loc, int num) {
        output[output.length-1-loc] += num%10;
        if (output[output.length-1-loc]>=10){
            output[output.length-1-loc]-=10;
            output[output.length-1-loc-1]+=1;
        }
        output[output.length-1-loc-1] += num/10;
        if (output[output.length-1-loc-1]>=10){
            output[output.length-1-loc-1]-=10;
            output[output.length-1-loc-2]+=1;
        }
    }
}
