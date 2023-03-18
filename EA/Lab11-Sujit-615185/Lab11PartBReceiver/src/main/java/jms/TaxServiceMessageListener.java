package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaxServiceMessageListener {

    @JmsListener(destination = "testQueue")
    public void receiveMessage(final String accountString) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Account account = objectMapper.readValue(accountString, Account.class);

            if(account.getOperation().equals("deposit") || account.getOperation().equals("depositEuros")) {
                System.out.println("Deposit amount " + account.getAmount()+" in account "+account.getToAccount());
            }
            if(account.getOperation().equals("transfer")) {
                System.out.println("Transfer amount " + account.getAmount()+" from account "+account.getFromAccount() +" to account " + account.getToAccount());
            }

        } catch (IOException e) {
            System.out.println("JMS receiver: Cannot convert : " + accountString+" to a Calculator object");
        }
    }
}
