class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || word == null) return true;

        int r = board.length;
        int c = board[0].length;

        int t = 0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(board[i][j] == word.charAt(0)){
                    board[i][j] = '#';
                    if( dfs(i, j, 1, board, word) ) return true;
                    board[i][j] = word.charAt(0);
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int t, char[][] board, String word){
        if(t == word.length()) return true;
        
        char org = board[i][j];
        board[i][j] = '#';
        
        int[] dx = {1, 0,-1, 0};
        int[] dy = {0, 1, 0, -1};

        for(int z = 0; z < 4; z++){
            int nx = i + dx[z];
            int ny = j + dy[z];

            if(nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length && board[nx][ny] != '#'){
                if(board[nx][ny] == word.charAt(t)){
                    if(dfs(nx, ny, t+1, board, word)) return true;
                }
            }
        }
        board[i][j] = org;
        return false;
    }
}

// TC O(m*N *4^L) m*n : board dim | L : len of the word
// SC O(L) recursive depth upto L 