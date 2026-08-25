class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curlst = new ArrayList<>();
        
        Arrays.sort(candidates);
        rec(0, candidates, target, curlst, ans);
        return ans;
    }

    private void rec(int i, int[] nums, int target, List<Integer> curlst, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(curlst));
            return;
        }

        for(int j = i; j < nums.length; j++){
            if(nums[j] > target) break; 

            if(j > i && nums[j] == nums[j-1]) continue;
            
            curlst.add(nums[j]);
            rec(j+1, nums, target - nums[j], curlst, ans);
            curlst.remove(curlst.size() - 1);
        }    
    }
}
