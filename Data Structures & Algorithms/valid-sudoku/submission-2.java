class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Zero: It is the most important to understand the problem properly that what is asked
        // First: question only asks to check sudoku board is valid or not, |NOT| is solvable or not  
        // So we check is there any number repeart in the row, col or 3*3 box by marking it true on iteration

        boolean[][] row = new boolean[rows][cols];
        boolean[][] col = new boolean[rows][cols];
        boolean[][] boxes = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            for (int c = 0; c < cols; c++){
                if(board[r][c] == '.') continue;

                int num = board[r][c] - '1'; // to convert it into int and it ranges from 0-8
                int boxId = (r/3)*3 + (c/3);

                if(row[r][num] || col[c][num] || boxes[boxId][num]) return false;

                row[r][num]   = true;
                col[c][num]   = true;
                boxes[boxId][num] = true;
            }
        }

        return true;
    }
}

// TC: O(n)
// SC: O(1)
