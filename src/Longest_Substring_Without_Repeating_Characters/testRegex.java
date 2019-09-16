package Longest_Substring_Without_Repeating_Characters;

public class testRegex {
    public static void main(String[] args){
        String s = "aabcdefss";
        System.out.println(s.split("/([a-z])\\1+/")[0]);
    }
}
