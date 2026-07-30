import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ProblemNo3014 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3014().new Solution();
        System.out.println(a.minimumPushes("abcde"));

    }

    class Solution {
        public int minimumPushes(String word) {
            final int N =  word.length();
            int rem = N % 8;
            int group = N / 8;

            return 8 * group * (group + 1) / 2 + (group + 1) * rem;
        }
    }


    // all letter are distinct so this is just over done
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
