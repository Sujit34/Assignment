package bank.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@EnableJms
public class JMSSender implements IJMSSender{
	@Autowired
	JmsTemplate jmsTemplate;
	public void sendJMSMessage (double amount, long toAccount, long fromAccount,String operation)  {
		ObjectMapper objectMapper = new ObjectMapper();

		if(operation =="deposit" || operation =="depositEuros"){
			Account account = new Account(amount,toAccount,operation);
			try{

				String accountString = objectMapper.writeValueAsString(account);
				System.out.println("Sending a JMS message: Deposit" + accountString);
				jmsTemplate.convertAndSend("testQueue",accountString);
			}
			catch (Exception ex){
				System.out.println("Can not convert " + account);
			}
		}
		else if(operation == "transfer"){
			Account account = new Account(amount,toAccount,fromAccount,operation);
			try{
				String accountString = objectMapper.writeValueAsString(account);
				System.out.println("Sending a JMS message: Transfer" + accountString);
				jmsTemplate.convertAndSend("testQueue",accountString);
			}
			catch(Exception ex){
				System.out.println("Can not convert " + account);
			}
		}
	}

}
