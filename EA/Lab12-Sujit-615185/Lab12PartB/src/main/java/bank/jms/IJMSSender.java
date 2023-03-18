package bank.jms;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface IJMSSender {
	public void sendJMSMessage (double amount, long toAccount, long fromAccount, String operation);
}
