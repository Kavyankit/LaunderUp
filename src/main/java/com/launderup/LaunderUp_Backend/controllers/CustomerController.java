package com.launderup.LaunderUp_Backend.controllers;

import com.launderup.LaunderUp_Backend.models.Customer;
import com.launderup.LaunderUp_Backend.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/{id}")
    public Mono<Customer> getCustomerById(@PathVariable Long id){
        return customerRepository.findById(id);
    }

    @GetMapping
    public Flux<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Mono<Customer> createCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customerDetails){
        return customerRepository.findById(id).flatMap(existingCustomer -> {
                    existingCustomer.setFirstname(customerDetails.getFirstname());
                    existingCustomer.setLastname(customerDetails.getLastname());
                    return customerRepository.save(existingCustomer);
        });
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCustomer(@PathVariable Long id) {
        return customerRepository.deleteById(id);
    }
}
