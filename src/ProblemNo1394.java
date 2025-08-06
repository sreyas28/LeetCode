import java.util.HashMap;

public class ProblemNo1394 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findLucky(int[] arr) {
            HashMap<Integer, Integer> map = new HashMap<>();

            int max = -1;

            for(int i: arr) map.put(i, map.getOrDefault(i, 0) + 1);
            for(int key: map.keySet()) if(map.get(key) == key) max = Math.max(max, key);

            return max;
        }
    }

}
