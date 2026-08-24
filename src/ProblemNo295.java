import java.util.*;

public class ProblemNo295 {

    public static void main(String[] args) {

    }

    class MedianFinder {
        List<Integer> list;

        public MedianFinder() {
            list = new ArrayList<>();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            list.sort((a, b) -> a - b);

            double median = 0;
            if (list.size() % 2 == 0) {
                int index = list.size() / 2;
                median = (double) (list.get(index) + list.get(index - 1)) / 2;
            } else {
                int index = list.size() / 2;
                median = list.get(index);
            }

            return median;
        }
    }
}
