package Leetcode_Bytedance.No_121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=0;i<length;i++){
            if (minPrice<prices[i]){
                minPrice=prices[i];
            }else if (prices[i]-minPrice>maxProfit){
                maxProfit=prices[i]-minPrice;
            }
        }
        return maxProfit;
    }
}
