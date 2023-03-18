package bank.dto.adapter;

import bank.domain.Account;
import bank.dto.AccountDto;
import java.util.Collection;
import java.util.stream.Collectors;

public class AccountAdapter {
        public static AccountDto getAccountDTOFromAccount(Account account){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setAccountnumber(account.getAccountnumber());
        accountDto.setCustomer(CustomerAdapter.convertCustomerToCustomerDto(account.getCustomer()));
        accountDto.setEntryList(AccountEntryAdapter.getAccountEntryDtoCollectionFromAccountEntryCollection(account.getEntryList()));
        return accountDto;
    }


    public static Account getAccountFromAccountDTO(AccountDto accountDto){
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setAccountnumber(accountDto.getAccountnumber());
        account.setCustomer(CustomerAdapter.convertCustomerDtoToCustomer(accountDto.getCustomer()));
        account.setEntryList(AccountEntryAdapter.getAccountEntryCollectionFromAccountEntryDtoCollection(accountDto.getEntryList()));
        return account;
    }

    public static Collection<AccountDto> getAccountDtoCollectionFromAccount (Collection<Account> accounts){
        return accounts.stream().map(account -> getAccountDTOFromAccount(account)).collect(Collectors.toList());
    }


    public static Collection<Account> getAccountCollectionFromAccountDtoCollection (Collection<AccountDto> accountDtos){
        return accountDtos.stream().map(accountDto -> getAccountFromAccountDTO(accountDto)).collect(Collectors.toList());
    }
}
