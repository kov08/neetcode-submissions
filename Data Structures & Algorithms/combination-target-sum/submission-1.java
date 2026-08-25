class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        int sum = 0;
        rec(nums.length-1, sum, nums, target, curset, ans);
        return ans;
    }

    private void rec(int i, int sum, int[] nums, int t, List<Integer> curset, List<List<Integer>> ans){
        if(sum == t){
            ans.add(new ArrayList<>(curset));
            return;
        }
        if(i < 0 || sum > t) return;
        
        // not pick 
        rec(i-1, sum, nums, t, curset, ans);

        // pick
        curset.add(nums[i]);
        rec(i, sum + nums[i], nums, t, curset, ans);
        curset.remove(curset.size() - 1);
    }
}
