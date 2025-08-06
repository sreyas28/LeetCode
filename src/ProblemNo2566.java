public class ProblemNo2566 {
    public static void main(String[] args) {
        ProblemNo2566.Solution a = new ProblemNo2566().new Solution();

        System.out.println(a.minMaxDifference(90));


    }

    class Solution {
        public int minMaxDifference(int num) {
            String number = Integer.toString(num);

            String replaceMax = "", replaceMin = "";
            for(char c: number.toCharArray()){
                if(c != '9'){
                    replaceMax = Character.toString(c);
                    break;
                }
            }

            for(char c: number.toCharArray()){
                if(c != 0){
                    replaceMin = Character.toString(c);
                    break;
                }
            }

            int intMax = num, intMin = num;
            if(!replaceMax.isEmpty()) intMax = Integer.parseInt(number.replaceAll(replaceMax, "9"));
            if(!replaceMin.isEmpty()) intMin = Integer.parseInt(number.replaceAll(replaceMin, "0"));

            return intMax - intMin;
        }
    }

}
