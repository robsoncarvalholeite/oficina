package br.com.integralabs.oficina.service;

import br.com.integralabs.oficina.model.Customer;
import br.com.integralabs.oficina.service.generic.GenericService;

/**
 * Created by robson on 03/09/17.
 */
public interface CustomerService extends GenericService<Customer> {
    public static final String BEAN_NAME = "customerService";
}
