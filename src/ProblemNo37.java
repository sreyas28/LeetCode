import java.util.Arrays;
import java.util.HashSet;

public class ProblemNo37 {
    public static void main(String[] args) {
        ProblemNo37.Solution a = new ProblemNo37().new Solution();

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        a.solveSudoku(board);

        System.out.println(Arrays.deepToString(board));

    }

    class Solution {

        private boolean[][] rowUsed = new boolean[9][9];
        private boolean[][] colUsed = new boolean[9][9];
        private boolean[][] blockUsed = new boolean[9][9];


        public void solveSudoku(char[][] board) {

            for(int i=0; i < 9; i++){
                for(int j=0; j < 9; j++){
                    if(board[i][j] != '.'){
                        int num = board[i][j] - '1';
                        rowUsed[i][num] = true;
                        colUsed[j][num] = true;
                        blockUsed[(i/3)*3 + (j/3)][num] = true;
                    }
                }
            }
            Solver(board, 0, 0);
        }

        private boolean Solver(char[][] board, int i, int j){
            if(i == 9) return true;

            int next_i = (j==8) ? i+1 : i;
            int next_j = (j+1) % 9 ;

            if(board[i][j] != '.') return Solver(board, next_i, next_j);

            for(int val = 0; val < 9; val++){
                int block = (i/3)*3 + (j/3);
                if(!rowUsed[i][val] && !colUsed[j][val] && !blockUsed[block][val]){
                    board[i][j] = (char)(val + '1');
                    rowUsed[i][val] = colUsed[j][val] = blockUsed[block][val] = true;

                    if(Solver(board, next_i, next_j)) return true;

                    board[i][j] = '.';
                    rowUsed[i][val] = colUsed[j][val] = blockUsed[block][val] = false;
                }
            }

            return false;
        }
    }

}
