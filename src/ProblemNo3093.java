import java.util.*;

public class ProblemNo3093 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3093().new Solution();
        System.out.println(Arrays.toString(a.stringIndices(new String[]{"abcd", "bcd", "xbcd"}, new String[]{"cd", "bcd", "xyz"})));

    }

    class TrieNode {
        Map<Character, TrieNode> children;
        Integer bestIndex;

        public TrieNode(int bestIndex) {
            children = new HashMap<>();
            this.bestIndex = bestIndex;
        }
    }

    class Trie {
        final TrieNode root;
        String[] wordContainer;

        public Trie(String[] wordContainer, int globalBestIndex) {
            root = new TrieNode(globalBestIndex);
            this.wordContainer = wordContainer;
        }

        public void insert(String reversed, int index) {
            TrieNode node = root;

            node.bestIndex = better(node.bestIndex,  index);
            for (char c : reversed.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode(index));
                node = node.children.get(c);
                node.bestIndex = better(node.bestIndex, index);
            }
        }

        private int better(int a,  int b) {
            int lenA =  wordContainer[a].length();
            int lenB = wordContainer[b].length();

            if (lenA != lenB)  return lenA < lenB ? a : b;
            return Math.min(a, b);
        }

        public int searchPrefix(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!node.children.containsKey(c)) return node.bestIndex;
                node = node.children.get(c);
            }
            return node.bestIndex;
        }

    }

    class Solution {
        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            int globalBest = 0;
            for (int i = 1; i < wordsContainer.length; i++) {
                if (wordsContainer[i].length() < wordsContainer[globalBest].length()) {
                    globalBest = i;
                }
            }

            Trie trie = new Trie(wordsContainer, globalBest);

            for (int i = 0; i < wordsContainer.length; i++) {
                trie.insert(reverse(wordsContainer[i]), i);
            }

            final int M = wordsQuery.length;
            int[] res = new int[M];

            for(int  i = 0; i < M; i++){
                res[i] = trie.searchPrefix(reverse(wordsQuery[i]));
            }
            return res;
        }


        private String reverse(String word) {
            StringBuilder sb = new StringBuilder(word);
            return sb.reverse().toString();
        }
    }

}
