package Coding_Interview.Sword_Offer_051;

import java.util.Arrays;

/*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.multiply(new int[]{1,5,8,7,9})));
    }
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B=new int[length];
        if (length==0){
            return B;
        }
        int res = 1;
        B[0] = 1;
        for (int i=1;i<length;i++){
            res*=A[i-1];
            B[i]= res;
        }
        res = 1;
        for (int i=length-2;i>=0;i--){
            res*=A[i+1];
            B[i]*=res;
        }
        return B;
    }
}
