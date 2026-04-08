class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Sorted array (non decreasing order)
        // initialize two pointers (l and r)
        int l = 0, r = numbers.length - 1;

        // iterate them to find sum
        while(l < r){
            int sum = numbers[l] + numbers[r]; 
            if(sum == target){
                return new int[] {l + 1, r + 1};
            } else if(sum < target){
                l++;
            } else{
                r--;
            }
        }

        // return indices 
        return new int[] {-1,-1};
    }
}

// TC: O(N)
// SC: O(1)
