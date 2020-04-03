package Leetcode_Bytedance.No_3_Longest_Substring_Without_Repeating_Characters;

import java.util.HashMap;
import java.util.LinkedList;

class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int n = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(n);
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        s=s.trim();
        for(int i=s.length();i>1;i--){
            System.out.println("Length:"+i);
            LinkedList<String> list = getn(s,i);
            for(String string:list){
                System.out.println(string);
                if(!hasRepeat(string)){
                    return i;
                }
            }
        }
        return 1;
    }
    public LinkedList<String> getn(String s,int n){
        LinkedList<String> list =new LinkedList<String>();
        for(int i=0;i<=s.length()-n;i++){
            list.add(s.substring(i,i+n));
        }
        return list;
    }
    public boolean hasRepeat(String s){
        HashMap<Character,Integer> hashMap =  new HashMap<Character,Integer>();
        for(int i = 0;i<s.length();i++){
            Character character = s.charAt(i);
            if(hashMap.containsKey(character)){
                return true;
            }else{
                hashMap.put(character,1);
            }
        }
        return false;
    }
}