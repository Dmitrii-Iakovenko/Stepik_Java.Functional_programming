import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// 4.12 The total sum of canceled transactions
// https://stepik.org/lesson/36145/step/1?unit=15254
public class Solution_4_12 {

    public static void main(String[] args) throws ParseException {
        List<Account> accounts = List.of(
                new Account("1001", 0L, List.of(
                        new Transaction("774cedda-9cde-4f53-8bc2-5b4d4859772a",
                                State.CANCELED, 1000L, "2016.12.12 18:30:05")
                )),
                new Account("1002", 8000L, List.of(
                        new Transaction("337868a7-f469-43c0-9042-3422ce37ee26a",
                                State.FINISHED, 8000L, "2016.12.12 17:30:55"),
                        new Transaction("f8047f86-89e7-4226-8b75-74c55a4d7e31",
                                State.CANCELED, 10000L, "2016.12.12 18:10:18")
                ))
        );

        System.out.println(calcSumOfCanceledTransOnNonEmptyAccounts(accounts));
    }

    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {
        // write your code here
        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .flatMap(account -> account.getTransactions().stream())
                .filter(transaction -> transaction.getState() == State.CANCELED)
                .mapToLong(Transaction::getSum)
                .sum();
    }


    private static class Transaction {
        private final String uuid;
        private final State state;
        private final Long sum;
        private final Date created;

        public String getUuid() {
            return uuid;
        }

        public State getState() {
            return state;
        }

        public Long getSum() {
            return sum;
        }

        public Date getCreated() {
            return created;
        }

        public Transaction(String uuid, State state, Long sum, String created) throws ParseException {
            this.uuid = uuid;
            this.state = state;
            this.sum = sum;

            SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
            this.created = format.parse(created);
        }
    }


    private static class Account {
        private final String number;
        private final Long balance;
        private final List<Transaction> transactions;

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }

        public Account(String number, Long balance, List<Transaction> transactions) {
            this.number = number;
            this.balance = balance;
            this.transactions = transactions;
        }
    }

    private enum State {
        CANCELED("CANCELED"),
        FINISHED("FINISHED"),
        PROCESSING("PROCESSING");

        public final String state;

        State(String state) {
            this.state = state;
        }
    }



}


