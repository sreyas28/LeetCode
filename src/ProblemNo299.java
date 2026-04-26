import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ProblemNo299 {
    public static void main(String[] args) {

        ProblemNo299.Solution p = new ProblemNo299().new Solution();
        System.out.println(p.getHint("1123", "0111"));

    }

    class Solution {
        public String getHint(String secret, String guess) {
            int A = 0;
            int B = 0;

            Map<Character, Integer> guessFreq = new HashMap<>();
            Set<Integer> indies = new HashSet<>();
            for (int i = 0; i < secret.length(); i++) {
                if (secret.charAt(i) == guess.charAt(i)) {
                    indies.add(i);
                    A++;
                }
                else guessFreq.put(guess.charAt(i), guessFreq.getOrDefault(guess.charAt(i), 0) + 1);
            }

            for (int i = 0; i < secret.length(); i++) {
                if (indies.contains(i)) continue;

                char current = secret.charAt(i);

                if (guessFreq.containsKey(current)) {
                    B++;
                    guessFreq.put(current, guessFreq.get(current) - 1);
                    if (guessFreq.get(current) == 0) guessFreq.remove(current);
                }
            }


            return A + "A" + B + "B";
        }
    }

}
