class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int fFruit = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int row = grid.length;
        int col = grid[0].length;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 2){
                    q.add(new int[]{r,c});
                } else if( grid[r][c] == 1){
                    fFruit++;
                }
            }
        }

        if(fFruit == 0) return 0;

        int time = 0;
        int[][] pCoord = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.isEmpty()){
            int len = q.size();
            boolean rotOrg = false;

            for(int i = 0; i < len; i++){
                int[] co = q.poll();

                for(int[] pCo : pCoord){
                    int nx = co[0] + pCo[0];
                    int ny = co[1] + pCo[1];

                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny] == 1){
                        grid[nx][ny] = 2;
                        fFruit--;
                        rotOrg = true;
                        q.add(new int[]{nx, ny});
                    }
                } 
            }
            if(rotOrg) time++;
        }

        return fFruit == 0 ? time: -1;
    }
}
