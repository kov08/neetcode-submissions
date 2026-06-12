class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> pre = new HashMap<>();
        for(int[] p : prerequisites){
            int course = p[0];
            int req = p[1];
            pre.computeIfAbsent(course, r-> new ArrayList<>()).add(req);
        } 
        List<Integer> ans = new ArrayList<>();

        int[] vis = new int[numCourses];
        // 3 states
        // 0 unvisited
        // 1 visiting
        // 2 visited
        for(int i = 0; i< numCourses; i++){
            if(!dfs(i, pre, vis, ans)){
                return new int[]{};
            }
        }
        if(ans.size() == numCourses){
            int[] arr = ans.stream().
                            mapToInt(Integer::intValue).
                            toArray();
            return arr;
        }
        return new int[]{};
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> pre, int[] vis,List<Integer> ans){
        
        if(vis[course] == 2) return true;
        if(vis[course] == 1) return false;
        
        vis[course] = 1;
        List<Integer> ls = pre.get(course);
        if(ls != null) {
            for(int i : ls){
                if(!dfs(i, pre, vis, ans)){
                    return false;
                }
            }
        }
        vis[course] = 2;
        ans.add(course);
        return true; 
    }
}
