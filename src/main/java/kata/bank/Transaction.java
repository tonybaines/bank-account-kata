package kata.bank;

public class Transaction {

  private final Account sourceAccount;
  private final Account destinationAccount;
  private final double amount;

  public Transaction(Account from, Account toAccount, double amount) {
    this.sourceAccount = from;
    this.destinationAccount = toAccount;
    this.amount = amount;
  }

  public void execute() throws InsufficientFundsException {
    if (this.sourceAccount.getBalance() < this.amount) {
      throw new InsufficientFundsException("There is not enough dosh to do the deal");
    }
    this.sourceAccount.debit(this.amount);
    this.destinationAccount.credit(this.amount);
  }

}
