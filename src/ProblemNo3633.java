public class ProblemNo3633 {
    public static void main(String[] args) {

    }

    class Solution {
        public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
            final int LANDS = landStartTime.length;
            final int WATERS = waterStartTime.length;

            int min = Integer.MAX_VALUE;
            int[] landEndTime = new int[LANDS];
            int[] waterEndTime = new int[WATERS];

            for (int i = 0; i < LANDS; i++) landEndTime[i] = landStartTime[i] + landDuration[i];
            for (int i = 0; i < WATERS; i++) waterEndTime[i] = waterStartTime[i] + waterDuration[i];

            for (int land = 0; land < LANDS; land++) {

                for (int water = 0; water < WATERS; water++) {

                    // land to water
                    int temp_01 = (landEndTime[land] < waterStartTime[water] ? waterEndTime[water] : landEndTime[land] + waterDuration[water]);
                    min = Math.min(min, temp_01);

                    //water to land
                    int temp_02 = (waterEndTime[water] < landStartTime[land] ? landEndTime[land] : waterEndTime[water] + landDuration[land]);
                    min = Math.min(min, temp_02);

                }
            }

            return min;
        }
    }

}
