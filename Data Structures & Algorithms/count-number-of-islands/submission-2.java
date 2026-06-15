class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length, col = grid[0].length;

        int island = 0;
        boolean[][] vis = new boolean[row][col];
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1' && vis[r][c] == false){
                    bfs(r,c, grid, vis);
                    island++;
                }
            }
        }
        return island;
    }

    private void bfs(int r, int c, char[][] grid, boolean[][] vis){
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r,c});
        vis[r][c] = true; 

        int[][] possibleCo = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i =0; i < size; i++){
                int[] co = q.poll();
                int x = co[0];
                int y = co[1];

                for(int[] step: possibleCo){
                    int nx = x + step[0];
                    int ny = y + step[1];

                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == '1' && vis[nx][ny] == false){
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}

// TC O (m * n)
// SC O (m * n)