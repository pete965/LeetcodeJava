package Leetcode_Bytedance.No_93_Restore_IP_Addresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.restoreIpAddresses("0279245587303"));
    }
    List<String> res = new ArrayList<String>();
    ArrayList<String> single = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12){
            return res;
        }
        allPossible(4,s);
        return res;
    }
    private void allPossible(int times, String s) {
        if (times==1){
            if (s.length()<=3&&s.length()>0&&Integer.parseInt(s)<=255&&Integer.parseInt(s)>=0){
                if (!(s.length()>1&&s.charAt(0)=='0')){
                    single.add(s);
                    res.add(stringArrayToString(single));
                    single.remove(s);
                }
            }
        }else {
            int endLength = Math.min(s.length(),3);
            if (s.length()!=0&&s.charAt(0)=='0'){
                endLength=1;
            }
            for (int i=1;i<=endLength;i++){
                String thisPart = s.substring(0,i);
                if (Integer.parseInt(thisPart)<=255&&Integer.parseInt(thisPart)>=0){
                    single.add(thisPart+".");
                    System.out.println("single:"+single.toString());
                    allPossible(times-1,s.substring(i,s.length()));
                    single.remove(single.size()-1);
                }
            }
        }
    }
    private String stringArrayToString(ArrayList<String> single) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s:single){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
