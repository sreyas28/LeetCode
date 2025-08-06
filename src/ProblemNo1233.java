import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ProblemNo1233 {

    public static void main(String[] args) {

        ProblemNo1233.Solution a = new ProblemNo1233().new Solution();

        System.out.println(a.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));

    }

    private class Solution {
        public List<String> removeSubfolders(String[] folder) {

            Arrays.sort(folder, (a, b) -> a.length() - b.length());
//            System.out.println(Arrays.toString(folder));

            Trie node = new Trie();
            List<String> res = new ArrayList<>();

             for(String s: folder){
                 if(!node.startsWith(s)){
                     node.insert(s);
                     res.add(s);
                 }
             }

            return res;
        }

        private class TrieNode{
            HashMap<String, TrieNode> children;
            boolean isEndOfPath;

            public TrieNode(){
                children = new HashMap<>();
                isEndOfPath = false;
            }
        }

        private class Trie {
            private final TrieNode root;
            public Trie(){
                root = new TrieNode();
            }

            public void insert(String path){
                TrieNode current = root;
                String[] words =  path.substring(1).split("/");

                for(String s: words) {
                    if(!current.children.containsKey(s)){
                        current.children.put(s, new TrieNode());
                    }
                    current = current.children.get(s);
                }
                current.isEndOfPath = true;
            }

            public boolean startsWith (String path){
                TrieNode current = root;
                String[] words =  path.substring(1).split("/");

                for(String s: words){
                    if(!current.children.containsKey(s)) return false;
                    current = current.children.get(s);
                    if(current.isEndOfPath) return true;
                }
                return true;
            }
        }
    }
}
