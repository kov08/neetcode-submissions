class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeapPq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones){
            maxHeapPq.add(stone);
        }
        while(maxHeapPq.size() > 1){
            int one = maxHeapPq.poll();
            int two = maxHeapPq.poll();
            if(one != two){
                maxHeapPq.add(Math.abs(one - two));
            }
        }
        return maxHeapPq.isEmpty() ? 0 : maxHeapPq.peek();
    }
}
