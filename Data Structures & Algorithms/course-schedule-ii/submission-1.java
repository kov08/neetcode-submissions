class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adjList to reduce inDegree
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            mp.put(i, new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for(int[] pre: prerequisites){
            inDegree[pre[0]]++;
            mp.get(pre[1]).add(pre[0]);
        }


        int[] ans = new int[numCourses];
        Deque<Integer> que = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                que.add(i);
            }
        }

        // BFS : reducing indegree of all elements which has prerequisite of que.peek()
        int ind = 0;
        while(!que.isEmpty()){
            int ele = que.peek();
            for(Integer e: mp.get(ele)){
                inDegree[e]--;
                if(inDegree[e] == 0){
                    que.add(e);
                }
            }
            que.pop();
            ans[ind] = ele;
            ind++;
        }

        return ind == numCourses ? ans : new int[0];
    }
}

// TC: O(V+E)
// SC: O(V+E)