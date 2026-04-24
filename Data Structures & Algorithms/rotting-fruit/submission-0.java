class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> que = new ArrayDeque<>();
        int freshOrgCount = 0;
        int min = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2) {
                    que.add(new int[]{i,j});
                } else if(grid[i][j] == 1){
                    freshOrgCount++;
                }
            }
        }

        if(freshOrgCount == 0) return 0;
        
        while(!que.isEmpty()){
            int len = que.size();
            boolean orgRot = false;
            List<int[]> possibleCoord = new ArrayList<>();
            for(int i = 0; i < len; i++){
                int[] xy = que.poll();
                int x = xy[0];
                int y = xy[1];
                possibleCoord.addAll(coordinates(x,y,grid));
            }

            for(int[] pc : possibleCoord){
                int newX = pc[0];
                int newY = pc[1];
                que.add(new int[] {newX, newY});
                freshOrgCount--;
                orgRot = true;
            }
            if(orgRot) min++;
        }
       
        return freshOrgCount == 0 ? min : -1;
    }

    private List<int[]> coordinates(int x, int y, int[][] grid){
        int[][] coord  = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        List<int[]> ans = new ArrayList<>();
        for(int[] co: coord){
            int nx = x + co[0];
            int ny = y + co[1];
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1){
                ans.add(new int[]{nx, ny});
                grid[nx][ny] = 2;
            }
        }

        return ans;
    }
}

// TC: O(m*n) as we need to traverse every element 
// SC: O(m*n) in the worst case if there are no fresh oranges int he grid
