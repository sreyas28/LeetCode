import java.util.*;

public class ProblemNo3161 {
    public static void main(String[] args) {

        Solution a = new ProblemNo3161().new Solution();
        System.out.println(a.getResults(new int[][] {{1,1},{1,11},{1,4},{1,8},{2,13,7}}));

    }


    // Finwick Tree
    class Solution {

        private int[] bt;

        private void update(int idx, int val){
            for(; idx < bt.length; idx += (idx & -idx)) bt[idx] = Math.max(bt[idx], val);
        }

        private int query(int idx){
            int res = 0;
            for(; idx > 0; idx -= (idx & -idx)) res = Math.max(bt[idx], res);
            return res;
        }

        public List<Boolean> getResults(int[][] queries) {
            final int MAX = 50000;

            bt = new int[MAX + 1];
            TreeSet<Integer> blocks = new TreeSet<>();
            blocks.add(0);
            blocks.add(MAX);

            for(int[] query : queries){
                if (query[0] == 1) blocks.add(query[1]);
            }

            int prev = 0;
            for(int i: blocks){
                if (i == 0) continue;
                update(i, i - prev);
                prev = i;
            }

            List<Boolean> res = new ArrayList<>();

            for(int i = queries.length - 1; i >= 0; i--){
                int[] qry = queries[i];

                if (qry[0] == 2) {
                    int x =  qry[1];
                    int sz = qry[2];

                    int prevVal = Optional.ofNullable(blocks.floor(x)).orElse(0);
                    int maxRange = Math.max(query(prevVal), x - prevVal);

                    res.add(maxRange >= sz);
                }

                else { // for qry[0] == 1
                    int x =  qry[1];

                    int prevVal = Optional.ofNullable(blocks.lower(x)).orElse(0);
                    int nextVal = Optional.ofNullable(blocks.higher(x)).orElse(MAX);

                    update(nextVal, nextVal - prevVal);
                    blocks.remove(x);
                }
            }

            Collections.reverse(res);
            return res;
        }
    }




    // TLE
    class Solution__ {
        public List<Boolean> getResults(int[][] queries) {
            List<Integer> idx = new ArrayList<>();
            List<Boolean> ans = new LinkedList<>();

            for (int[] query : queries) {
                if (query[0] == 1) {
                    if (idx.isEmpty()) idx.add(query[1]);

                    else {
                        int left = 0, right = idx.size();
                        while (left < right) {
                            int mid = left + (right - left) / 2;

                            if (query[1] > idx.get(mid)) left = mid+1;
                            else right = mid;
                        }
                        idx.add(left, query[1]);
                    }

                }
                else if (query[0] == 2) {
                    int prev = 0;
                    boolean found = false;

                    for (int curr : idx) {
                        if (curr > query[1]) break;
                        int diff = curr - prev;
                        if (diff >= query[2]) {
                            found = true;
                            break;
                        }
                        prev = curr;
                    }

                    if ((query[1] - prev) >= query[2]) found = true;

                    ans.add(found);
                }
            }
            return ans;
        }
    }

    // TLE
    class Solution_ {
        public List<Boolean> getResults(int[][] queries) {
            List<Integer> idx = new ArrayList<>();
            List<Boolean> ans = new LinkedList<>();
            boolean sorted = false;

            for (int[] query : queries) {
                if (query[0] == 1) {
                    idx.add(query[1]);
                    sorted = false;
                }
                else if (query[0] == 2) {
                    if  (!sorted) {
                        idx.sort((a, b) -> a - b);
                        sorted = true;
                    }

                    int prev = 0;
                    boolean found = false;

                    for (int curr : idx) {
                        if (curr > query[1]) break;
                        int diff = curr - prev;
                        if (diff >= query[2]) {
                            found = true;
                            break;
                        }
                        prev = curr;
                    }

                    if ((query[1] - prev) >= query[2]) found = true;

                    ans.add(found);
                }
            }

            return ans;
        }
    }

}
