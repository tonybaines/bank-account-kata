package kata.bank;

import static org.junit.Assert.*;

import org.junit.Test;


public class AccountTest {
  @Test public void when_a_debit_is_called_the_balance_should_drop_by_the_amout() {
    Account account = new AccountImpl(100.0);
    account.debit(10.0);
    assertEquals(90.0, account.getBalance(), 0);
  }
  
  @Test public void when_a_credit_is_called_the_balance_should_increase_by_the_amout() {
    Account account = new AccountImpl(100.0);
    account.credit(10.0);
    assertEquals(110.0, account.getBalance(), 0);
  }
}
