package Leetcode.No_476_Complement_Number;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i=0;i<20;i++){
            System.out.println(solution.findComplement(i));
        }
    }
    public int findComplement(int num) {
        int i = 2;
        int local = num;
        while (local>=2){
            i=i<<1;
            local=local>>1;
        }
        return (i-1)^num;
    }
}
