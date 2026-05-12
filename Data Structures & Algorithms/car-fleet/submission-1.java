class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 0) return 0;

        double[][] mix = new double[n][2];
        for(int i = 0; i < n; i++){
            mix[i][0] = position[i];
            mix[i][1] = speed[i];
        }
        Arrays.sort(mix, (a,b)-> Double.compare(a[0], b[0]));
        
        Deque<Double> st = new ArrayDeque<>();
        for(int i = n-1; i >= 0; i--){
            double time = (target - mix[i][0]) / mix[i][1];
            if(st.isEmpty() || time > st.peek()){
                st.push(time);
            } 
        }

        return st.size();
    }
}
