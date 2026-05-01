class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < numCourses; i++ ){
            mp.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int k = prerequisites[i][0];
            int v = prerequisites[i][1];
            if(mp.containsKey(k)){
                mp.get(k).add(v);
            }
        }

        int[] vis = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, vis, mp)){
                return false;
            } 
        }

        return true;
    }

    private boolean dfs(int node, int[] vis, Map<Integer, List<Integer>> mp){
        if(vis[node] == 1 ) return false;
        if(vis[node] == 2 ) return true;

        vis[node] = 1;
        for(int ind : mp.get(node)){
            if(!dfs(ind, vis, mp)) 
                return false;
        }

        vis[node] = 2;
        return true;
    }
}

// TC: O(N) N is the prerequisites.length as we iterate through all elements
// SC: O(N) N:numCourses to create a map of the same length
