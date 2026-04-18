class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> que = new ArrayDeque<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) que.add(new int[] {i,j});
            }
        }
        
        while(!que.isEmpty()){
            int[] cord = que.poll();
            List<int[]> possibleCoordinates = coordinates(cord, grid);

            for(int[] pCrd: possibleCoordinates){
                int x = pCrd[0];
                int y = pCrd[1];
                grid[x][y] = 1 + grid[cord[0]][cord[1]];
                que.add(new int[] {x,y});
            }
        }
    }

    private List<int[]> coordinates(int[] cord, int[][] grid){
        int[][] co = {{1,0},{-1,0},{0,1},{0,-1}};
        List<int[]> ans = new ArrayList<>();

        for(int ind = 0; ind < co.length; ind++){
            int newX = cord[0] + co[ind][0];
            int newY = cord[1] + co[ind][1];

            if(newX >= 0 && 
            newX < grid.length &&
            newY >= 0 && 
            newY < grid[0].length && 
            grid[newX][newY] == Integer.MAX_VALUE) {
                ans.add(new int[] {newX, newY}); 
            } 
        }

        return ans;
    }
}

// TC O(M*N)
// SC O(M*N)
