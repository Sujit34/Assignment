package client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@SpringBootApplication
public class Application implements CommandLineRunner {

	RestTemplate restTemplate = new RestTemplate();
	private String serverUrl = "http://localhost:8080/";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create 2 accounts;
		createAccount(1263862, "Frank Brown");
		createAccount(4253892, "John Doe");
		// use account 1;
		deposit(1263862, 240);
		deposit(1263862, 529);
		withdrawEuros(1263862, 230);
		// use account 2;
		deposit(4253892, 12450);
		depositEuros(4253892, 200);
		transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances

		Collection<AccountDTO> accountlist = getAllAccounts();
		CustomerDTO customer = null;
		for (AccountDTO account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println(
					"-Date-------------------------" + "-Description------------------" + "-Amount-------------");
			for (AccountEntryDTO entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate().toString(), entry.getDescription(),
						entry.getAmount());
			}
			System.out.println("----------------------------------------" + "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
		}

	}

	public void createAccount(long accountNumber, String customerName) {
		restTemplate.postForLocation(serverUrl+"/createAccount?accountNumber={accountNumber}&customerName={customerName}", AccountDTO.class, accountNumber, customerName);
	}

	public void withdraw(long accountNumber, double amount) {
		restTemplate.postForLocation(serverUrl+"/accounts/withdraw?accountNumber={accountNumber}&amount={amount}",AccountDTO.class,accountNumber, amount);
	}
	public void withdrawEuros(long accountNumber, double amount) {
		restTemplate.postForLocation(serverUrl+"/accounts/withdrawEuros?accountNumber={accountNumber}&amount={amount}",AccountDTO.class,accountNumber, amount);
	}
	public void deposit(long accountNumber, double amount) {
		restTemplate.postForLocation(serverUrl+"/accounts/deposit?accountNumber={accountNumber}&amount={amount}",AccountDTO.class,accountNumber, amount);
	}
	public void depositEuros(long accountNumber, double amount) {
		restTemplate.postForLocation(serverUrl+"/accounts/depositEuros?accountNumber={accountNumber}&amount={amount}",AccountDTO.class,accountNumber, amount);
	}
	public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
		restTemplate.postForLocation(serverUrl+"/accounts/transferFunds?accountNumber={accountNumber}&amount={amount}&toAccountNumber={toAccountNumber}&description={description}",AccountDTO.class,fromAccountNumber, amount,toAccountNumber, description);
	}

	public AccountDTO getAccount(long accountNumber) {
		AccountDTO accountDTO= restTemplate.getForObject(serverUrl+"accounts/{accountNumber}", AccountDTO.class, accountNumber);
		return accountDTO;
	}
	public Collection<AccountDTO> getAllAccounts() {
		Accounts accounts= restTemplate.getForObject(serverUrl+"accounts", Accounts.class);
		return accounts.getAccountList();
	}
}
