class Solution {
    public boolean exist(char[][] board, String word) {

        // rec dfs
        // loop the grid until find the first char add then dfs if find return true else continue the loop
        // return false at the end;
        int row = board.length;
        int col = board[0].length;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == word.charAt(0)){
                    char temp = board[r][c];
                    board[r][c] = '#';
                    if(word.length() == 1){ return true; }
                    else if(dfs(0, r, c, board, word)){
                        return true;
                    }
                    board[r][c] = temp;
                }
            }
        } 
        return false;
    }

    private boolean dfs(int chInd, int r, int c, char[][] board, String word){
        // if(chInd == word.length()-1){
        //     return true;
        // }
        int[][] possibleSteps = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int[] step: possibleSteps){
            int nx = step[0] + r;
            int ny = step[1] + c;
            if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && 
            board[nx][ny] == word.charAt(chInd+1)){

                char temp = board[nx][ny];
                board[nx][ny] = '#';
                if(chInd + 1 == word.length() - 1 || dfs(chInd+1, nx, ny, board, word)){
                    return true;
                }
                board[nx][ny] = temp;

            }
        }
        return false;
    }
}
// TC O(m*n*3^L) m*n for loop and 3^L is the possible stepsfrom any given point and call recursion
// SC: O(L) depth of recursion stack (ie: length of the word )