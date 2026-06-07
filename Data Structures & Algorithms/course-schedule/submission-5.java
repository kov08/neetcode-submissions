class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj =  new List[numCourses];
        for(int i = 0; i < numCourses; i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] arr : prerequisites){
            adj[arr[0]].add(arr[1]);
        }

        int[] vis = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(vis[i] == 0){
                if(hasCycle(i, adj, vis)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int sub, List<Integer>[] adj, int[] vis){
        if(vis[sub] == 1) return true;
        if(vis[sub] == 2) return false;

        vis[sub] = 1;
        for(int i: adj[sub]){
            if(hasCycle(i, adj, vis)){
                return true;
            }
        } 
        vis[sub] = 2;
        return false;
    }
}
