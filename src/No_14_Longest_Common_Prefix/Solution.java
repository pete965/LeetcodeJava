package No_14_Longest_Common_Prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        int i;
        int length = strs[0].length();
        for (int j=1;j<strs.length;j++){
            length=Math.min(length,strs[j].length());
        }
        boolean end = false;

        for(i=0;i<length;i++){
            Character character = strs[0].charAt(i);
            for (int j=1;j<strs.length;j++){
                if (character!=strs[j].charAt(i)){
                    end=true;
                    break;
                }
            }
            if (end){
                break;
            }
        }
        String output=strs[0].substring(0,i);
        return output;
    }
}
