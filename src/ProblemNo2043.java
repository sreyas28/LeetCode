import java.util.HashMap;
import java.util.Map;

public class ProblemNo2043 {
    public static void main(String[] args) {

    }

    class Bank {
        private long[] balance;
        public Bank(long[] balance) {
            this.balance = balance;
        }

        public boolean transfer(int account1, int account2, long money) {
            if(account1-1 < balance.length && account2-1 < balance.length){
                long value = balance[account1 - 1];
                if(value >= money){
                    balance[account1-1] -= money;
                    balance[account2-1] += money;
                     return true;
                }
            }

            return false;
        }

        public boolean deposit(int account, long money) {
            if(account-1 < balance.length){
                balance[account-1] += money;
                return true;
            }

            return false;
        }

        public boolean withdraw(int account, long money) {
            if(account-1 < balance.length){
                long value = balance[account - 1];
                if(value >= money){
                    balance[account-1] -= money;
                    return true;
                }
            }

            return false;
        }
    }


    class Bank_ {
        private final Map<Integer, Long> balance = new HashMap<>();

        public Bank_(long[] balance) {

            for(int i = 0; i < balance.length; i++){
                this.balance.put(i+1, balance[i]);
            }

        }

        public boolean transfer(int account1, int account2, long money) {
            if (!balance.containsKey(account1 - 1) || !balance.containsKey(account2 - 1)) {
                return false;
            }


            long value = this.balance.getOrDefault(account1, 0L);
            if(value >= money){

                this.balance.put(account1, this.balance.get(account1) - money);
                this.balance.put(account2, this.balance.getOrDefault(account2, 0L) + money);

                return true;
            }

            return false;
        }

        public boolean deposit(int account, long money) {

            if(this.balance.containsKey(account)){
                this.balance.put(account, this.balance.getOrDefault(account, 0L) + money);
                return true;
            }

            return false;
        }

        public boolean withdraw(int account, long money) {
            long value = this.balance.getOrDefault(account, 0L);

            if(value >= money){
                this.balance.put(account, this.balance.get(account) - money);
                return true;
            }

            return false;
        }
    }

}
