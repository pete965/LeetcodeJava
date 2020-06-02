package Leetcode_Bytedance.No_354_Russian_Doll_Envelopes;

import java.util.Arrays;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0) return 0;
        Arrays.sort(envelopes,(int[] a, int[] b) -> (a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]));
        int m = envelopes.length;
        // max end in index i
        int[] A = new int[m];
        int res = 1;
        Arrays.fill(A,1);
        for(int i=1;i<m;i++){
            for(int j = 0; j<i;j++) {
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    A[i] = Math.max(A[i],A[j]+1);
                }
            }
            res = Math.max(res,A[i]);
        }
        return res;
    }
}
