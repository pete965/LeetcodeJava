package Leetcode.Special_No_2_Perform_String_Shifts;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.stringShift("abc",new int[][]{{0,1},{1,2}}));
        System.out.println(solution.stringShift("abcdefg",new int[][]{{1,1},{1,1},{0,2},{1,3}}));
    }
    public String stringShift(String s, int[][] shift) {
        int dir = 1;
        int dis = 0;
        int length = shift.length;
        for (int i=0;i<length;i++){
            if (shift[i][0]==0){
                dis-=shift[i][1];
            } else {
                dis+=shift[i][1];
            }
        }
        if (dis<0){
            dir = 0;
            dis = -dis;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int stringLength = s.length();
        dis%=stringLength;
        int beginIndex = 0;
        if (dir == 1){
            beginIndex = stringLength-dis;
        }else {
            beginIndex = dis;
        }
        for (int i=beginIndex;i<stringLength;i++){
            stringBuilder.append(s.charAt(i));
        }
        for (int i=0;i<beginIndex;i++){
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
