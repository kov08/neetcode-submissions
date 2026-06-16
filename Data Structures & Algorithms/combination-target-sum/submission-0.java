class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        rec(0, target, lst, nums, ans);
        return ans;
    }

    private void rec(int ind, int target, List<Integer> lst, 
    int[] nums, List<List<Integer>> ans){
    if(target == 0){
        ans.add(new ArrayList<>(lst));
        return;
    }
    if(nums.length == ind || target < 0) 
        return;
        
    lst.add(nums[ind]);
    rec(ind,  target - nums[ind], lst, nums, ans);
    
    lst.remove(lst.size()-1);
    rec(ind+1, target, lst, nums, ans);
    }
}
