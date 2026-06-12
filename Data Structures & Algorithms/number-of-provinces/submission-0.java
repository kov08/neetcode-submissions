class Solution {
    public int findCircleNum(int[][] isConnected) {
        int row = isConnected.length;
        boolean[] vis = new boolean[row];

        int provience = 0;
        for(int i = 0; i <row; i++){
            if(vis[i] == false){
                dfs(i, isConnected, vis);
                provience++;
            }
        }
        return provience;
    }

    private void dfs(int city, int[][] isConnected, boolean[] vis){
        if(vis[city] == true) return;

        vis[city]  =true;
        for(int nei = 0; nei < isConnected[0].length; nei++){
            if(isConnected[city][nei] == 1){
                dfs(nei, isConnected, vis);
            }
        }
    }
}