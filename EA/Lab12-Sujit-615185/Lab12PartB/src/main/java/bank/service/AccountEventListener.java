package bank.service;

import bank.dao.IAccountEventDAO;
import bank.domain.AccountEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AccountEventListener {
    @Autowired
    private IAccountEventDAO accountEventDAO;

    @EventListener
    public void onEvent(AccountEvent event) {
        System.out.println("saving account change event :" + event);
        accountEventDAO.save(event);
    }
}
