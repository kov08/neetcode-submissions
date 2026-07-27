class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i: nums){
            mp.put(i, mp.getOrDefault(i,0)+1);
        }

        List<Integer>[] buckets = new List[nums.length+1];
        for(int i = 0 ; i < buckets.length; i++){
            buckets[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> m: mp.entrySet()){
            buckets[m.getValue()].add(m.getKey());
        }

        int[] ans = new int[k];
        int ind = 0 ;
        for(int i = buckets.length-1; i >= 0; i--){
            for(int num: buckets[i]){
                ans[ind++] = num;
                if(ind == k) return ans;
            }
        }
        return ans;
    }
}
