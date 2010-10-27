package kata.bank;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;


public class TransactionStoriesTest {
  
  @Test public void A_transaction_should_debit_money_from_one_account_and_credit_to_another_account() throws InsufficientFundsException {
    Mockery context = new Mockery();
    final Account fromAccount = context.mock(Account.class);
    final Account toAccount = context.mock(Account.class, "toAccount");
    Transaction txn = new Transaction(fromAccount, toAccount, 10.0);
    context.checking(new Expectations() {{
      oneOf (fromAccount).getBalance(); will(returnValue(10.0));
      oneOf (fromAccount).debit(10.0);
      oneOf (toAccount).credit(10.0);
    }});
    txn.execute();

    context.assertIsSatisfied();
  }
  
  @Test public void Where_the_source_account_has_insufficient_funds_a_descriptive_exception_should_be_thrown() {
    Mockery context = new Mockery();
    final Account fromAccount = context.mock(Account.class);
    final Account toAccount = context.mock(Account.class, "toAccount");
    Transaction txn = new Transaction(fromAccount, toAccount, 10.0);
    context.checking(new Expectations() {{
      oneOf (fromAccount).getBalance(); will(returnValue(0.0));
    }});
    try {
      txn.execute();
      fail("Expected exception not thrown");
    }
    catch (InsufficientFundsException e) {
      assertEquals("There is not enough dosh to do the deal", e.getMessage());
    }

    context.assertIsSatisfied();
  }

}
