class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curset = new ArrayList<>();
        rec(nums.length - 1, nums, curset, ans);
        return ans;
    }

    private void rec(int i, int[] nums, List<Integer> curset, List<List<Integer>> ans){
        // base condt
        if(i < 0){
            ans.add(new ArrayList<>(curset));
            return;
        }

        // index
        // not pick
        rec(i - 1, nums, curset, ans);

        // pick
        curset.add(nums[i]);
        rec(i - 1, nums, curset, ans);
        curset.remove(curset.size() - 1);
    }
}

// TC: O(n * 2^N)
// SC O(N)
