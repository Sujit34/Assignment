package bank.service;

import bank.dao.IAccountEventDAO;
import bank.domain.AccountEvent;
import bank.email.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;

public class EmailEventListener {

    @Autowired
    EmailSender emailSender;

    @EventListener
    public void onEvent(AccountEvent event) {
        emailSender.sendEmail("Send email for change event :" + event);
    }
}
