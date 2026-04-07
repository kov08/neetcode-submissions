class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hSet = new HashSet<>();
        for(int num: nums){ 
            hSet.add(num);
        }

        int longestConsecutive = 0;
        for(int num: nums){
            if(!hSet.contains(num-1)){
                int currentStreak = 1;

                while(hSet.contains(num+1)){
                    currentStreak++;
                    num += 1;
                }
                longestConsecutive = Math.max(currentStreak, longestConsecutive);
            }
        }
        return longestConsecutive;
    }
}

// TC: O(N) 
// SC: O(N) 
