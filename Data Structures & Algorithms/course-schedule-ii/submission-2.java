class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean hasC = false;
        // prepare adj list
        List<Integer>[] adj = new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre : prerequisites){
            adj[pre[0]].add(pre[1]);
        }

        // check for cycle
        // use queue to add sub list
        // if no cycle ditected return new int[] with queue
        // else return empty[]
        int[] vis = new int[numCourses];
        Deque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0){
                if(hasCycle(i, adj, vis, q)){
                    return new int[]{};
                }
            }
        }

        int[] ans = new int[numCourses];
        int i = 0;
        while(!q.isEmpty()){
            ans[i] = q.poll();
            i++;
        }
        return ans;
    }

    private boolean hasCycle(int sub, List<Integer>[] adj, int[] vis, Deque<Integer> q){
        if(vis[sub] == 1) return true;
        if(vis[sub] == 2) return false;

        vis[sub] = 1;
        for(int i : adj[sub]){
            if(hasCycle(i, adj, vis, q)){
                return true;
            }

        }

        vis[sub] = 2;
        q.add(sub);
        return false;
    }
}
