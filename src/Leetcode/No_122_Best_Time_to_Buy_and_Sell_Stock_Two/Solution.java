package Leetcode.No_122_Best_Time_to_Buy_and_Sell_Stock_Two;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(solution.maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(solution.maxProfit(new int[]{}));
    }
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int output = 0;
        for (int i=0;i<length-1;i++){
            if (prices[i]<prices[i+1]){
                output+=prices[i+1]-prices[i];
            }
        }
        return output;
    }
}
