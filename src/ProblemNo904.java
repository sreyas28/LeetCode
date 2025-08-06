import java.util.*;

public class ProblemNo904 {
    public static void main(String[] args) {
        ProblemNo904.Solution a = new ProblemNo904().new Solution();

        System.out.println(a.totalFruit(new int[] {1,0,1,4,1,4,1,2,3}));
    }

    class Solution {
        public int totalFruit(int[] fruits) {
            int max = 0, tempMax = 0;
            Map<Integer, Integer> map = new HashMap<>();

            int left = 0, right = 0;
            while(right < fruits.length){
                map.put(fruits[right], map.getOrDefault(fruits[right],0) + 1);

                while(map.size() > 2){
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    if(map.get(fruits[left]) == 0) map.remove(fruits[left]);
                    tempMax--;
                    left++;
                }

                tempMax++;
                right++;
                max = Math.max(max, tempMax);
            }

            return max;
        }
    }

}
