import java.util.*;

public class ProblemNo1331 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] arrayRankTransform(int[] arr) {
            TreeSet<Integer> set = new TreeSet<>();
            for (int i : arr) set.add(i);

            Map<Integer, Integer> map = new HashMap<>();
            int rank = 1;
            for (int i : set) {
                map.put(i, rank++);
            }

            for (int i = 0; i < arr.length; i++) {
                arr[i] = map.get(arr[i]);
            }

            return arr;
        }
    }

}
