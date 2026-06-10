class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Approach 2
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (map.get(a) - map.get(b)));
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for(int a: map.keySet()){
            pq.add(a);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans=  new int[k];
        for(int i = k-1; i >= 0; i--){
            ans[i] = pq.poll();
        }

        return ans;

        // Approach 1:
        // iterate
        // frequency map while storing the max freq
        // return the max freq
        // TC: O(N)
        // this approach is not Applicable as question asks for top k not only top ele.

        // Approach 2:
        // iterate
        // MAintain a map to store freq
        // priority que to track top k
        // return 
        // TCO(NlogK)
        // SC: O(N+K)
    }
}
