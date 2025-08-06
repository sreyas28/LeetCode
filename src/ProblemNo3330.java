import java.util.HashMap;

public class ProblemNo3330 {
    public static void main(String[] args) {


    }

    class Solution {
        public int possibleStringCount(String word) {
            int count = 1;

            for(int i = 1; i < word.length(); i++){
                if(word.charAt(i-1) == word.charAt(i)) count++;
            }

            return count;
        }
    }

}
