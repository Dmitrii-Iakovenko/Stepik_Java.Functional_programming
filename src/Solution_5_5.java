import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;


// 5.5 Almost like a SQL: the total sum of transactions by each account
// https://stepik.org/lesson/36018/step/1?unit=15142
public class Solution_5_5 {


    public static void main(String[] args) {
        Account dima = new Account("Dima", 40000L);
        Account yuka = new Account("Yuka", 70000L);
        Account liza = new Account("Liza", 100L);
        List<Transaction> transactions = List.of(
                new Transaction("uuid01", 700L, dima),
                new Transaction("uuid02", 350L, dima),
                new Transaction("uuid03", 2200L, dima),
                new Transaction("uuid04", 500L, yuka),
                new Transaction("uuid05", 22200L, yuka),
                new Transaction("uuid06", 1200L, yuka),
                new Transaction("uuid06", 333L, liza)
        );
        Map<String, Long> totalSumOfTransByEachAccount =
                transactions.stream()
                        .collect(groupingBy(transaction -> transaction.getAccount().getNumber(),
                                reducing(0L, Transaction::getSum, Long::sum)));
        System.out.println(totalSumOfTransByEachAccount);
    }


    private static class Account {
        private final String number;
        private final Long balance;

        public Account(String number, Long balance) {
            this.number = number;
            this.balance = balance;
        }

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }
    }

    private static class Transaction {
        private final String uuid;
        private final Long sum;
        private final Account account;

        public Transaction(String uuid, Long sum, Account account) {
            this.uuid = uuid;
            this.sum = sum;
            this.account = account;
        }

        public String getUuid() {
            return uuid;
        }

        public Long getSum() {
            return sum;
        }

        public Account getAccount() {
            return account;
        }
    }
}
