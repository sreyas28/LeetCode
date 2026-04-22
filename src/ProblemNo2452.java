import java.util.*;

public class ProblemNo2452 {
    public static void main(String[] args) {

        ProblemNo2452.Solution p = new ProblemNo2452().new Solution();
        System.out.println(p.twoEditWords(new String[]{"word","note","ants","wood"}, new String[]{"wood","joke","moat"}));

    }

    class Solution {
        private Map<Integer, List<String>> lengthWord;
        private final int MAX_CHANGES = 2;

        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            preProcess(dictionary);

            List<String> res = new ArrayList<>();
            for (String query : queries) {
                if (match(query)) res.add(query);
            }

            return res;
        }

        private void preProcess(String[] dictionary) {
            this.lengthWord = new HashMap<>();

            for (String word : dictionary) {
                lengthWord.computeIfAbsent(word.length(), a -> new ArrayList<>()).add(word);
            }
        }

        private boolean match(String query) {
            List<String> dictionaryWords = lengthWord.getOrDefault(query.length(), new ArrayList<>());

            if (dictionaryWords.isEmpty()) return false;
            else if (dictionaryWords.contains(query)) return true;


            for (String word : dictionaryWords) {
                int changeSoFar = 0;
                for (int i = 0; i < word.length(); i++) {
                    if (query.charAt(i) == word.charAt(i)) continue;
                    else changeSoFar++;

                    if (changeSoFar > MAX_CHANGES) break;
                }

                if (changeSoFar <= MAX_CHANGES) return true;
            }

            return false;
        }

    }

}
