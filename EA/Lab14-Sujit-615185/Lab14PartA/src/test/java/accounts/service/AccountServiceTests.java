package accounts.service;

import accounts.domain.Account;
import accounts.repositories.AccountRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class AccountServiceTests {
    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {
        @Bean
        public AccountService accountService() {
            return new AccountService();
        }
    }
    @Autowired
    private AccountService accountService;
    @MockBean
    private AccountRepository accountRepository;

    @Before
    public void setUp() {
        Account account = new Account("1",0.0,"Sujit Kumar Chanda");
        Optional<Account> sujit= Optional.of(account);
        Mockito.when(accountRepository.findById("1")).thenReturn(sujit);
    }

    @Test
    public void whenValidAccountNumberThenAccountShouldBeFound() {
        AccountDTO sujit = accountService.getAccount("1");
        assertThat(sujit.getAccountHolder())
                .isEqualTo("Sujit Kumar Chanda");
    }
}
