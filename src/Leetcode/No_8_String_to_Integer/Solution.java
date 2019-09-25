package Leetcode.No_8_String_to_Integer;

import java.util.ArrayList;

class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.myAtoi(" 1234"));
    }
    public int myAtoi(String str) {
        int no = 0;
        ArrayList<Integer> output = new ArrayList<Integer>();
        int length = str.length();
        if (length==0){
            return 0;
        }
        int i = 0;
        while(str.charAt(i)==' '){
            i++;
            System.out.println("i="+i);
        }
        ArrayList<Integer> number = new ArrayList<Integer>();
        for(int j=0;j<10;j++){
            number.add(j);
            System.out.println(number);
        }
        System.out.println(i);
        System.out.println(Integer.valueOf(str.charAt(i)));
        System.out.println(Integer.valueOf('0'));
        if (!number.contains(Integer.valueOf(str.charAt(i))-48)){
            return 0;
        }else {
            while(number.contains(str.charAt(i))&&i<length){
                System.out.println("Add a digit");
                output.add(Character.getNumericValue(str.charAt(i)));
                i++;
            }
        }
        for (int j=output.size()-1;j>=0;j--){
            no+=output.get(output.size()-1-j)*Math.pow(10,j);
        }
        return no;
    }
}