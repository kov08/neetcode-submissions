class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
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

// TC: O(N) + O(N*logM) N: length of an array and M: max value of the array
// SC: O(1)
