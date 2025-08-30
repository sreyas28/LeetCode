import java.util.ArrayList;
import java.util.HashSet;

public class ProblemNo36 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isValidSudoku(char[][] board) {

            return validatorColRow(board) && validatorBlock(board);
        }

        private boolean validatorColRow(char[][] board){

            ArrayList<HashSet<Character>> setsRow = new ArrayList<>();
            ArrayList<HashSet<Character>> setsCol = new ArrayList<>();

            for(int i=0; i<9; i++){
                setsRow.add(new HashSet<>());
                setsCol.add(new HashSet<>());
            }

            for(int row = 0; row  < 9; row++){
                for (int col = 0; col < 9; col++){
                    char c = board[row][col];
                    if ( c != '.'){
                        if(setsRow.get(col).contains(c) || setsCol.get(row).contains(c)) return false;

                        setsRow.get(col).add(c);
                        setsCol.get(row).add(c);
                    }

                }
            }
            return true;
        }

        private boolean validatorBlock (char[][] board){
            HashSet<Character> sets;

            for (int row_Block = 0; row_Block < 9; row_Block += 3){
                for(int col_Block = 0; col_Block < 9; col_Block += 3){
                    sets = new HashSet<>();

                    for(int row = row_Block; row < row_Block+3; row++){
                        for(int col = col_Block; col < col_Block+3; col++){
                            char c = board[row][col];
                            if(c != '.') {
                                if(sets.contains(c)) return false;
                                sets.add(c);
                            }
                        }
                    }
                }
            }
            return true;
        }

    }

}
