import java.util.HashSet;
import java.util.Set;

public class ProblemNo2166 {
    public static void main(String[] args) {

        Bitset a = new ProblemNo2166().new Bitset(5);

        a.fix(3);
        System.out.println(a.toString());
        a.unfix(3);
        System.out.println(a.toString());
        a.flip();
        System.out.println(a.toString());

    }

    class Bitset {
        private Set<Integer> ones = new HashSet<>();
        private Set<Integer> zeroes = new HashSet<>();

        private final int size;

        public Bitset(int size) {
            this.size = size;
            for (int i = 0; i < size; i++) zeroes.add(i);
        }

        public void fix(int idx) {
            ones.add(idx);
            zeroes.remove(idx);
        }

        public void unfix(int idx) {
            ones.remove(idx);
            zeroes.remove(idx);
        }

        public void flip() {
            Set<Integer> tmp = zeroes;
            zeroes = ones;
            ones = tmp;
        }

        public boolean all() {
            return !zeroes.isEmpty();
        }

        public boolean one() {
            return !ones.isEmpty();
        }

        public int count() {
            return ones.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < size; i++) {
                if (ones.contains(i)) sb.append('1');
                else sb.append('0');
            }

            return sb.toString();
        }
    }

    // only good for 32 or max 64 but not 10^5
    class Bitset_ {
        private int value;
        private final int max;
        private final int size;

        public Bitset_(int size) {
            this.size = size;
            this.max = (1 << size) - 1;
        }

        public void fix(int idx) {
            int index = size - idx - 1;
            int temp = 1 << index;

            value |= temp;
        }

        public void unfix(int idx) {
            int mask = (1 << size) - 1;

            int index = size - idx - 1;
            int temp = 1 << index;

            mask ^= temp;

            value &= mask;
        }

        public void flip() {
            int mask = (1 << size) - 1;
            value = ~value & mask;
        }

        public boolean all() {
            return value == max;
        }

        public boolean one() {
            return value >= 1;
        }

        public int count() {
            return Integer.bitCount(value);
        }

        public String toString() {
            String s = Integer.toBinaryString(value);

            int addZero = size - s.length();
            StringBuilder sb = new StringBuilder();

            sb.repeat('0', addZero);
            sb.append(s);


            return sb.toString();
        }
    }

}
