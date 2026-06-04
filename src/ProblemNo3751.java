import java.util.*;

public class ProblemNo3751 {
    public static void main(String[] args) {

    }

    class Solution {
        public int totalWaviness(int num1, int num2) {
            int totalWaviness = 0;

            for (int i = num1; i <= num2; i++) {
                totalWaviness += wavyOrNot(i);
            }

            return totalWaviness;
        }

        private int wavyOrNot(int num) {
            if (Integer.toString(num).length() < 3) return 0;

            int waviness = 0;
            List<Integer> list = new ArrayList<>();
            while (num > 0) {
                list.add(num % 10);
                num /= 10;
            }

            for (int i = 1; i < list.size() - 1; i++) {
                if (    list.get(i - 1) < list.get(i) && list.get(i + 1) < list.get(i) ||
                        list.get(i - 1) > list.get(i) && list.get(i + 1) > list.get(i)
                ) waviness++;
            }

            return waviness;
        }

    }

}
