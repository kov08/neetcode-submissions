class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for(int r = 0; r < 9; r++){
            for (int c = 0; c < 9; c++){
                if(board[r][c] == '.') continue;

                int num = board[r][c] - '1'; // convert number into index 0-8 by reducing ASCII value of char from ASCII value of cahr '1' 
                int boxInd = (r/3) * 3 + (c/3); // check the box
                System.out.println(boxInd);

                if(row[r][num] || col[c][num] || boxes[boxInd][num]){
                    return false;
                } 

                row[r][num] = true;
                col[c][num] = true;
                boxes[boxInd][num] = true;
            }
        }

        return true;
    }
}

// TC: O(1) as we have constant number of loops running, irrespective of input size
// SC: O(1) as we use constant space 3 * 9 * 9
