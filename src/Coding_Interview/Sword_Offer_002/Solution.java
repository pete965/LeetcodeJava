package Coding_Interview.Sword_Offer_002;

/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
*/

public class Solution {
    public static void main(String[] args){

    }
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb=new StringBuffer();
        int length=str.length();
        if (length==0){
            return str.toString();
        }
        for (int i=0;i<length;i++){
            char c=str.charAt(i);
            if (c==' '){
                sb.append("%20");
            }else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
