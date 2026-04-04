class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // declare a hasmap to count freq
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i: nums){
            mp.put(i, mp.getOrDefault(i,0) + 1);
        }

        // introduce a List of size of the nums because max_freq <= nums.length 
        // based on the freq append the numbers in the buckets
        List<Integer>[] bucketList = new List[nums.length + 1];
        
        // create an array list on each of the index to accomodate multiple numbers having the same freq
        for(int i = 0; i < bucketList.length; i++){
            bucketList[i] = new ArrayList<>();
        }
        
        // now segegrate numbers based on their freq
        for(int num : mp.keySet()){
            bucketList[mp.get(num)].add(num);
        }

        // form an arrayList to get elements from the bucketList of top k ele by iterating it from the last bucket
        List<Integer> res = new ArrayList<>();
        for(int i = bucketList.length - 1; i >= 0 && res.size() < k; i--){
            if(!bucketList[i].isEmpty()){
                res.addAll(bucketList[i]);
            }
        }

        // form an array of the exact size of k and return it 
        int[] topK = new int[k];
        for(int i = 0; i < k; i++){
            topK[i] = res.get(i);
        }

        return topK;
    }   
}

// TC O(N) bucket sort
// SC O(N) 