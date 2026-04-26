class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int row = heights.length, col = heights[0].length;

        // Introduce pac and atl boolean array to store the value that which cell can reach the ocean
        // This significantly faster the solution 
        boolean[][] pac = new boolean[row][col];
        boolean[][] alt = new boolean[row][col];


        // In dfs We check opposite of the given situation: water can flow from top to bottom
        // As we are checking it from boundries instead of applying dfs at every cell in the grid
        // Because it might be possible that thre are cells which are surrounded by lower heights 
        // but cannot meet to any ocean due higher height neighbors 
        for(int c = 0; c < col; c++){
            dfs(0, c, pac, heights[0][c], heights);
            dfs(row - 1, c, alt, heights[row - 1][c], heights);
        }

        for(int r = 0; r < row; r++){
            dfs(r, 0, pac, heights[r][0], heights);
            dfs(r, col -1, alt, heights[r][col - 1], heights);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int r = 0; r < row; r++){
            for(int c = 0; c <col; c++){

                if(pac[r][c] && alt[r][c]){
                    ans.add(Arrays.asList(r,c));
                }
            }
        }
        
        return ans;    
    }

    private void dfs(int r, int c, boolean[][] oceanArr, int prevHeight, int[][] heights){
        
        if( r < 0 || c < 0 || r > heights.length - 1 || c > heights[0].length - 1 || 
            oceanArr[r][c] ||
            heights[r][c] < prevHeight){
            return;
        }
        
        oceanArr[r][c] = true;
        
        dfs(r - 1, c, oceanArr, heights[r][c], heights);
        dfs(r + 1, c, oceanArr, heights[r][c], heights);
        dfs(r, c - 1, oceanArr, heights[r][c], heights);
        dfs(r, c + 1, oceanArr, heights[r][c], heights);
    }
}

// TC: O(m * n) (As we traversed through every cell in the heights 2-d array)
// SC: O(m * n) (when all heights are same, as we are building a set + stack space of dfs 4*O(m-1 * n-1) 