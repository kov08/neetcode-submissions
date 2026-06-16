class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        rec(0, target, candidates, lst, ans);
        return ans;
    }

    private void rec(int ind, int target, int[] nums, 
    List<Integer> lst, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(lst));
            return;
        }

        if(target < 0 || ind == nums.length)
            return;

        lst.add(nums[ind]);
        rec(ind+1, target-nums[ind], nums, lst, ans);
        
        lst.remove(lst.size() -1);
        while(ind + 1 <nums.length && nums[ind] == nums[ind+1]){
            ind++;
        }
        rec(ind+1, target, nums, lst, ans);
    }
}
