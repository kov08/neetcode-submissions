class Solution {
    public int numIslands(char[][] grid) {
        Deque<int[]> que = new ArrayDeque<>();
        int iLand = 0;
        int[][] vis= new int[grid.length][grid[0].length];

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    vis[i][j] = 1;
                    que.add(new int[]{i,j});
                } else {
                    continue;
                }

                while(!que.isEmpty()){
                    int[] topEle = que.pop();
                    ArrayList<int[]> neighbours = validN(topEle, grid, vis);
                    for(int ind = 0; ind < neighbours.size(); ind++){
                        int x = neighbours.get(ind)[0];
                        int y = neighbours.get(ind)[1];
                        vis[x][y] = 1;
                        que.add(new int[] {x,y});
                    }
                }

                iLand++;
            }
        }
        return iLand;
    }

    private ArrayList<int[]> validN(int[] topEle, char[][] grid, int[][] vis){
        int[][] neighbour = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        ArrayList<int[]> validNbr = new ArrayList<>();
        for(int i = 0; i < neighbour.length; i++){
            int x = topEle[0] + neighbour[i][0];
            int y = topEle[1] + neighbour[i][1];

            if(x >= 0 && x < grid.length 
                && y >= 0 && y < grid[0].length
                && grid[x][y] == '1'
                && vis[x][y] == 0){
                    validNbr.add(new int[] {x,y});
            }
        }
        return validNbr;
    }
}

// TC: O(m * N) loop traversal of all grid element (while loop for non-empty que only) 
// SC: O(m * N) vis[][]
