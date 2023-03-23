package edu.iu.p565.CustomerService.controller;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import edu.iu.p565.CustomerService.model.Customer;
import edu.iu.p565.CustomerService.repository.CustomerRepository;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerRepository repository;

    public CustomerController(CustomerRepository repository){
        this.repository = repository;
    }
    @GetMapping
    public List<Customer> findaAll(){

        return repository.findAll();
    }
    @PostMapping
    public int create(@Valid @RequestBody Customer customer){

        return repository.create(customer);
    }
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Customer customer, @PathVariable int id){
        repository.update(customer, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.delete(id);
    }

    
}
