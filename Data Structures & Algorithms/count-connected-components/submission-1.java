class Solution {
    public int countComponents(int n, int[][] edges) {
        // Create an Adj List
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // Introduce Visitor set
        Set<Integer> vis = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(!vis.contains(i)){
                ans++;
                dfs(i,adj, vis);
            }
        }

        return ans;
    }

    private void dfs(int node, List<List<Integer>> adj, Set<Integer> vis){
        if(vis.contains(node)) return;
        vis.add(node);
        for(int neighbor: adj.get(node)){
            dfs(neighbor, adj, vis);
        }
    }
}


// TC: O(N + E)
// SC: O(N + E)
