package bank.jms;

public class Account {
    private double amount;
    private long fromAccount;
    private long toAccount;
    private String operation;
    public Account(){

    }
    public Account(double amount, long fromAccount, long toAccount,String operation){
        this.amount =amount;
        this.fromAccount =fromAccount;
        this.toAccount = toAccount;
        this.operation = operation;
    }
    public Account(double amount, long toAccount,String operation){
        this.amount =amount;
        this.toAccount = toAccount;
        this.operation = operation;
    }
    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount = amount;}
    public long getFromAccount(){return fromAccount;}
    public void setFromAccount(long fromAccount){this.fromAccount = fromAccount;}
    public long getToAccount(){return toAccount;}
    public void setToAccount(long toAccount){this.toAccount = toAccount;}
    public String getOperation(){return operation;}
    public void SetOperation(String operation){this.operation = operation;}

}
