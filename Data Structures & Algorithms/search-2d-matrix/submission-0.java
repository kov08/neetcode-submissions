class Solution {
    // public boolean searchMatrix(int[][] matrix, int target) {
    //     int row = matrix.length, col = matrix[0].length;

    //     for(int i = 0; i < row; i++){
    //         for(int j = 0; j < col; j++){
    //             if(matrix[i][j] == target)
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    // TC: O(m * n)

    public boolean searchMatrix(int[][] matrix, int target) { 
        int row = matrix.length, col = matrix[0].length;
        int l = 0 , r = row * col - 1;

        while(l <= r){
            int mid = (l + r)/2;
            int rw = mid / col;
            int cl = mid % col;

            if(matrix[rw][cl] == target){
                return true;
            } else if( matrix[rw][cl] < target ){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return false;
    }
    

}
