import java.util.*;

public class ProblemNo39 {
    public static void main(String[] args) {
        Solution s = new ProblemNo39().new Solution();
        System.out.println(s.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    class Solution {
        private List<List<Integer>> result;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.result = new ArrayList<>();
            Arrays.sort(candidates);

            generator(new ArrayList<>(), target, 0, candidates);
            return result;
        }

        private void generator(List<Integer> combination, int target, int sum, int[] candidates) {
            for (int i : candidates) {
                int tempSum = sum + i;
                combination.add(i);
                if (tempSum == target) {
                    List<Integer> newCombination = new ArrayList<>(combination);
                    newCombination.sort(Comparator.naturalOrder());

                    if (!result.contains(newCombination)) result.add(newCombination);
                } else if (tempSum < target) generator(new ArrayList<>(combination), target, tempSum, candidates);
                else break;
                combination.removeLast();
            }
        }
    }

}
