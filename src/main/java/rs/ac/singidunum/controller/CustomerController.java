package rs.ac.singidunum.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.singidunum.entity.Customer;
import rs.ac.singidunum.service.CustomerService;

import java.util.List;


@RestController
@RequestMapping(path = "/api/customer")
@CrossOrigin
@RequiredArgsConstructor
public class CustomerController {
	
	private final CustomerService service;

    @GetMapping
    public List<Customer> getCustomers() {
        return service.getCustomers();
    }
    
    @GetMapping(path = "/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id){
    	return this.service.getCustomerById(id);
    }
    
    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomerById(@PathVariable Integer id) {
    	this.service.deleteCustomerById(id);
    }
    
    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
    	return this.service.saveCustomer(customer);
    }
    
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.updateCustomer(customer));
    }

}