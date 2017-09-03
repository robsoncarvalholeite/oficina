package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.Customer;

/**
 * Created by robson on 03/09/17.
 */
public interface CustomerRepository extends GenericCrudRepository<Customer>, CustomCrudRepository<Customer, Long> {
}
