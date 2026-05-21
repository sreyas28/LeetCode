import java.util.*;

public class ProblemNo3034 {

    public static void main(String[] args) {

        Solution a = new ProblemNo3034().new Solution();
        System.out.println(a.longestCommonPrefix(new int[]{34}, new int[]{39}));
    }

    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            Set<String> arr2Prefixes = getPrefixMap(arr2);

            int len = 0;
            for (int val : arr1) {
                String v = String.valueOf(val);
                for (int i = 1; i <= v.length(); i++) {
                    if (arr2Prefixes.contains(v.substring(0, i))) len = Math.max(len, i);
                }
            }

            return len;
        }

        private Set<String> getPrefixMap(int[] arr) {
            Set<String> arrPrefixes = new HashSet<>();

            for (int val : arr) {
                String v = String.valueOf(val);
                for (int i = 0; i < v.length(); i++) arrPrefixes.add(v.substring(0, i+1));
            }

            return arrPrefixes;
        }

    }

}
