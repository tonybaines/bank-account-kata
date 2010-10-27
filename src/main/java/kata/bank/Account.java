package kata.bank;

public interface Account {

  void debit(double amount);

  void credit(double amount);

  double getBalance();

}
