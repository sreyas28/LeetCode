import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProblemNo1935 {
    public static void main(String[] args) {

        ProblemNo1935.Solution a = new ProblemNo1935().new Solution();
        System.out.println(a.canBeTypedWords("hello world", "ad"));

    }

    class Solution {
        public int canBeTypedWords(String text, String brokenLetters) {
            int count = 0;

            for(String s: text.split(" ")){
                boolean canWritten = true;
                for(char c: brokenLetters.toCharArray()){
                    if(s.contains(c+"")) {
                        canWritten = false;
                        break;
                    }
                }

                if(canWritten) count++;
            }

            return count;
        }
    }

}
