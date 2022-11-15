class Bank{
    static nextNumber= 1;
    constructor(){
         this.accountArr = [];
    }
    addAccount(){
        let account = new Account(Bank.nextNumber++);
        this.accountArr.push(account);
        return this.accountArr.length;
    }

    addSavingsAccount(interest){
        let savingAccount = new SavingsAccount(Bank.nextNumber++,interest);
        this.accountArr.push(savingAccount);
        return this.accountArr.length;
    }
    addCheckingAccount(overdraft){
        let checkingAccount = new CheckingAccount(Bank.nextNumber++,overdraft);
        this.accountArr.push(checkingAccount);
        return this.accountArr.length;
    }
    closeAccount(number){
         this.accountArr = this.accountArr.filter(x => x._number != number);  
         return this.accountArr.length;
    }

    accountReport(){
        let accountDetail = '';
        for(let account of this.accountArr){
            accountDetail += "Account number " + account._number + ": balance $" + account._balance +"\n";
        }
        return accountDetail;
    }
}