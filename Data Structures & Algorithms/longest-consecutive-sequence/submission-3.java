class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i: nums){
            set.add(i);
        }
        
        int ans = 0;
        for(int i: nums){
            if(!set.contains(i + 1)){
                int temp = 1;
                while(set.contains(i - 1)){
                    temp++;
                    i--;
                }
                ans = Math.max(temp, ans);
            }
        }

        return ans;
    }
}

// TC: O(n) iteration in for loop
// SC: O(n) store int[] to set 
