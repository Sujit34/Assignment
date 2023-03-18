package bank.domain;

import javax.persistence.*;

import java.util.Date;

@Entity
public class AccountEvent {
    @Id
    @GeneratedValue
    private long id;
    private long fromAccountNumber;
    private long toAccountNumber;
    private double amount;
    private long accountNumber;
    private String operation;
    private Date date = new Date();

    public String toString() {
        if (!operation.equals("transfer") )
            return  operation + ":" + "AccountNumber=" + accountNumber + ", amount=" + amount;
        else
            return operation + ": from=" + fromAccountNumber + ", to=" + toAccountNumber + ", amount=" + amount;

    }

    public AccountEvent(String operation, long fromAccountNumber, long toAccountNumber, double amount) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
        this.operation = operation;
    }
    public AccountEvent(String operation, long accountNumber, double amount) {
        this.amount = amount;
        this.operation = operation;
        this.accountNumber = accountNumber;
    }
}
