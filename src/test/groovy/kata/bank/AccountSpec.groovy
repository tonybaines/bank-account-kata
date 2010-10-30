package kata.bank

import spock.lang.Specification

class AccountSpec extends Specification {
  def account;
  
  def setup() {
    account = new AccountImpl(100.0)
  }
  
  def "When a debit is called the balance should drop by the amount"() {
    when:
      account.debit(10.0)
    then:
      account.balance == 90.0  
  }
  
  def "When a credit is called the balance should increase by the amount"() {
    when:
      account.credit(10.0)
    then:
      account.balance == 110.0
  }

}
