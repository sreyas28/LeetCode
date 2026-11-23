import java.util.*;

public class ProblemNo1352 {
    public static void main(String[] args) {

    }

    class ProductOfNumbers {
        List<Long> list;

        public ProductOfNumbers() {
            this.list = new ArrayList<>();
            list.add(1L);
        }

        public void add(int num) {
            if (num == 0) {
                list.clear();
                list.add(1L);
            } else list.add(list.getLast() * num);
        }

        public int getProduct(int k) {
            int n = list.size();

            if (n - k - 1 < 0) return 0;
            long product = list.getLast() / list.get(n - k - 1);

            return (int) product;
        }
    }

}
