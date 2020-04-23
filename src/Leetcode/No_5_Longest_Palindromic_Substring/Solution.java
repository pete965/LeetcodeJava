package Leetcode.No_5_Longest_Palindromic_Substring;

public class Solution {
    public static void main(String[] args){
        int[][] a=new int[3][5];
        System.out.println(a[2][2]);
//        MinStack solution = new MinStack();
//        System.out.println(solution.longestPalindrome("babad"));
    }
    public String longestPalindrome(String s) {
        if (s.length()==0){
            return "";
        }
        int max = -1;
        int begin=-1,end=-1;
        int length = s.length();
        int[][] pOrNot = new int[length][length];
        for (int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                pOrNot[i][j] = cal(i,j,s,pOrNot);
                if(pOrNot[i][j]==1){
                    if (j-i>max){
                        max = j-i;
                        begin = i;
                        end = j;
                    }
                }
            }
        }
        return s.substring(begin,end+1);
    }
    public int cal(int i,int j,String s,int[][] pOrNot){
        if (pOrNot[i][j]!=0){
            return pOrNot[i][j];
        }
        if(i==j){
            pOrNot[i][j] = 1;
        }else if(i+1==j){
            if (s.charAt(i)==s.charAt(j)){
                pOrNot[i][j] = 1;
            }else{
                pOrNot[i][j] = 2;
            }
        }else{
            if (cal(i+1,j-1,s,pOrNot)==1&&s.charAt(i)==s.charAt(j)){
                pOrNot[i][j] = 1;
            }else{
                pOrNot[i][j] = 2;
            }
        }
        return pOrNot[i][j];
    }
//    class MinStack {
//        public String longestPalindrome(String s) {
//            if (s.length()==0){
//                return "";
//            }
//            int n = s.length();
//            String res = null;
//
//            boolean[][] dp = new boolean[n][n];
//
//            for (int i = n - 1; i >= 0; i--) {
//                for (int j = i; j < n; j++) {
//                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//
//                    if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
//                        res = s.substring(i, j + 1);
//                    }
//                }
//            }
//
//            return res;
//        }}
}
