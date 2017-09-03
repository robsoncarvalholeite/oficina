package br.com.integralabs.oficina.service.impl;

import br.com.integralabs.oficina.model.Customer;
import br.com.integralabs.oficina.repo.CustomerRepository;
import br.com.integralabs.oficina.repo.GenericCrudRepository;
import br.com.integralabs.oficina.service.CustomerService;
import br.com.integralabs.oficina.service.generic.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by robson on 03/09/17.
 */
@Component(CustomerService.BEAN_NAME)
public class CustomerServiceImpl extends GenericServiceImpl<Customer> implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    protected GenericCrudRepository getCrudRepository() {
        return this.customerRepository;
    }

    @Override
    protected void validateCreate(Customer customer) {
        super.validateCreate(customer);
        if (Objects.isNull(customer.getName())) throw new IllegalArgumentException("O name é Obrigatório");
    }

    @Override
    protected void validateUpdate(Customer customer) {
        super.validateUpdate(customer);
        this.validateCreate(customer);
    }
}
