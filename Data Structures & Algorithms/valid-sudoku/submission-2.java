class Solution {
    public boolean isValidSudoku(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;
        
        // row-wise check
        for(int r = 0; r < rows; r++) {
            HashSet<Character> rowSet = new HashSet<>();
            for(int c = 0; c < cols; c++) {
                char current = board[r][c]; 
                if(current != '.' && rowSet.contains(current)) {
                    return false;
                } else if(current != '.') {
                    rowSet.add(current);
                }
            }
            rowSet.clear(); // empty set for next row validity check
        }


        // col-wise check
        for(int c = 0; c < cols; c++) {
            HashSet<Character> colSet = new HashSet<>();
            for(int r = 0; r < rows; r++) {
                char current = board[r][c];
                if(current != '.' && colSet.contains(current)) {
                    return false;
                } else if(current != '.') {
                    colSet.add(current);
                }
            }
            colSet.clear(); // empty it to check next col
        }


        // sub-matrix-wise check
        for(int r= 0; r < rows; r = r + 3) {
            for(int c = 0; c < cols; c = c + 3){
                HashSet<Character> matrixSet = new HashSet<>();
                for(int i = r; i < r + 3; i++) {
                    for(int j = c; j < c + 3; j++) {
                        char current = board[i][j];
                        if(current != '.' && matrixSet.contains(current)) {
                            return false;
                        } else if(current != '.') {
                            matrixSet.add(current);
                        }
                    }
                }
                matrixSet.clear(); // empty it to check next matrix
            }
        }

        return true;
        
    }
}
