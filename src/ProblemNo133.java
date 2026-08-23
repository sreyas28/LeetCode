import java.util.*;

public class ProblemNo133 {

    public class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String[] args) {

        ProblemNo133 p = new ProblemNo133();

        Node _1 = p.new Node(1);
        Node _2 = p.new Node(2);
        Node _3 = p.new Node(3);
        Node _4 = p.new Node(4);

        _1.neighbors.add(_2);
        _1.neighbors.add(_4);

        _2.neighbors.add(_1);
        _2.neighbors.add(_3);

        _3.neighbors.add(_2);
        _3.neighbors.add(_4);

        _4.neighbors.add(_1);
        _4.neighbors.add(_3);

        ProblemNo133.Solution obj = new ProblemNo133().new Solution();
        System.out.println(obj.cloneGraph(_1));
    }

    class Solution {
        public Node cloneGraph(Node node) {
            Map<Integer, List<Integer>> adjMap = adjMaker(node);
//            System.out.println(adjMap);

            Node[] nodes = new Node[adjMap.size() + 1];

            for (int key : adjMap.keySet()) nodes[key] = new Node(key);

            for (int key : adjMap.keySet()) {
                for (int n : adjMap.get(key)) {
                    nodes[key].neighbors.add(nodes[n]);
                }
            }

            return nodes[node.val];
        }

        private Map<Integer, List<Integer>> adjMaker(Node node) {
            if (node == null) return new HashMap<>();
            Map<Integer, List<Integer>> adjMap = new HashMap<>();

            Set<Node> visited = new HashSet<>();
            Stack<Node> stack = new Stack<>();
            stack.push(node);

            while (!stack.isEmpty()) {
                Node temp = stack.pop();
                if (!visited.contains(temp)) {
                    adjMap.computeIfAbsent(temp.val, a -> new ArrayList<>());

                    for (Node neighbor : temp.neighbors) {
                        adjMap.get(temp.val).add(neighbor.val);
                        stack.push(neighbor);
                    }
                }

                visited.add(temp);
            }

            return adjMap;
        }
    }

}
