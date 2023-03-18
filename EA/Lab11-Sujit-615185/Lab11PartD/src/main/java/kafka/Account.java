package kafka;

public class Account {
    private long accountNumber;
    private String customerName;
    private double amount;
    private String operation;

    public Account(){

    }
    public Account(long accountNumber, String customerName, String operation){
        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.operation = operation;
    }

    public Account(long accountNumber, double amount, String operation){
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.operation = operation;
    }

    public long getAccountNumber(){return accountNumber;}
    public void setAccountNumber(long accountNumber){this.accountNumber = accountNumber;}
    public String getCustomerName(){return customerName;}
    public void setCustomerName(String customerName) {this.customerName = customerName;}
    public double getAmount(){return amount;}
    public void setAmount(double amount){this.amount = amount;}
    public String getOperation(){return operation;}
    public void setOperation(String operation){this.operation = operation;}
}
