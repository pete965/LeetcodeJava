package Leetcode_Bytedance.No_122_Best_Time_to_Buy_and_Sell_Stock_Part_Two;

public class Solution {
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
