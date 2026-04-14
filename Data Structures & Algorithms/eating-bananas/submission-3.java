class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        Arrays.sort(piles);
        int l = 1, r = piles[piles.length -1];
        int minRate = Integer.MAX_VALUE;

        while(l <= r){
            int rate = (l + r) / 2;
            int time = isPossible(piles, rate);
            if( time <= h){
                minRate = Math.min(minRate , rate);
                r = rate - 1;
            } else {
                l = rate + 1;
            }
        }
        return minRate;
    }

    private int isPossible(int[] piles, int rate){
        int ans = 0;
        for(int pile : piles){
            ans += pile / rate;
            if(pile % rate != 0) {
                ans +=1; 
            }
        }
        return ans;
    }
}
