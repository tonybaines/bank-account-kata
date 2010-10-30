package kata.bank;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AccountTest {
  Account account;

  @Before public void setup() {
    account = new AccountImpl(100.0);
  }
  
  @Test public void whenADebitIsMadeTheBalanceShouldDropByTheAmount() {
    account.debit(10.0);
    assertEquals(90.0, account.getBalance(), 0);
  }
  
  @Test public void whenACreditIsMadeTheBalanceShouldIncreaseByTheAmount() {
    account.credit(10.0);
    assertEquals(110.0, account.getBalance(), 0);
  }
}
