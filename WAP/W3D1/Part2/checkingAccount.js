class CheckingAccount extends Account{
    constructor(number,overdraftLimit){
        super(number);
        this.overdraftLimit = overdraftLimit;
    }    
    setOverdraftLimit(overdraftLimit){
        this.overdraftLimit = overdraftLimit;
    }
    getOverdarftLimit(){
        return this.overdraftLimit;
    }
    withdraw(amount) {
        if (amount <= 0) {
            throw new RangeError("Withdraw amount must be greater than zero");
        }
        if (amount > (this._balance - this.overdraftLimit)) {
            throw Error("No enough funds");
        }
        this._balance -= amount;
        return this._balance
    }
    toString(){
        return "Account " + this._number + ": remaining balance $" + this._balance;
    }
}