import java.util.*;

public class ProblemNo2975 {
    public static void main(String[] args) {

    }

    class Solution {
        public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
            Arrays.sort(hFences);
            Arrays.sort(vFences);

            Set<Integer> setH = findRange(m, hFences);
            Set<Integer> setV = findRange(n, vFences);

            Set<Integer> intersection = new HashSet<>(setH);

            intersection.retainAll(setV);

            long ans = -1;
            for (int i : intersection) {
                ans = (long) Math.max(ans, (long) i * i);
            }

            return (int) (ans % 1000000007);
        }

        private Set<Integer> findRange(int x, int[] fences) {
            List<Integer> list = new ArrayList<>();

            list.add(1);
            for (int i : fences) list.add(i);
            list.add(x);

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < list.size(); i++) {
                int fenceA = list.get(i);
                for (int j = i + 1; j < list.size(); j++) {
                    set.add(list.get(j) - fenceA);
                }
            }

            return set;
        }
    }

}
