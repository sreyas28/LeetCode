import java.util.*;

public class ProblemNo2913 {
    public static void main(String[] args) {
        int[] x = {1,2,1};
        List<Integer> list = new ArrayList<>();

        for (int i: x) list.add(i);


        Solution a = new ProblemNo2913().new Solution();
        System.out.println(a.sumCounts(list));

    }

    class Solution {
        public int sumCounts(List<Integer> nums) {
            Map<Integer, Integer> map = new HashMap<>();

            int sum = 0;
            for(int i = 0; i < nums.size(); i++) {
                for(int j = i; j < nums.size(); j++) {
                    map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);
                    sum = (int) (sum + Math.pow(map.size(), 2));
                }

                map.clear();
            }

            return sum;
        }
    }

}
