import java.util.Arrays;
import java.util.Map;

public class ProblemNo3494 {
    public static void main(String[] args) {
        ProblemNo3494.Solution a = new ProblemNo3494().new Solution();
        System.out.println(a.minTime(new int[]{1,2,3,4}, new int[]{1,2}));
    }

    class Solution {
        public long minTime(int[] wizard, int[] portion) {
            long[][] DP = new long[portion.length][wizard.length + 1];

            DP[0][1] = (long) wizard[0] * portion[0];

            for(int i = 1; i < wizard.length; i++) DP[0][i+1] = DP[0][i] + (long) wizard[i] * portion[0]; // line row

            for(int i = 1; i < portion.length; i++ ) {
                DP[i][0] = DP[i-1][1];
                for (int j = 1; j < DP[0].length; j++) {
                    DP[i][j] = Math.max(DP[i-1][j], DP[i][j-1]) + (long) wizard[j-1] * portion[i];
                }
                for(int j = DP[0].length-2; j >= 0; j--){
                    DP[i][j] = DP[i][j+1] - (long) wizard[j] * portion[i];
                }
            }


            for(long[] x: DP){
                System.out.println(Arrays.toString(x));
            }

            return DP[portion.length-1][wizard.length];
        }
    }

//    public long minTime(int[] skill, int[] mana) {
//        long[][] time = new long[mana.length][skill.length];
//
//        time[0][0] = (long) skill[0] * mana[0];
//        for(int wizard = 1; wizard < skill.length; wizard++){
//            time[0][wizard] = time[0][wizard-1] + (long) mana[0] * skill[wizard];
//        }
//
//        for (int portion = 1; portion < mana.length; portion++){
//            for(int wizard = 0; wizard < skill.length; wizard++){
//                time[portion][wizard] = (wizard == 0 ? time[portion-1][wizard]+1 : time[portion][wizard-1]) + (long) mana[portion] * skill[wizard];
//            }
//
//            for (int wizard = skill.length - 1; wizard > 0; wizard--) {
//                long above = time[portion - 1][wizard];
//                long current = time[portion][wizard];
//
//                if (above > current) {
//                    time[portion][wizard] = above + (long) mana[portion] * skill[wizard];
//                    time[portion][wizard - 1] = above;
//                } else time[portion][wizard-1] = current - (long) mana[portion] * skill[wizard];
//
//            }
//        }
//
//
//        System.out.println(Arrays.deepToString(time));
//        return time[mana.length-1][skill.length-1];
//    }

}
