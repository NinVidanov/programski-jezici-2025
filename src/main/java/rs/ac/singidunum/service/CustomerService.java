package rs.ac.singidunum.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.repo.CustomerRepository;

@Service
@RequiredArgsConstructor
public class CustomerService {
	
	private final CustomerRepository repo;
	
    public List<Customer> getCustomers() {
        return repo.findAllByDeletedAtIsNull();
    }
    
    public ResponseEntity<Customer> getCustomerById(Integer id){
    	return ResponseEntity.of(this.repo.findById(id));
    }
    
    public void deleteCustomerById( Integer id) {
    	Customer c = repo.findById(id).orElseThrow();
    	c.setDeletedAt(LocalDateTime.now());
    	this.repo.save(c);
    }
    
    public Customer saveCustomer(Customer customer) {
    	return this.repo.save(customer);
    }
    
    public Customer updateCustomer(Customer customer) {
    	Customer c = this.repo.findById(customer.getId()).orElseThrow();
        c.setFirstName(customer.getFirstName());
        c.setLastName(customer.getLastName());
        c.setEmail(customer.getEmail());
        c.setPhone(customer.getPhone());
        c.setUmcn(customer.getUmcn());
        c.setTaxId(customer.getTaxId());
        c.setUpdatedAt(LocalDateTime.now());
        
        return repo.save(c);
    }

}
