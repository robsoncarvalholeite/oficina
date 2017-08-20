package br.com.integralabs.oficina.repo;

import br.com.integralabs.oficina.model.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by a.moreira.rodrigues on 19/08/2017.
 */
public interface CustomerRepository extends BaseCrudRepository<Customer, Long>{
}
