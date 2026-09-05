//not understand properly 

import java.util.*;

public class ProblemNo1948 {
    public static void main(String[] args) {

        ProblemNo1948.Solution a = new ProblemNo1948().new Solution();

        List<List<String>> paths = new ArrayList<>();
//        String[][] pat = {{"a"}, {"c"}, {"d"}, {"a", "b"}, {"c", "b"}, {"d", "a"}};
        String[][] pat = {{"y"}, {"y", "b"}, {"y", "b", "a"}, {"y", "d"}, {"y", "d", "c"}, {"z"}, {"z", "d"}, {"z", "d", "c"}, {"z", "d", "c", "b"}, {"z", "d", "c", "b", "a"}};
//        String[][] pat = {{"f","r","g"},{"f","o","x","t"},{"f","o","x","d"},{"f","o","l"},{"l","q"},{"h","t"},{"h","o","d"},{"h","o","t"}};
        for (String[] p : pat) paths.add(new ArrayList<>(List.of(p)));

        System.out.println(a.deleteDuplicateFolder(paths));
    }


    class Solution {
        private class TrieNode {
            String serial;
            Map<String, TrieNode> children;

            TrieNode(String serial) {
                this.serial = serial;
                this.children = new TreeMap<>();
            }
        }

        private Map<String, List<TrieNode>> matchedSubFolder;

        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            TrieNode root = new TrieNode("");
            matchedSubFolder = new HashMap<>();

            for (List<String> path : paths) {
                TrieNode node = root;
                for (String str : path) {
                    node = node.children.computeIfAbsent(str, k -> new TrieNode(str));
                }
            }

            inorderTraversal(root);
            for (String key : matchedSubFolder.keySet()) {
                if (matchedSubFolder.get(key).size() <= 1) continue;
                String[] toRemove = key.split(",");

                boolean removeParent = true;
                for (TrieNode node : matchedSubFolder.get(key)) {

                    for (String str : toRemove) node.children.remove(str);
                    if (!node.children.isEmpty()) removeParent = false;
                }
                if (removeParent) {
                    for (TrieNode node : matchedSubFolder.get(key)) node.serial = null;
                }
            }

            List<List<String>> res = new ArrayList<>();
            for (TrieNode child : root.children.values()) {
                if (child.serial == null) continue;
                construct(child, res, new ArrayList<>());
            }
            return res;
        }

        private String inorderTraversal(TrieNode node) {
            StringBuilder sb = new StringBuilder();

            if (node.children.size() > 1) {
                for (String str : node.children.keySet()) {
                    String path = inorderTraversal(node.children.get(str));
                    //matchedSubFolder.computeIfAbsent(path, x -> new ArrayList<>()).add(node);
                    sb.append(path).append(",");
                }
            }
            else if (node.children.size() == 1) sb.append(inorderTraversal(node.children.values().iterator().next()));


            if (!sb.isEmpty()) matchedSubFolder.computeIfAbsent(sb.toString(), x -> new ArrayList<>()).add(node);
            sb.append(node.serial).append(",");
            return sb.toString();
        }

        private void construct(TrieNode node, List<List<String>> paths, List<String> currentPath) {
            currentPath.add(node.serial);
            paths.add(currentPath);

            for (TrieNode child : node.children.values()) {
                if (child.serial == null) continue;
                construct(child, paths, new ArrayList<>(currentPath));
            }
        }

        private void printer(TrieNode node) {
            if (node.children.isEmpty()) {
                System.out.print(node.serial + ", ");
                return;
            }

            System.out.print("{ " + node.serial + " ->{");
            for (String key : node.children.keySet()) {
                printer(node.children.get(key));
            }
            System.out.print("}, ");
        }
    }

    class Solution_ {

        class Trie {
            String serial; // current node structure's serialized representation
            Map<String, Trie> children = new HashMap<>(); // current node's child nodes
        }

        public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
            Trie root = new Trie(); // root node

            // build a trie tree
            for (List<String> path : paths) {
                Trie cur = root;
                for (String node : path) {
                    cur.children.putIfAbsent(node, new Trie());
                    cur = cur.children.get(node);
                }
            }

            Map<String, Integer> freq = new HashMap<>(); // hash table records the occurrence times of each serialized representation
            // post-order traversal based on depth-first search, calculate the serialized representation of each node structure
            construct(root, freq);
            List<List<String>> ans = new ArrayList<>();
            List<String> path = new ArrayList<>();
            // operate the trie, delete duplicate folders
            operate(root, freq, path, ans);
            return ans;
        }

        private void construct(Trie node, Map<String, Integer> freq) {
            if (node.children.isEmpty()) return; // if it is a leaf node, no operation is needed.

            List<String> v = new ArrayList<>();
            for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
                construct(entry.getValue(), freq);
                v.add(entry.getKey() + "(" + entry.getValue().serial + ")");
            }

            Collections.sort(v);
            StringBuilder sb = new StringBuilder();
            for (String s : v) {
                sb.append(s);
            }
            node.serial = sb.toString();
            freq.put(node.serial, freq.getOrDefault(node.serial, 0) + 1);
        }

        private void operate(
                Trie node,
                Map<String, Integer> freq,
                List<String> path,
                List<List<String>> ans
        ) {
            if (freq.getOrDefault(node.serial, 0) > 1)
                return; // if the serialization representation appears more than once, it needs to be deleted

            if (!path.isEmpty()) {
                ans.add(new ArrayList<>(path));
            }

            for (Map.Entry<String, Trie> entry : node.children.entrySet()) {
                path.add(entry.getKey());
                operate(entry.getValue(), freq, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }

}
