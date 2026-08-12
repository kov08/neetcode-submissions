class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i: nums){
            mp.merge(i, 1, Integer::sum);
        }

        List<Integer>[] freq = new ArrayList[nums.length+1];
        for(int i = 0; i < nums.length+1; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: mp.entrySet()){
            Integer key = entry.getKey();
            Integer v = entry.getValue();
            freq[v].add(key);
        }

        int[] ans = new int[k];
        int idx =  0;
        for(int i = nums.length; i >= 0 && k > 0; i--){
            if(!freq[i].isEmpty()){
                for(Integer in: freq[i]){
                    ans[idx++] = in;
                    if(idx == k) return ans;
                }
            }
        }

        return ans;
    }
}

// TC: O(n)
// SC: O(n)