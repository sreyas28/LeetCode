import java.util.ArrayList;
import java.util.List;

public class ProblemNo1415 {
    public static void main(String[] args) {

    }

    class Solution {
        List<String> HappyStrings = new ArrayList<>();

        public String getHappyString(int n, int k) {
            wordGenerator(n, "");

            if(HappyStrings.size() < k) return "";

            return HappyStrings.get(k-1);
        }

        private void wordGenerator(int n, String currentWord){
            if(currentWord.length() >= n){
                HappyStrings.add(currentWord);
                return;
            }

            for(char i = 'a'; i <= 'c'; i++){
                if (!currentWord.isEmpty() && currentWord.charAt(currentWord.length()-1) == i) continue;
                wordGenerator(n, currentWord + i);
            }
        }

    }

}
