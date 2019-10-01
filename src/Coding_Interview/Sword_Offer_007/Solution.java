package Coding_Interview.Sword_Offer_007;

public class Solution {
    public int Fibonacci(int n) {
        if (n==0||n==1){
            return n;
        }
        int[] array=new int[n+1];
        array[0]=0;
        array[1]=1;
        int i;
        for (i=2;i<n+1;i++){
            array[i]=array[i-1]+array[i-2];
        }
        return array[i-1];
    }
}
