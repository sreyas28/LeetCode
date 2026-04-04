import java.util.Arrays;

public class ProblemNo2075 {
    public static void main(String[] args) {

        ProblemNo2075.Solution p = new ProblemNo2075().new Solution();
        System.out.println(p.decodeCiphertext("iveo    eed   l te   olc", 4));

    }

    class Solution {
        public String decodeCiphertext(String encodedText, int rows) {
            if (encodedText == null || encodedText.isEmpty()) return "";
            if(rows == 1) return encodedText;

            int cols = encodedText.length() / rows;
            char[][] grid = new char[rows][cols];
            char[] characters = encodedText.toCharArray();

            int e = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = characters[e++];
                }
            }

            StringBuilder sb = new StringBuilder();

            for(int col = 0; col < cols; col++){
                for (int r = 0, c = col; r < rows && c < cols; r++, c++){
                    sb.append(grid[r][c]);
                }
            }

            while(sb.charAt(sb.length() - 1) == ' ') sb.deleteCharAt(sb.length() - 1);

            return sb.toString();
        }
    }

}
