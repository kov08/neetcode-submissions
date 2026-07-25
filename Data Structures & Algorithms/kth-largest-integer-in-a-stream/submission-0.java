class KthLargest {
    int k;
    PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k; 
        this.pq = new PriorityQueue<>(k);
        
        for(int i: nums){
            add(i);
        }
    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
