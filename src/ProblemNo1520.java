import java.util.*;

public class ProblemNo1520 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1520().new Solution();
        System.out.println(a.maxNumOfSubstrings("adefaddaccc"));

    }

    class Solution {
        private static class Segment implements Comparable<Segment> {
            int start, end;

            Segment(int start, int end) {
                this.start = start;
                this.end = end;
            }

            public int compareTo(Segment s) {
                if (this.end == s.end) return s.start - this.start;
                else return s.end - this.end;
            }

        }

        public List<String> maxNumOfSubstrings(String s) {
            Segment[] segment = new Segment[26];

            for (int i = 0; i < 26; i++) segment[i] = new Segment(-1, -1);


            for (int i = 0; i < s.length(); i++) {
                int c = s.charAt(i) - 'a';

                if (segment[c].start == -1) segment[c].start = i;
                segment[c].end = i;
            }


            for (int i = 0; i < 26; i++) {

                if (segment[i].start != -1) {
                    for (int j = segment[i].start + 1; j <= segment[i].end - 1; j++) {
                        int c = s.charAt(j) - 'a';

                        if (segment[i].start <= segment[c].start &&
                                segment[c].end <= segment[i].end) continue;

                        segment[i].start = Math.min(segment[i].start, segment[c].start);
                        segment[i].end = Math.max(segment[i].end, segment[c].end);

                        j = segment[i].start;
                    }
                }
            }

            Arrays.sort(segment);

            List<String> res = new ArrayList<>();
            int end = -1;
            for (int i = 25; i >= 0; i--) {
                if (segment[i].start == -1) continue;

                if (end == -1 || segment[i].start > end) {
                    end = segment[i].end;
                    res.add(s.substring(segment[i].start, end + 1));
                }
            }

            return res;
        }
    }

}
