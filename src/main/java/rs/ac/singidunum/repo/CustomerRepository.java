package rs.ac.singidunum.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	List<Customer> findAllByDeletedAtIsNull();


}
