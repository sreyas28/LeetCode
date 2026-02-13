import java.util.HashMap;
import java.util.Map;

public class ProblemNo3714 {
    public static void main(String[] args) {
        ProblemNo3713.Solution p = new ProblemNo3713().new Solution();
        System.out.println(p.longestBalanced("aaa"));
    }

    class Solution {
        public int longestBalanced(String s) {
            return Math.max(Math.max(find1(s), find2(s)), find3(s));
        }

        private int find1(String s) {
            int unoMaxLen = 0;
            int singleLen = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i - 1)) singleLen++;
                else {
                    unoMaxLen = Math.max(unoMaxLen, singleLen);
                    singleLen = 1;
                }
            }
            unoMaxLen = Math.max(unoMaxLen, singleLen);

            return unoMaxLen;
        }

        private int find2(String s) {
            char[][] types = {{'a', 'b'}, {'b', 'c'}, {'a', 'c'}};
            int duoMaxLen = 0;
            for (char[] type : types) {
                int count = 0;
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, -1);

                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != type[0] && s.charAt(i) != type[1]) {
                        count = 0;
                        map = new  HashMap<>();
                    }
                    else if (s.charAt(i) == type[0]) count++;
                    else count--;

                    if (map.containsKey(count)) duoMaxLen = Math.max(duoMaxLen, i - map.get(count));
                    else  map.put(count, i);

                }
            }

            return duoMaxLen;
        }

        private int find3(String s) {
            Map<String, Integer> map = new HashMap<>();
            map.put("0 - 0", -1);
            int trioMaxLen = 0;
            int a = 0, b = 0, c = 0;
            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                switch (cur) {
                    case 'a':
                        a++;
                        break;
                    case 'b':
                        b++;
                        break;
                    case 'c':
                        c++;
                        break;
                }

                String key = (b - a) + " - " + (c - a);

                if (map.containsKey(key)) trioMaxLen = Math.max(trioMaxLen, i - map.get(key));
                else map.put(key, i);
            }
            return trioMaxLen;
        }
    }

}
