package accounts.controller;

import accounts.service.AccountDTO;
import accounts.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class AccountControllerTest {
    @Autowired
    MockMvc mock;
    @MockBean
    AccountService accountService;

    @Test
    public void testGetAccount() throws Exception {
        Mockito.when(accountService.getAccount("1")).thenReturn(new AccountDTO("1", 0.0,"Sujit Kumar Chanda"));
        mock.perform(MockMvcRequestBuilders.get("/account/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountNumber").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.balance").value(0.0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountHolder").value("Sujit Kumar Chanda"));
    }
}
