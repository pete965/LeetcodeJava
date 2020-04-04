package Leetcode_Bytedance.No_14_Longest_Common_Prefix;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] test1=new String[]{"ab","abcccc","abc"};
        System.out.println(solution.longestCommonPrefix(test1));
    }
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int current = 0;
        boolean flag = true;
        while (flag){
            Character character = null;
            for (String s:strs){
                if (current<s.length()){
                    if (character==null){
                        character = s.charAt(current);
                    }else if (!character.equals(s.charAt(current))){
                        flag = false;
                        break;
                    }
                }else{
                    flag=false;
                }
            }
            if (flag&&character!=null){
                stringBuilder.append(character);
            }
            current++;
        }
        return stringBuilder.toString();
    }
}
