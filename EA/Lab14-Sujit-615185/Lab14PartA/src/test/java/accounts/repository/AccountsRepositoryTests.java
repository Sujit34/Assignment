package accounts.repository;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountsRepositoryTests {
    @Autowired
    private TestEntityManager testEntityManager;
    @Autowired
    private AccountRepository accountRepository;
    @Test
    public void whenFindByAccountHolder_thenReturnAccount() {
        Account account = new Account("1",0.0,"Sujit Kumar Chanda");
        testEntityManager.persist(account);
        testEntityManager.flush();
        Account sujit = accountRepository.findByAccountHolder("Sujit Kumar Chanda");
        assertThat(account.getAccountHolder()).isEqualTo(sujit.getAccountHolder());
    }
    @Test
    public void whenFindByAccountNumber_thenReturnAccount() {
        Account account = new Account("1",0.0,"Sujit Kumar Chanda");
        testEntityManager.persist(account);
        testEntityManager.flush();
        Account sujit = accountRepository.findByAccountNumber("1");
        assertThat(account.getAccountNumber()).isEqualTo(sujit.getAccountNumber());
    }
    @Test
    public void whenFindByAccountBalance_thenReturnAccount() {
        Account account = new Account("1",0.0,"Sujit Kumar Chanda");
        testEntityManager.persist(account);
        testEntityManager.flush();
        Account sujit = accountRepository.findByAccountBalance(0.0);
        assertThat(account.getBalance()).isEqualTo(sujit.getBalance());
    }
}
