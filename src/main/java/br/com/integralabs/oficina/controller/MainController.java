package br.com.integralabs.oficina.controller;


import br.com.integralabs.oficina.model.Customer;
import br.com.integralabs.oficina.repo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.UUID;

/**
 * Created by robson on 16/08/17.
 */
@RestController
public class MainController extends GenericController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/ping")
    public String ping() {
        LOGGER.info("Ping Request detected.");
        return String.format("now: %s, UUID: %s", Calendar.getInstance().getTime(), UUID.randomUUID().toString());
    }

    @GetMapping("/test")
    public Customer createCustomer (){
        return this.customerRepository.save(new Customer().setName(UUID.randomUUID().toString()));
    }
}
