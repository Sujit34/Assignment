package repositories;

import domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByCountry(@Param("country")String country);

    @Query("select c from Customer c where c.address.city = :city")
    List<Customer> findByCity(@Param("city") String city);
}
