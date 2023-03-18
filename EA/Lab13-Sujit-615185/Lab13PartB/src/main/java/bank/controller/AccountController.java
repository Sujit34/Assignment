package bank.controller;

import bank.domain.Accounts;
import bank.service.AccountDTO;
import bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@CrossOrigin
public class AccountController {
    @Autowired
    AccountService accountService;

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestParam(value= "accountNumber") long accountNumber, @RequestParam(value= "customerName") String customerName) {
        AccountDTO accountDto = accountService.createAccount(accountNumber, customerName);
        return new ResponseEntity<AccountDTO>(accountDto, HttpStatus.OK);
    }
    @GetMapping("/accounts/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable("accountNumber") long accountNumber){
        AccountDTO accountDto = accountService.getAccount(accountNumber);
        return new ResponseEntity<AccountDTO>(accountDto, HttpStatus.OK);
    }

    @GetMapping ("/accounts")
    public ResponseEntity<?> getAllAccounts() {
        Collection<AccountDTO>  accountList = accountService.getAllAccounts();
        Accounts accounts = new Accounts();
        accounts.setAccountList(accountList);
        return new ResponseEntity<Accounts>(accounts, HttpStatus.OK);
    }

    @PostMapping("/accounts/deposit")
    public AccountDTO accountDeposit (@RequestParam(value= "accountNumber")long accountNumber, @RequestParam(value= "amount")double amount) {
        accountService.deposit(accountNumber, amount );
        return accountService.getAccount(accountNumber);
    }

    @PostMapping("/accounts/depositEuros")
    public AccountDTO accountDepositEuros (@RequestParam(value= "accountNumber")long accountNumber, @RequestParam(value= "amount")double amount) {
        accountService.depositEuros(accountNumber, amount );
        return accountService.getAccount(accountNumber);
    }

    @PostMapping("/accounts/withdraw")
    public AccountDTO accountWithdraw (@RequestParam(value= "accountNumber")long accountNumber, @RequestParam(value= "amount")double amount) {
        accountService.withdraw(accountNumber, amount );
        return accountService.getAccount(accountNumber);
    }


    @PostMapping("/accounts/withdrawEuros")
    public AccountDTO accountWithdrawEuros (@RequestParam(value= "accountNumber")long accountNumber, @RequestParam(value= "amount")double amount ) {
        accountService.withdrawEuros(accountNumber, amount );
        return accountService.getAccount(accountNumber);
    }

    @PostMapping("/accounts/transferFunds")
    public AccountDTO accountTransferFunds (@RequestParam(value= "accountNumber")long accountNumber,
            @RequestParam(value= "amount")double amount, @RequestParam(value= "toAccountNumber")long toAccountNumber,
            @RequestParam(value= "description")String description) {
        accountService.transferFunds(accountNumber, toAccountNumber, amount, description);
        return accountService.getAccount(accountNumber);
    }
}
