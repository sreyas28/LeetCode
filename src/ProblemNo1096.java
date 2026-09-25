import java.util.*;

public class ProblemNo1096 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1096().new Solution();
        System.out.println(a.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
        System.out.println(a.braceExpansionII("a{b,c}{d,e}f{g,h}"));
        System.out.println(a.braceExpansionII("{{a,b},{b,c}}"));

    }

    class Solution {

        class Node {
            int index;
            Set<String> parts;

            public Node(int index, Set<String> parts) {
                this.index = index;
                this.parts = parts;
            }

        }

        public List<String> braceExpansionII(String expression) {
            List<String> res = new ArrayList<>(dfs(0, expression).parts);
            res.sort(String::compareTo);

            return res;
        }

        private Node dfs(int i, String expression) {
            Set<String> parts = new HashSet<>();
            List<String> curr = new ArrayList<>();

            StringBuilder runningVal = new StringBuilder();
            while (i < expression.length() && expression.charAt(i) != '}') {
                char c = expression.charAt(i);

                if(Character.isAlphabetic(c)) runningVal.append(c);

                else {
                    if (!runningVal.isEmpty()) {
                        if (curr.isEmpty()) curr.add(runningVal.toString());
                        else curr = union(curr, runningVal.toString());

                        runningVal = new StringBuilder();
                    }

                    if (c == '{') {
                        Node temp = dfs(i + 1, expression);
                        if (curr.isEmpty()) curr.addAll(temp.parts);
                        else curr = union(curr, temp.parts);

                        i = temp.index;
                    }
                    else if (c == ',') {
                        parts.addAll(curr);
                        curr = new ArrayList<>();
                    }
                }

                i++;
            }
            if (!runningVal.isEmpty()) {
                if (curr.isEmpty()) curr.add(runningVal.toString());
                else curr = union(curr, runningVal.toString());

                runningVal = new StringBuilder();
            }

            parts.addAll(curr);

            return new Node(i, parts);
        }

        private List<String> union(List<String> A, Set<String> B) {
            List<String> union = new ArrayList<>();

            for (String a : A) {
                for (String b : B) {
                    union.add(a + b);
                }
            }

            return union;
        }

        private List<String> union(List<String> A, String B) {
            List<String> union = new ArrayList<>();
            for (String a : A) {
                union.add(a + B);
            }

            return union;
        }

    }

}
