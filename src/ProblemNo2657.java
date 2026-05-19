import java.util.HashSet;
import java.util.Set;

public class ProblemNo2657 {
    public static void main(String[] args) {

    }


    class Solution {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            final int N = A.length;
            int[] res = new int[N];

            int[] freq = new int[N+1];
            int count = 0;
            for (int i = 0; i < N; i++) {
                freq[A[i]]++;
                if (freq[A[i]] == 2) count++;

                freq[B[i]]++;
                if (freq[B[i]] == 2) count++;

                res[i] = count;
            }

            return res;
        }
    }

    // bit un-optimized
    class Solution_ {
        public int[] findThePrefixCommonArray(int[] A, int[] B) {
            final int N = A.length;
            int[] res = new int[N];

            Set<Integer> setA = new HashSet<>();
            Set<Integer> setB = new HashSet<>();

            for (int i = 0; i < N; i++) {
                setA.add(A[i]);
                setB.add(B[i]);

                Set <Integer> temp = new HashSet<>(setA);
                temp.retainAll(setB);
                res[i] = temp.size();
            }

            return res;
        }
    }

}
