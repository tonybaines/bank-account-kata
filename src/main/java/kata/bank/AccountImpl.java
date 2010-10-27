package kata.bank;

public class AccountImpl implements Account {

  private double balance;

  public AccountImpl(double openingBalance) {
    this.balance = openingBalance;
  }

  @Override
  public void debit(double amount) {
    this.balance -= amount;
  }

  @Override
  public void credit(double amount) {
    this.balance += amount;
  }

  @Override
  public double getBalance() {
    return this.balance;
  }

}
