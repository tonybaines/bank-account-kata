package kata.bank;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(JMock.class)
public class TransactionStoriesTest {
  Mockery context = new Mockery();
  
  @Test public void aTransactionShouldDebitMoneyFromOneAccountAndCreditToAnotherAccount() throws InsufficientFundsException {
    final Account fromAccount = context.mock(Account.class);
    final Account toAccount = context.mock(Account.class, "toAccount");
    Transaction txn = new Transaction(fromAccount, toAccount, 10.0);
    context.checking(new Expectations() {{
      oneOf (fromAccount).getBalance(); will(returnValue(10.0));
      oneOf (fromAccount).debit(10.0);
      oneOf (toAccount).credit(10.0);
    }});
    txn.execute();
  }
  
  @Test(expected=InsufficientFundsException.class) 
  public void whereTheSourceAccountHasInsufficientFundsADescriptiveExceptionShouldBeThrown() throws InsufficientFundsException {
    final Account fromAccount = context.mock(Account.class);
    final Account toAccount = context.mock(Account.class, "toAccount");
    Transaction txn = new Transaction(fromAccount, toAccount, 10.0);
    context.checking(new Expectations() {{
      oneOf (fromAccount).getBalance(); will(returnValue(0.0));
    }});
    txn.execute();
  }

}
