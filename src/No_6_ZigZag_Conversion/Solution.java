package No_6_ZigZag_Conversion;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.convert("AB",1));
    }
    public String convert(String s, int numRows) {
        String output="";
        if (s.length()==0){
            return output;
        }
        if (numRows==1){
            return s;
        }
        HashMap<Integer,ArrayList<Character>> hashMap = new HashMap<Integer,ArrayList<Character>>();
        for(int i=0;i<numRows;i++){
            hashMap.put(i,new ArrayList<Character>());
        }
        int current = 0;
        boolean add = true;
        for (int i=0;i<s.length();i++){
            hashMap.get(current).add(s.charAt(i));
            if (add){
                if(current!=numRows-1){
                    current++;
                }else{
                    current--;
                    add=false;
                }
            }else{
                if(current!=0){
                    current--;
                }else{
                    current++;
                    add=true;
                }
            }
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<hashMap.get(i).size();j++){
                output = output + hashMap.get(i).get(j);
            }
        }
        return output;
    }
}
