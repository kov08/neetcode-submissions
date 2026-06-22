class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] chArr: board){
            Arrays.fill(chArr, '.');
        }
        boolean[] hor = new boolean[n];
        boolean[] uDia = new boolean[(2*n) -1];
        boolean[] lDia = new boolean[(2*n) -1];

        List<List<String>> ans = new ArrayList<>();
        rec(0, board, hor, uDia, lDia, ans, n);
        return ans;    
    }

    private void rec(int col, char[][] board, boolean[] hor, 
    boolean[] uDia, boolean[] lDia, List<List<String>> ans, int n){
        if(col == n){
            List<String> lst = Arrays.stream(board)
                                    .map(String::new)
                                    .collect(Collectors.toList());
            ans.add(lst);
            return;
        }
        
        for(int row = 0; row < n; row++ ){
            if(hor[row] || uDia[(n-1) + (col - row)] || lDia[row + col]) continue;
            hor[row] = true;
            uDia[(n-1) + (col - row)] = true;
            lDia[row+col] = true;
            board[row][col] = 'Q';
            rec(col+1, board, hor, uDia, lDia, ans, n);
            board[row][col] = '.';
            hor[row] = false;
            uDia[(n-1) + (col - row)] = false;
            lDia[row+col] = false;    
        }   
    }
}

// TC O(N!) 
// SC O(N^2)
