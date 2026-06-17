class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        rec(0, nums, lst, ans);
        return ans;
    }

    private void rec(int ind, int[] nums, List<Integer> lst, List<List<Integer>> ans){

        ans.add(new ArrayList<>(lst));

        for(int i = ind; i < nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]) continue;

            lst.add(nums[i]);
            rec(i+1, nums, lst, ans);
            lst.remove(lst.size() - 1);
        }
    }
}   

// TC O(n*2^n) 2^n to create all possible subset and n to store each lst to ans 
// SC O(n) stack space and lst list of maximum length n