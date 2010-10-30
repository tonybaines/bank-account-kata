package kata.bank

import spock.lang.Specification

class TransactionsSpec extends Specification {
  
  def "A transaction should debit money from one account and credit to another account"() {
    given: // Setup
     def fromAccount = Mock(Account)
     def toAccount = Mock(Account)
     def txn = new Transaction(fromAccount, toAccount, 10.0)
    when: // Execute
     txn.execute()
    then: // Assertions  
     1 * fromAccount.getBalance() >> 10.0 // Mock expectations are just another assertion
     1 * fromAccount.debit(10.0)
     1 * toAccount.credit(10.0) 
  }
  
  def "Where the source account has insufficient funds a descriptive exception should be thrown"() {
   given:
    def fromAccount = Mock(Account)
    def toAccount = Mock(Account)
    def txn = new Transaction(fromAccount, toAccount, 10.0)
   when:
    txn.execute()
   then:
    1 * fromAccount.getBalance() >> 0
    thrown(InsufficientFundsException)
    0 * fromAccount.debit(_) // Mocks are lenient so make
    0 * toAccount.credit(_)  // these interactions explicit (if we care)
  }
  
}
