import java.util.*;

public class ProblemNo1625 {
    public static void main(String[] args) {

        ProblemNo1625.Solution a = new ProblemNo1625().new Solution();
        System.out.println(a.findLexSmallestString("5525", 9, 2));

    }

    class Solution {

        private Set<String> visited = new HashSet<>();

        public String findLexSmallestString(String s, int a, int b) {
            DFS(s, a, b);
            ArrayList<String> sorted = new ArrayList<>(visited);
            Collections.sort(sorted);
            return sorted.getFirst();
        }

        private void DFS(String s, int addition, int rotate){
            if(visited.contains(s)) return; // if already visited

            visited.add(s); // mark it as visited
            DFS(rotate(s,rotate), addition, rotate);
            DFS(add(s, addition), addition, rotate);
        }

        private String rotate(String s, int times){
            int start = s.length() - times, i = start;
            StringBuilder result = new StringBuilder();
            do{
                result.append(s.charAt(i % s.length()));
                i = (i+1) % s.length();
            }while(i != start);

            return result.toString();
        }

        private String add(String s, int add){
            StringBuilder result = new StringBuilder();
            for(int i = 0; i<s.length(); i++){
                char digit = s.charAt(i);

                if(i%2 != 0) result.append( ( (digit - '0') + add)  % 10);
                else result.append(digit);
            }

            return result.toString();
        }

    }

}
