import java.util.*;

public class ProblemNo1356 {
    public static void main(String[] args) {

    }

    class Solution {
        public int[] sortByBits(int[] arr) {
            Integer[] temp = Arrays.stream(arr).boxed().toArray(Integer[]::new);

            Arrays.sort(temp, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int count1 = Integer.bitCount(o1);
                    int count2 = Integer.bitCount(o2);

                    if( count1 == count2) return o1 - o2;
                    return Integer.bitCount(o1) - Integer.bitCount(o2);
                }
            });

            return Arrays.stream(temp).mapToInt(Integer::intValue).toArray();
        }
    }

}
