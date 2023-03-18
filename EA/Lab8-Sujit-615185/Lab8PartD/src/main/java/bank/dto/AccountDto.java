package bank.dto;

import java.util.*;

public class AccountDto {
    //private long id;
    private long accountnumber;
    private Collection<AccountEntryDto> entryList = new ArrayList<AccountEntryDto>();
    private CustomerDto customer;
    public double getBalance() {
        double balance=0;
        for (AccountEntryDto entry : entryList) {
            balance+=entry.getAmount();
        }
        return balance;
    }
  /*  public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public long getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(long accountnumber) {
        this.accountnumber = accountnumber;
    }

    public Collection<AccountEntryDto> getEntryList() {
        return entryList;
    }

    public void setEntryList(Collection<AccountEntryDto> entryList) {
        this.entryList = entryList;
    }

    public CustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }
}
