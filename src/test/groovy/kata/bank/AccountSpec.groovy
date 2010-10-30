package kata.bank

import spock.lang.Specification

class AccountSpec extends Specification {
  def account;
  
  def setup() {
    account = new AccountImpl(100.0)
  }
  
  def "When a debit is made the balance should drop by the amount"() {
    when: account.debit(amount)
    then: account.getBalance() == newBalance
    where:
      // Contrived example of parameterised tests - one test for each value
      amount | newBalance
      10.0   |  90.0
      50.0   |  50.0
      100.0  |  0.0  
  }
  
  def "When a credit is made the balance should increase by the amount"() {
    when: account.credit(10.0)
    then: account.getBalance() == 110.0
  }

}
