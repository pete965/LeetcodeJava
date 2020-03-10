package Deep_Thought_Into_Java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Huiwen {
    public static void main(String[] args){
        Huiwen huiwen = new Huiwen();
        System.out.println(huiwen.longestPolySubstring("abab"));
    }
    public String longestPolySubstring(String s){
        ArrayList<String> arrayList = new ArrayList<>();
        int length = s.length();
        for(int i=length;i>0;i--){
            for(int j=0;j<length-i+1;j++){
                arrayList.add(s.substring(j,j+i));
            }
        }
        int max=0;
        String output = "";
//        s=s.substring(0,1);
        for (String string : arrayList ){
            if(judge(string)){
                if (string.length()>max){
                    max=string.length();
                    output=string;
                }
            }
        }
        return s;
    }

    private boolean judge(String string) {
        Stack<Character> stack = new Stack<>();
        return true;
    }
}
