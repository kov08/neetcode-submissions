class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // store freq in hashmap and O(1) for addition
        // use priority que sort top k element

        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i, mp.getOrDefault(i,0)+1);
            // mp.putIfAbsent(i, 0);
            // mp.put(i, mp.get(i)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.getValue(),b.getValue()));
        // TC O(NlogK considerign N unique element in the maa nd logK time reuqired for insert and delete entry in pq of length k)
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            pq.add(entry);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for(int i = k-1; i >= 0; i--){
            ans[i] = pq.poll().getKey();
        }

        return ans;
    }
}
