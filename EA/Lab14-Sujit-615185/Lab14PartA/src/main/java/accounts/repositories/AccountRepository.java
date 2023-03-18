package accounts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import accounts.domain.Account;


public interface AccountRepository extends JpaRepository<Account, String>{
   public Account findByAccountHolder(String accountHolder);
   public Account findByAccountNumber(String accountNumber);
   public Account findByAccountBalance(double accountBalance);
}
