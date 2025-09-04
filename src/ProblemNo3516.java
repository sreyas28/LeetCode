public class ProblemNo3516 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findClosest(int x, int y, int z) {

            int XZ_distance = Math.abs(x-z);
            int YZ_distance = Math.abs(y-z);

            if(XZ_distance == YZ_distance) return 0;
            else if(XZ_distance < YZ_distance) return 1;
            else return 2;

        }
    }

}
