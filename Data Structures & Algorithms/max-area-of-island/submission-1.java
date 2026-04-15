class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int area = 0;
        int[][] vis = new int[grid.length][grid[0].length];
        Deque<int[]> que = new ArrayDeque<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    area = 1;
                    vis[i][j] = 1;
                    que.add(new int[] {i,j});
                } else {
                    continue;
                }

                while(!que.isEmpty()){
                    int[] topEle = que.pop();
                    ArrayList<int[]> neighbors = validNeighbors(topEle, grid, vis);
                    for(int ind = 0; ind < neighbors.size(); ind ++){
                        int x = neighbors.get(ind)[0];
                        int y = neighbors.get(ind)[1];

                        vis[x][y] = 1;
                        area += 1;
                        que.add(new int[] {x,y});
                    }
                }
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private ArrayList<int[]> validNeighbors(int[] topEle, int[][] grid, int[][] vis){
        ArrayList<int[]> validNbr = new ArrayList<>();
        int[][] lst = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i = 0; i < lst.length; i++){
            int x = topEle[0] + lst[i][0];
            int y = topEle[1] + lst[i][1];

            if(x >= 0 && x < grid.length 
            && y >= 0 && y < grid[0].length
            && grid[x][y] == 1
            && vis[x][y] == 0){
                validNbr.add(new int[] {x,y});
            }
        }
        return validNbr;
    }
}
// TC: O(M * N)
// SC: O(M * N)
