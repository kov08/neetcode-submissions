class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        rec(0, nums, cur, ans);
        return ans;
    }

    private void rec(int j, int[] nums, List<Integer> cur, List<List<Integer>> ans){
        ans.add(new ArrayList<>(cur));
        

        for(int i = j; i < nums.length; i++){

            if(i > j && nums[i] == nums[i -1]) continue;

            cur.add(nums[i]);
            rec( i+1, nums, cur, ans);
            cur.remove(cur.size() - 1);
        }
        
    }
}

// TC O(N* 2^N) N len of nums * each state has two possibilities take and not take 
// SC O(N) N; cur and auxilury stack space
