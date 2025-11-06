import java.util.*;

public class ProblemNo3607 {
    public static void main(String[] args) {

        ProblemNo3607.Solution a = new ProblemNo3607().new Solution();
        System.out.println(Arrays.toString(a.processQueries(5, new int[][]{{1,2},{2,3},{3,4},{4,5}},
                new int[][]{{1,3},{2,1},{1,1},{2,2},{1,2}})));

    }

    class Solution {

        class DSU{
            private int[] parent;

            public DSU(int size){
                this.parent = new int[size+1];
                for(int i = 0; i <= size; i++){
                    this.parent[i] = i;
                }
            }

            public int find(int i){
                if(parent[i] == i) return i;

                parent[i] = find(parent[i]);
                return parent[i];
            }

            public void union(int a, int b){
                int parentA = find(a);
                int parentB = find(b);
                if(parentA != parentB) parent[parentB] = parentA;
            }
        }

        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            DSU dsu = new DSU(c);
            for(int[] con: connections){
                dsu.union(con[0], con[1]);
            }

            int[] rootMap = new int[c+1];
            Map<Integer, Set<Integer>> setArray = new HashMap<>();
            for(int i=1; i<=c; i++){
                rootMap[i] = dsu.find(i);
                setArray.computeIfAbsent(rootMap[i], t -> new TreeSet<>()).add(i);
            }

            ArrayList<Integer> result = new ArrayList<>();

            for(int[] query: queries){
                int val = query[1];
                Set<Integer> onlineSets = setArray.get(rootMap[val]);
                if(query[0] == 2) onlineSets.remove(val);
                else{
                    if(onlineSets.contains(val)) result.add(val);
                    else{
                        if(onlineSets.isEmpty()) result.add(-1);
                        else result.add(((TreeSet<Integer>) onlineSets).first());
                    }
                }
            }

            int[] output = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                output[i] = result.get(i);
            }
            return output;
        }
    }


//    class Solution_ {
//        public int[] processQueries(int c, int[][] connections, int[][] queries) {
//            int[] parent = new int[c + 1];
//            for (int i = 1; i <= c; i++) parent[i] = i;
//
//            // Union-Find setup
//            for (int[] conn : connections) {
//                union(conn[0], conn[1], parent);
//            }
//
//            Set<Integer> online = new HashSet<>();
//            for (int i = 1; i <= c; i++) online.add(i);
//
//            List<Integer> result = new ArrayList<>();
//            for (int[] query : queries) {
//                int type = query[0], node = query[1];
//                if (type == 1) {
//                    if (online.contains(node)) {
//                        result.add(node);
//                    } else {
//                        int root = find(node, parent);
//                        boolean found = false;
//                        for (int i = 1; i <= c; i++) {
//                            if (find(i, parent) == root && online.contains(i)) {
//                                result.add(i);
//                                found = true;
//                                break;
//                            }
//                        }
//                        if (!found) result.add(-1);
//                    }
//                } else {
//                    online.remove(node);
//                }
//            }
//
//            return result.stream().mapToInt(Integer::intValue).toArray();
//        }
//
//        private int find(int x, int[] parent) {
//            if (parent[x] != x) parent[x] = find(parent[x], parent);
//            return parent[x];
//        }
//
//        private void union(int x, int y, int[] parent) {
//            int px = find(x, parent), py = find(y, parent);
//            if (px != py) parent[py] = px;
//        }
//    }
//
//    class Solution__ {
//        public int[] processQueries(int c, int[][] connections, int[][] queries) {
//            Map<Integer, Set<Integer>> connectionsMap = new HashMap<>();
//            Set<Integer> Online = new HashSet<>();
//
//            for(int i = 1; i <= c; i++){
//                connectionsMap.put(i, new TreeSet<>());
//                Online.add(i);
//            }
//
//            for(int[] connection: connections){
//                connectionsMap.get(connection[0]).add(connection[1]);
//                connectionsMap.get(connection[1]).add(connection[0]);
//            }
//
//            for(int i=1; i<= c; i++){
//                connectionsMap.get(i).addAll(updator(i, new boolean[c], connectionsMap));
//            }
//
//
//            ArrayList<Integer> result = new ArrayList<>();
//            for(int[] query: queries){
//                if(query[0] == 1){
//                    if(Online.contains(query[1])) result.add(query[1]);
//                    else{
//                        boolean x = false;
//                        for(int con: connectionsMap.get(query[1])){
//                            if(Online.contains(con)) {
//                                result.add(con);
//                                x = true;
//                                break;
//                            }
//                        }
//                        if(!x) result.add(-1);
//                    }
//                }
//
//                else{
//                    Online.remove(query[1]);
//                }
//            }
//            return result.stream().mapToInt(Integer::intValue).toArray();
//        }
//
//        private Set<Integer> updator(int currentNode, boolean[] visited, Map<Integer, Set<Integer>> connectionMap){
//            visited[currentNode-1] = true;
//            Set<Integer> toVisit = connectionMap.get(currentNode);
//
//            Set<Integer> visit = new HashSet<>();
//            visit.add(currentNode);
//
//            for(Integer i: toVisit){
//                if(!visited[i-1]){
//                    visit.add(i);
//                    visit.addAll(updator(i, visited, connectionMap));
//                }
//            }
//
//            return visit;
//        }
//    }

}
