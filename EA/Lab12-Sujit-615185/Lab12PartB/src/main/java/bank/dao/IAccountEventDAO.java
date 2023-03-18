package bank.dao;

import bank.domain.AccountEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountEventDAO extends JpaRepository<AccountEvent, Long> {
}
