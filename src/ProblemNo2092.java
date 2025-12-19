import java.util.*;

public class ProblemNo2092 {
    public static void main(String[] args) {

        ProblemNo2092.Solution a = new ProblemNo2092().new Solution();
        System.out.println(a.findAllPeople(6, new int[][]{{1,2,5},{2,3,8},{1,5,10}}, 1));
        System.out.println(a.findAllPeople(4, new int[][]{{3,1,3},{1,2,2},{0,3,3}}, 3));

    }

    class Solution {
        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            Arrays.sort(meetings, (a,b) -> a[2]-b[2]);
//            System.out.println(Arrays.deepToString(meetings));

            boolean[] globalVisited = new boolean[n];
            globalVisited[0] = true;
            globalVisited[firstPerson] = true;

            int i = 0;
            while(i < meetings.length){
                int time = meetings[i][2];

                Map<Integer, List<Integer>> mapping = new HashMap<>();
                while(i < meetings.length && meetings[i][2] == time){
                    mapping.computeIfAbsent(meetings[i][0], a -> new ArrayList<>()).add(meetings[i][1]);
                    mapping.computeIfAbsent(meetings[i][1], a -> new ArrayList<>()).add(meetings[i][0]);
                    i++;
                }

                boolean[] currentVisited = globalVisited.clone();
                Queue<Integer> queue = new LinkedList<>(mapping.keySet());

                while(!queue.isEmpty()){
                    int key = queue.poll();
                    if(currentVisited[key]){
                        for(int vals: mapping.get(key)){
                            if(!currentVisited[vals]){
                                queue.add(vals);
                                currentVisited[vals] = true;
                            }
                        }
                    }
                }

                globalVisited = currentVisited;
            }

            System.out.println(Arrays.toString(globalVisited));

            List<Integer> result = new ArrayList<>();
            for(int index=0; index<n; index++){
                if(globalVisited[index]) result.add(index);
            }

            return result;
        }
    }

}
