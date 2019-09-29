package Coding_Interview.Sword_Offer_002;

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
