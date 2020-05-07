package Leetcode.No_387_First_Unique_Character_in_a_String;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.firstUniqChar("cc"));
    }
    public int firstUniqChar(String s) {
        if (s.length()==0){
            return -1;
        }
        Queue<Integer> queue =  new LinkedList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i=0;i<s.length();i++){
            int character = s.charAt(i)-'a';
            if (hashMap.containsKey(character)){
                if (queue.contains(character)){
                    queue.remove(character);
                }
            }else {
                queue.offer(character);
                hashMap.put(character,i);
            }
        }
        if (queue.size()==0){
            return -1;
        }
        return hashMap.get(queue.peek());
    }
}
