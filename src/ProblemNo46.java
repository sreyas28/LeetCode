import java.util.*;

public class ProblemNo46 {
    public static void main(String[] args) {

        Solution a = new ProblemNo46().new Solution();
        System.out.println(a.permute(new int[] {1,2,3}));

    }

    class Solution {
        private List<List<Integer>> result;

        public List<List<Integer>> permute(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i : nums) set.add(i);

            this.result = new ArrayList<>();
            generate(set, new ArrayList<>());

            return result;
        }

        private void generate(Set<Integer> set, List<Integer> combination) {
            if (set.isEmpty()) {
                result.add(new ArrayList<>(combination));
                return;
            }

            for (int s : set) {
                Set<Integer> newSet = new HashSet<>(set);
                newSet.remove(s);
                combination.add(s);

                generate(newSet, combination);
                combination.removeLast();
            }
        }
    }

}
