public class ProblemNo1861 {
    public static void main(String[] args) {

    }

    class Solution {
        public char[][] rotateTheBox(char[][] boxGrid) {
            int rows  = boxGrid.length;
            int cols  = boxGrid[0].length;


            for(int row = 0; row < rows; row++){
                char[] currentRow = boxGrid[row];

                int a = cols - 1, b = cols - 1;

                while(a >= 0){
                    char curr =  currentRow[a];

                    if (curr == '*') {
                        a--;
                        b = a;
                    }
                    else if ( curr == '.') {
                        a--;
                    }
                    else {
                        currentRow[a] = currentRow[b];
                        currentRow[b] = curr;
                        a--;
                        b--;
                    }
                }
            }


            // rotating it
            char[][] rotate = new char[cols][rows];
            for  (int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    rotate[j][rows - i - 1] = boxGrid[i][j];
                }
            }

            return rotate;
        }
    }

}
