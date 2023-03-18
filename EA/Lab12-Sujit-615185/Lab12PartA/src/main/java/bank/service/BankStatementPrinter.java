package bank.service;

import bank.dto.AccountDto;
import bank.dto.AccountEntryDto;
import bank.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BankStatementPrinter {
    public void print(Collection<AccountDto> accountlist){
        CustomerDto customer = null;
        for (AccountDto account : accountlist) {
            customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountnumber());
            System.out.println("Account Holder: " + customer.getName());
            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");
            for (AccountEntryDto entry : account.getEntryList()) {
                System.out.printf("%30s%30s%20.2f\n", entry.getDate()
                        .toString(), entry.getDescription(), entry.getAmount());
            }
            System.out.println("----------------------------------------"
                    + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
                    account.getBalance());
        }
    }
}
