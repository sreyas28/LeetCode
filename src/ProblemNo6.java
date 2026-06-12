import java.util.*;

public class ProblemNo6 {
    public static void main(String[] args) {

    }

    class Solution {
        public String convert(String s, int numRows) {
            if (numRows == 1) return s;

            String[] words = new String[numRows];
            Arrays.fill(words, "");

            int i = 0;
            boolean flag = true;
            for(char c: s.toCharArray()){
                words[i] += c;

                if (i >= numRows-1) flag = false;
                else if (i == 0)  flag = true;

                if(flag) i++;
                else i--;
            }

            StringBuilder newWord = new StringBuilder();
            for(String str: words){
                newWord.append(str);
            }

            return newWord.toString();
        }
    }

}
