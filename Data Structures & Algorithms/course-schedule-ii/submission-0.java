class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp  = new HashMap<>();
        for (int i = 0; i < numCourses; i++ ){
            mp.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            if(mp.containsKey(pre[0])){
                mp.get(pre[0]).add(pre[1]);
            }
        }

        int[] vis = new int[numCourses];
        Deque<Integer> st = new ArrayDeque<>(); 
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i, vis, mp, st)){
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        int i = numCourses;
        while(!st.isEmpty()){
            ans[i-1] = st.pop();
            i--;
        }

        return ans;
    }

    private boolean dfs(int node, int[] vis, Map<Integer, List<Integer>> mp, Deque<Integer> st){
        if(vis[node] == 1) return false;
        if(vis[node] == 2) return true;

        vis[node] = 1;
        for(int pre: mp.get(node)){
            if(vis[pre] == 1){
                return false;
            } else { 
                dfs(pre, vis, mp, st);
            }
        }
        st.push(node);
        vis[node] = 2;
        return true;
    }
}

// TC: O(V + E)
// SC: O(V + E)