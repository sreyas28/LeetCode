import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ProblemNo2327 {
    public static void main(String[] args) {
        ProblemNo2327.Solution a = new ProblemNo2327().new Solution();
        System.out.println(a.peopleAwareOfSecret(6,2,4));
    }

    class Solution {
        final int MOD = (int) (1e9 + 7);

        public int peopleAwareOfSecret(int days, int delay, int forget) {

            int[] DP = new int[days+1];
            DP[1] = 1;

            int share = 0;
            for(int day = 2; day<=days; day++){
                if(day - delay >= 1) share = (share + DP[day - delay]) % MOD;
                if(day - forget >= 1) share = (share - DP[day - forget] + MOD) % MOD;

                DP[day] = share % MOD;
            }

            int total = 0;
            for(int i=days-forget+1; i<=days; i++) total = (total + DP[i]) % MOD;

            return total;
        }

        public int peopleAwareOfSecret_(int days, int delay, int forget) {
            ArrayList<int[]> delayForget = new ArrayList<>();

            delayForget.add(new int[]{delay,forget});

            for(int day=1; day<days; day++){
                ArrayList<int[]> delayForget_temp = new ArrayList<>();

                for(int[] val: delayForget){
                    int delay_ = val[0] == 0 ? 0: val[0]-1;
                    int forget_ = val[1] == 0 ? 0: val[1]-1;

                    if(forget_ != 0){
                        if(delay_ == 0)delayForget_temp.add(new int[]{delay, forget});
                        delayForget_temp.add(new int[]{delay_, forget_});
                    }

                }
                delayForget = new ArrayList<>(delayForget_temp);
            }

            return delayForget.size() % MOD;
        }
    }

}
