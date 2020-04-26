package Leetcode.No_678_Valid_Parenthesis_String;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strings = new String[]{"()","(*)","(*))","(((*()(***)()(*"};
        for (String s : strings){
            System.out.println(s+":"+solution.checkValidString(s));
        }
    }
    public boolean checkValidString(String s) {
        int n = s.length();
        if (n == 0) return true;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            //dp[i][j]在i=j时为true；处理长度为0的dp值
            if (s.charAt(i) == '*') dp[i][i] = true;
            //dp[i][j]在i=j-1时，在(),(*,*),**等四种情况为true；处理长度为1的dp值
            if (i < n-1 &&
                    (s.charAt(i) == '(' || s.charAt(i) == '*') &&
                    (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
                dp[i][i+1] = true;
            }
        }

        for (int size = 2; size < n; size++) {
            //处理长度2~n-1的dp[i][j]值,即i=j-size
            for (int i = 0; i + size < n; i++) {
                //如果i处字符为*，那么如果dp[i+1][j]为true，则dp[i][j]为true
                if (s.charAt(i) == '*' && dp[i+1][i+size] == true) {
                    dp[i][i+size] = true;
                } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                    //否则，需要另行判断；如果i处字符为），那么一定是false
                    //此时，如果能找到一个i和j之间的数字k(k处的字符不能是“(”),使得dp[i+1][k-1]和dp[k+1][j]
                    for (int k = i+1; k <= i+size; k++) {
                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
                                (k == i+1 || dp[i+1][k-1]) &&
                                (k == i+size || dp[k+1][i+size])) {
                            dp[i][i+size] = true;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
