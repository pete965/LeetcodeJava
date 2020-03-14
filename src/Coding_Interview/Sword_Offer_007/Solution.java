package Coding_Interview.Sword_Offer_007;

/*
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
n<=39
 */
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
