class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans =new ArrayList<>();
        List<Integer> lst = new ArrayList<>();
        rec(0, lst, nums, ans);
        return ans;
    }

    private void rec(int ind, List<Integer> lst, int[] nums, List<List<Integer>> ans){
        // base Case 
        if(ind == nums.length){
            ans.add(new ArrayList<>(lst));
            return;
        }

        // add the element at the current index in the lst
        lst.add(nums[ind]);

        // take the current element
        rec(ind+1, lst, nums, ans);

        // rmeove the last element from the list and execute the fun
        lst.remove(lst.size()-1);

        // nontake the current element
        rec(ind+1, lst, nums, ans);

    }
}

// TO print all subsequence we use take and nontake approach
// TC: O(n*2^n) where n is the number of int in an int[] 
// storing lst to a new arraylist while adding to ans takes n and for rec: 2^n 
// SC O(n) auxiliary space