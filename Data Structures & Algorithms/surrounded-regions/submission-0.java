class Solution {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        for(int c = 0; c < col; c++){
            if(board[0][c] == 'O'){
                dfs(0, c, board);
            }
            if(board[row-1][c] == 'O'){
                dfs(row-1, c, board);
            }
        }

        for(int r = 0; r < row; r++){
            if(board[r][0] == 'O'){
                dfs(r, 0, board);
            }
            if(board[r][col-1] == 'O'){
                dfs(r, col - 1, board);
            }
        }

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == 'A'){
                    board[r][c] = 'O';
                } else if(board[r][c] == 'O'){
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board){
        Deque<int[]> st = new ArrayDeque<>();
        board[i][j] = 'A';
        st.push(new int[]{i,j});

        while(!st.isEmpty()){
            int[] cord = st.pop();
            int x = cord[0], y = cord[1];
            int[][] pCo = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] co : pCo){
                int nx = x + co[0], ny = y + co[1];
                if(nx >= 0 && nx < board.length 
                && ny >= 0 && ny < board[0].length 
                && board[nx][ny] == 'O'){
                    board[nx][ny] = 'A';
                    st.push(new int[]{nx, ny});
                }
            } 
        }
    }
}

// TC: O(m*n) as we traverse through board
// SC: O(m*n) in worst case all elements may be 'O' and stack length would be m*n total element of board 
