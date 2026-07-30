import java.util.Arrays;

public class ProblemNo3016 {

    class Solution_ {
        public int minimumPushes(String word) {

            int[] characters = new int[26];
            for (char c : word.toCharArray()) {
                characters[c - 'a']++;
            }
            Arrays.sort(characters);

            int count = 0;
            for (int i = 0; i < 26; i++) {
                if (characters[25 - i] == 0) break;

                count += characters[25 - i] * (i / 8 + 1);
            }

            return count;
        }
    }

}
