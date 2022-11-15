
class SavingsAccount extends Account{
    constructor(number,interest){
        super(number);
        this.interest = interest;
    }
    setInterest(interest){
        this.interest = interest;
    }
    getInterest(){
        return this.interest;
    }
    addInterest(){
        return (this._balance * this.interest /100) + this._balance;
    }
    toString(){
        return "Account " + this._number + ": balance $" + this.addInterest();
    }
}
