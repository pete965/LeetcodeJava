package Leetcode.No_202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isHappy(2));
    }
    Set<Integer> set = new HashSet<>();
    public boolean isHappy(int n) {
        set.add(n);
        int sum = 0;
        while(n>0){
            sum+=Math.pow(n%10,2);
            n/=10;
        }
        System.out.println("sum:"+sum);
        if(sum==1){
            return true;
        }else if(!set.contains(sum)){
            return isHappy(sum);
        }else{
            return false;
        }
    }
}
