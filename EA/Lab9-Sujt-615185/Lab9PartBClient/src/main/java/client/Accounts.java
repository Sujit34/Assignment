package client;

import java.util.*;
public class Accounts {
    Collection<AccountDTO> accountList = new ArrayList<AccountDTO>();

    public Collection<AccountDTO> getAccountList() {
        return accountList;
    }

    public void setAccountList(Collection<AccountDTO> accountList) {
        this.accountList = accountList;
    }
}
