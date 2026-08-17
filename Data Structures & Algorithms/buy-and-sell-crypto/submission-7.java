class Solution {
    public int maxProfit(int[] prices) {
        int b = prices[0] , accumulatedProfit = Integer.MIN_VALUE;
        for(int i = 1; i  <prices.length; i++){
            if(b > prices[i]){
                b = prices[i];
            } else{
                accumulatedProfit = Math.max(accumulatedProfit, prices[i] - b);
            }
        }
        return accumulatedProfit == Integer.MIN_VALUE? 0: accumulatedProfit;
    }
}

// TC O(n)
// SC O(1)