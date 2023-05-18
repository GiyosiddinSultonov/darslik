package uz.najottalim.demospringjdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.najottalim.demospringjdbc.dao.Customer;
import uz.najottalim.demospringjdbc.dao.CustomerDAO;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerDAO customerDAO;

    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerDAO.findAll();
    }

    @GetMapping("/id/{id}")
    public Customer getById(@PathVariable Integer id){
        return customerDAO.findById(id);
    }
}

