import java.util.Arrays;

public class ProblemNo165 {
    public static void main(String[] args) {

        ProblemNo165.Solution a = new ProblemNo165().new Solution();
        System.out.println(a.compareVersion("1.0", "1.0.0.0.0.1"));
    }

    class Solution {
        public int compareVersion(String version1, String version2) {

            String[] ver1 = version1.split("\\.");
            String[] ver2 = version2.split("\\.");

            int ver1Len = ver1.length;
            int ver2Len = ver2.length;

            int i = 0, j = 0;

            while(i<ver1Len && j<ver2Len){
                int a = Integer.parseInt(ver1[i++]);
                int b = Integer.parseInt(ver2[j++]);

                if(a > b) return 1;
                else if(a < b) return -1;
            }

            while(i<ver1Len){
                int a = Integer.parseInt(ver1[i++]);
                if(a > 0) return 1;
            }

            while(j<ver2Len){
                int b = Integer.parseInt(ver2[j++]);
                if(b > 0) return -1;
            }

            return 0;
        }
    }

}
