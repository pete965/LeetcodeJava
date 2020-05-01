package Leetcode_Bytedance.No_151_Reverse_Words_in_a_String;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverseWords("the sky is blue"));
        System.out.println(solution.reverseWords("  hello world!"));
        System.out.println(solution.reverseWords("a good    example"));
        int a = '/';
        System.out.println(a);
    }
    public String reverseWords(String s) {
        int length = s.length();
        int index = length-1;
        StringBuilder stringBuilder = new StringBuilder();
        while (index>=0){
            boolean addSpace = false;
            while (index>=0&&s.charAt(index)==' '){
                addSpace = true;
                index--;
            }
            if (addSpace){
                stringBuilder.append(" ");
            }
            StringBuilder local = new StringBuilder();
            while (index>=0&&s.charAt(index)!=' '){
                local.append(s.charAt(index));
                index--;
            }
            if (local.length()>0){
                stringBuilder.append(local.reverse().toString());
            }
        }
        while (stringBuilder.length()>0){
            if (stringBuilder.charAt(0)==' '){
                stringBuilder.deleteCharAt(0);
            }else {
                break;
            }
        }
        while (stringBuilder.length()>0){
            if (stringBuilder.charAt(stringBuilder.length()-1)==' '){
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }
}
