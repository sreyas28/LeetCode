import java.util.*;

public class ProblemNo401 {
    public static void main(String[] args) {

    }

    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> res = new ArrayList<>();

            if (turnedOn == 0) {
                res.add("0:00");
                return res;
            }

            for (int hour = 0; hour < 12; hour++) {
                for (int minute = (hour == 0 ? 1 : 0); minute < 60; minute++) {
                    if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                        res.add(String.format("%d:%02d", hour, minute));
                    }
                }
            }
            return res;
        }
    }

}
