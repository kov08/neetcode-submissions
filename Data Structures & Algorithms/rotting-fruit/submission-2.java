class Solution {
    public int orangesRotting(int[][] grid) {
        int[] freshFruitCount = new int[1];
        Deque<int[]> que = new ArrayDeque<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++){
                if(grid[r][c] == 1){
                    freshFruitCount[0]++;
                } else if(grid[r][c] == 2){
                    vis[r][c] = true;
                    que.add(new int[]{r,c});
                }
            }
        }

        if(freshFruitCount[0] == 0) return 0;

        int time = 0;
        while(!que.isEmpty()){
            int len = que.size();

            for(int i = 0; i < len; i++){
                int[] ind = que.poll();
                int r = ind[0];
                int c = ind[1];
                freshFruit(r, c, freshFruitCount, grid, vis, que);
            }
            time += 1;
        }

        return freshFruitCount[0] == 0 ? time-1 : -1;
    }
    private void freshFruit(int r, int c, int[] freshFruitCount, int[][] grid, boolean[][] vis, Deque<int[]> que){
        int[][] possibleCoordinates = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int[] co: possibleCoordinates){
            int nx = r + co[0];
            int ny = c + co[1];
            if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1  && !vis[nx][ny]){
                freshFruitCount[0]--;
                vis[nx][ny] = true;
                que.add(new int[]{nx, ny});
            }
        }
    }
}

