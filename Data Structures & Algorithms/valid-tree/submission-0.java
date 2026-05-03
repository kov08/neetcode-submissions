class Solution {
    public boolean validTree(int n, int[][] edges) {
    //  A vaild tree must be a signle connected component and must have n-1 edges
    if(edges.length != n - 1) return false;

    // Adj list
    List<List<Integer>> adj = new ArrayList<>();
    for(int  i = 0; i < n; i++) adj.add(new ArrayList<>());
    for(int[] edge : edges){
        adj.get(edge[0]).add(edge[1]);
        adj.get(edge[1]).add(edge[0]);
    }

    Set<Integer> vis = new HashSet<>();
    // Only a dfs call because a tree must be a single connected compenent
    dfs(0, adj, vis);

    return vis.size() == n;
    }

    private void dfs(int i, List<List<Integer>> adj, Set<Integer> vis){
        if(vis.contains(i)) return;
        vis.add(i);
        for(int node : adj.get(i)){
            dfs(node, adj, vis);
        }
    }
}

// TC: O(Edge + Node)
// SC: O(Edge + Node)
