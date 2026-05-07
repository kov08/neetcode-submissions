class Solution {
    public int climbStairs(int n) {
        if( n <= 2) return n;
        // divide problem into number of smaller problem that either take 1 or 2 steps 
        // repeatatively perform this step until reached the given number
        // this leads to recurssion

        // Space ooptimized by saving only two numbers as in all iterartion we need only 2 numbers
        int oneStep = 1;
        int twoStep = 2;

        // Bottom up approach where we start from  bottom 2 and reached till the given number
        for(int i = 3; i <= n; i++){
            int temp = oneStep + twoStep;
            oneStep = twoStep;
            twoStep = temp;
        }
        return twoStep;
    }
}

// TC O(n)
// SC O(1)
