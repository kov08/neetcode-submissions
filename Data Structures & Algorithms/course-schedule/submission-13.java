class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i =0; i < numCourses; i++){
            mp.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            mp.get(pre[0]).add(pre[1]);
        }

        int[] vis = new int[numCourses];

        for(int i = 0; i < numCourses; i++){
            if(hasCycle(i, mp, vis)){
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int course, Map<Integer, List<Integer>> mp, int[] vis ){
        if(vis[course] == 1) return true;
        if(vis[course] == 2) return false;

        List<Integer> lst = mp.get(course);
        vis[course] = 1;
        if(lst.size() != 0){
            for(int i = 0; i < lst.size(); i++){
                if(hasCycle(lst.get(i), mp, vis)){
                    return true;
                }
            }
        }
        vis[course] = 2;
        return false;
    }
}
