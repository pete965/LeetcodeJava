package Coding_Interview.Sword_Offer_044;

public class Solution {
    public static void main(String[] args){
        Solution solution=new Solution();
    }
    public String ReverseSentence(String str) {
        if(str==null||str.trim().equals(""))return str;
        StringBuffer stringBuffer=new StringBuffer();
        String[] strings=str.split(" ");
        if (str.equals(" ")){
            return str;
        }
        for (int i=strings.length-1;i>=0;i--){
            stringBuffer.append(strings[i]);
            if (i!=0){
                stringBuffer.append(" ");
            }
        }

        return stringBuffer.toString();
    }
}
