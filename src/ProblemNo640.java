public class ProblemNo640 {
    public static void main(String[] args) {
        Solution a = new ProblemNo640().new Solution();
//        System.out.println(a.solveEquation("2x=x"));
//        System.out.println(a.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(a.solveEquation("1+2+3+x-x=x-x+1+2+3"));
    }

    class Solution {
        public String solveEquation(String equation) {
            final int LEN = equation.length();

            int xCount_LHS = 0; // sum of lhs X count
            int xCount_RHS = 0; // sum of rhs X count

            int numSum = 0; // left side be negative and right +ve as we will move rhs to lhs
            int idx = 0; // for index

            boolean sign = true; // false means - and true means +

            while (idx < LEN) {
                char c = equation.charAt(idx);

                if (c == '=') break;
                else if (c == '+') sign = true;
                else if (c == '-') sign = false;
                else if (c == 'x') xCount_LHS += sign ? 1 : -1;
                else {
                    int val = 0;
                    int localIdx = idx;

                    for (; localIdx < LEN; localIdx++) {
                        if (Character.isDigit(equation.charAt(localIdx)))
                            val = val * 10 + (equation.charAt(localIdx) - '0');
                        else break;
                    }

                    if (localIdx < LEN && equation.charAt(localIdx) == 'x') {
                        xCount_LHS += sign ? val : -val;
                        idx = localIdx;
                    } else {
                        numSum += sign ? -val : val; // assuming moving it to RHS
                        idx = localIdx - 1;
                    }
                }

                idx++;
            }

            idx++; // now we will start ahead of =
            sign = true; // false means - and true means +

            while (idx < LEN) {
                char c = equation.charAt(idx);

                if (c == '+') sign = true;
                else if (c == '-') sign = false;
                else if (c == 'x') xCount_RHS += sign ? 1 : -1;
                else {
                    int val = 0;
                    int localIdx = idx;

                    for (; localIdx < LEN; localIdx++) {
                        if (Character.isDigit(equation.charAt(localIdx)))
                            val = val * 10 + (equation.charAt(localIdx) - '0');
                        else break;
                    }

                    if (localIdx < LEN && equation.charAt(localIdx) == 'x') {
                        xCount_RHS += sign ? val : -val;
                        idx = localIdx;
                    }
                    else {
                        numSum += sign ? val : -val;
                        idx = localIdx - 1;
                    }
                }

                idx++;
            }

            if (xCount_LHS == xCount_RHS && numSum != 0) return "No solution";
            else if (xCount_LHS == xCount_RHS ) return "Infinite solutions";
            return "x=" + numSum / (xCount_LHS - xCount_RHS);
        }
    }

}
