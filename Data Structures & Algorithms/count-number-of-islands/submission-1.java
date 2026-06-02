class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        // Keep a visited list
        boolean[][] vis = new boolean[row][col];
        int numOfIsland = 0;

        // iterate through every element in 2d array
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
        // check for island
        // if yes make vis true and connect any adjacent coordinates and 
        // We can use dfs as well as we just want to count the number of island
                if(grid[r][c] == '1' && vis[r][c] == false){
                    dfs(grid, r, c, vis);    
                    numOfIsland++;
                }
            }
        }

        return numOfIsland;
        // Add it in the queue
        // iterate for the length of the queue
        // Now its time for BFS traversal for every possible node
        // Use queue to store 
    }

    private void dfs(char[][] grid, int r, int c, boolean[][] vis){
        if(grid[r][c] == '0' || vis[r][c] ) return;
        vis[r][c] = true;

        List<int[]> possibleCoordinates = findCordinates(r, c, grid, vis); 
        for(int i = 0; i  < possibleCoordinates.size(); i++){
            int[] arr = possibleCoordinates.get(i);
            int x = arr[0];
            int y = arr[1];

            dfs(grid,x,y,vis);
        }
        
    }

    private List<int[]> findCordinates(int r, int c, char[][] grid, boolean[][] vis){
        List<int[]> validCordinates = new ArrayList<>();
        int[][] coordinates = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] co:coordinates){
            int nR = r + co[0];
            int nC = c + co[1];
            if(nR >= 0 && nR < grid.length && nC >= 0 && nC < grid[0].length && vis[nR][nC] == false){
                validCordinates.add(new int[]{nR, nC});
            } 
        } 
        return validCordinates;
    }
}
