import java.util.Stack;

public class ProblemNo1541 {
    public static void main(String[] args) {

        Solution a = new ProblemNo1541().new Solution();
//        System.out.println(a.minInsertions(")())"));
//        System.out.println(a.minInsertions("()()()))))"));
//        System.out.println(a.minInsertions("(()()))"));
        System.out.println(a.minInsertions(")"));

    }


    class Solution {
        public int minInsertions(String s) {
            int open = 0;
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') open++;
                else {
                    if (i + 1 < s.length() && s.charAt(i + 1) == ')') i++;
                    else ans++;

                    if (open > 0) open--;
                    else ans++;
                }
            }
            ans += 2 * open;
            return ans;
        }
    }

    // working But Slow
    class Solution__ {
        public int minInsertions(String s) {
            Stack<Character> stack = new Stack<>();
            int count = 0;

            for (char cur : s.toCharArray()) {
                Character prev = stack.isEmpty() ? null : stack.peek();

                if (prev != null && prev == cur && prev == ')') {
                    int balance = -1;
                    while (!stack.isEmpty() && stack.peek() == ')') {
                        balance -= 1;
                        stack.pop();
                    }

                    if (stack.isEmpty()) {
                        int abs = Math.abs(balance);
                        count += (abs / 2) + (abs % 2 == 0 ? 0 : 2);

                    } else stack.pop();
                } else if (prev != null && prev == ')' && cur == '(') {
                    int balance = 0;
                    while (!stack.isEmpty() && stack.peek() == ')') {
                        balance -= 1;
                        stack.pop();
                    }

                    if (stack.isEmpty()) {
                        int abs = Math.abs(balance);
                        count += (abs / 2) + (abs % 2 == 0 ? 0 : 2);
                    } else {
                        balance += 2;
                        count += balance;
                        stack.pop();
                    }
                    stack.push(cur);
                }
                else stack.push(cur);
            }

            while (!stack.isEmpty()) {
                int balance = 0;
                while (!stack.isEmpty() && stack.peek() == ')') {
                    balance -= 1;
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    int abs = Math.abs(balance);
                    count += (abs / 2) + (abs % 2 == 0 ? 0 : 2);
                } else {
                    balance += 2;
                    count += balance;
                    stack.pop();
                }
            }


            return count;
        }
    }

    // wrong intuition
    class Solution_ {
        public int minInsertions(String s) {
            int balance = 0, count = 0;
            boolean flag = false;

            for (char c : s.toCharArray()) {
                if (c == '(') {
                    if (balance < 0) {
                        int abs = Math.abs(balance);
                        count += (abs / 2) + (abs % 2 == 0 ? 0 : 2);
                        balance = 0;
                    }

                    if (flag) {
                        count += balance;
                        balance = 0;
                        flag = false;
                    }

                    balance += 2;
                } else if (c == ')') {
                    flag = true;
                    balance--;
                }

            }

            if (balance < 0) {
                int abs = Math.abs(balance);
                count += (abs / 2) + (abs % 2 == 0 ? 0 : 2);
                balance = 0;
            } else count += balance;

            return count;
        }
    }

}
