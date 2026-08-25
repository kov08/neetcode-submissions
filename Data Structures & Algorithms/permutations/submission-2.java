class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        boolean[] vis=  new boolean[nums.length];
        rec(nums, vis, cur, ans);
        return ans;
    }

    private void rec(int[] nums, boolean[] vis, List<Integer> cur, List<List<Integer>> ans){
        if(cur.size() == nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(vis[i]) continue;

            cur.add(nums[i]);
            vis[i] = true;

            rec(nums, vis, cur, ans);

            vis[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
