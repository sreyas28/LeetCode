import java.util.Arrays;

public class ProblemNo744 {
    public static void main(String[] args) {

    }

    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            for(char c : letters){
                if(c > target){
                    return c
                }
            }

            return letters[0];
        }
    }

}
