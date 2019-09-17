package No_5_Longest_Palindromic_Substring;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public String longestPalindrome(String s) {
        String output = "";
        HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<Character, ArrayList<Integer>>();
        for (int i=0;i<s.length();i++){
            Character ch = s.charAt(i);
            if (!hashMap.containsKey(ch)){
                ArrayList<Integer> arrayList = new ArrayList<Integer>();
                arrayList.add(i);
                hashMap.put(ch,arrayList);
            }else{
                hashMap.get(ch).add(i);
            }
        }
        HashMap<Integer,ArrayList<Integer>> lengthMap = new HashMap<Integer,ArrayList<Integer>>();
        for (int i = 1;i<=s.length();i++){
            lengthMap.put(i,new ArrayList<Integer>());
        }
        for(Character character:hashMap.keySet()){
            if (hashMap.get(character).size()>1){
                lengthMap.get(hashMap.get(character).size())
            }
        }
        return output;
    }
    public boolean isPali(String s){
        boolean output = true;
        return output;
    }
    public void addAllCombinations(ArrayList<Integer> arrayList,){

    }
}
