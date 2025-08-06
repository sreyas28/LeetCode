public class ProblemNo1432 {
    public static void main(String[] args) {
        ProblemNo1432.Solution a = new ProblemNo1432().new Solution();

        System.out.println(a.maxDiff(9));

    }

    class Solution {
        public int maxDiff(int num) {
            String number = Integer.toString(num);

            char replaceMax = '_', replaceMin = '_';
            for(char c: number.toCharArray()){
                if(c != '9'){
                    replaceMax = c;
                    break;
                }
            }
            int Max = Integer.parseInt(number.replace(replaceMax, '9'));

            int Min = 0;
            if(number.charAt(0) == '1'){
                for(char c: number.toCharArray()){
                    if(c != '0' && c != '1'){
                        replaceMin = c;
                        break;
                    }
                }

                Min = Integer.parseInt(number.replace(replaceMin, '0'));
            }

            else{
                replaceMin = number.charAt(0);
                Min = Integer.parseInt(number.replace(replaceMin, '1'));
            }

            return Max - Min;
        }
    }

}
