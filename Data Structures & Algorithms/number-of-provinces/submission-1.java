class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int provience = 0;
        for(int  i = 0; i < isConnected.length; i++){
            if(!vis[i]){
                dfs(i, isConnected, vis);
                provience++;
            }
        }
        return provience;
    }

    private void dfs(int city, int[][] isConnected, boolean[] vis){
        if(vis[city]) return;

        vis[city] = true;
        for(int nei = 0; nei < isConnected.length; nei++){
            if(isConnected[city][nei] == 1){
                dfs(nei, isConnected, vis);
            } 
        }
    }
}

// TC O (V*V) V vertices and check for all V vertices for every vertices
// SC O(N) vis arr