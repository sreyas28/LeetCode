import java.util.*;

public class ProblemNo3488 {
    public static void main(String[] args) {

        ProblemNo3488.Solution p = new ProblemNo3488().new Solution();
        System.out.println(p.solveQueries(new int[]{1,3,1,4,1,3,2}, new int[]{5}));

    }

    class Solution {
        public List<Integer> solveQueries(int[] nums, int[] queries) {
            int n = nums.length;
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            }
            for (ArrayList<Integer> pos : map.values()) {
                int x = pos.getFirst();
                int last = pos.getLast();
                pos.addFirst(last - n);
                pos.add(x + n);
            }

            List<Integer> ans = new ArrayList<>();
            for (int query : queries) {
                int number = nums[query];

                List<Integer> list = map.get(number);
                if (list.size() == 3) {
                    ans.add(-1);
                    continue;
                }

                int idx = Collections.binarySearch(list, query);
                if (idx < 0) idx = -idx - 1;

                int dist = Math.min(
                        list.get(idx + 1) - list.get(idx),
                        list.get(idx) - list.get(idx - 1)
                );
                ans.add(dist);
            }

            return ans;
        }
    }

}
