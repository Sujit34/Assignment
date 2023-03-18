package customers;

import bank.domain.Account;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class AccountTest {
    @Test
    public void testIncrement(){
        Account account = new Account();
        account.deposit(100.0);
        assertThat( account.getBalance(), closeTo (100.0, 0.01));
    }
    @Test
    public void testCreateAccount(){
        Account account = new Account();
        assertThat( account.getBalance(), closeTo (0.0, 0.01));
    }
    @Test
    public void testWithdraw(){
        Account account = new Account();
        account.withdraw(100.0);
        assertThat( account.getBalance(), closeTo (-100.0, 0.01));
    }


}
