class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> mp = new HashMap<>();

        for(int i: nums){
            mp.put(i, mp.getOrDefault(i, 0)+1);
        }

        for(int i = 0; i < nums.length+1; i++){
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> m  : mp.entrySet()){
            bucket[m.getValue()].add(m.getKey());
        }

        int[] ans = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0; i--){
            for(int ind : bucket[i]){
                ans[index++] = ind;
                if(index == k){
                    return ans;
                }    
            }
        }

        return ans;
    }
}
