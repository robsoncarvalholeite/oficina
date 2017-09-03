package br.com.integralabs.oficina.controller.crud;

import br.com.integralabs.oficina.controller.generic.impl.GenericCRUDControllerImpl;
import br.com.integralabs.oficina.model.Customer;
import br.com.integralabs.oficina.service.CustomerService;
import br.com.integralabs.oficina.service.generic.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by robson on 02/09/17.
 */
@RestController
@RequestMapping("/customers")
public class CustomerCRUDController extends GenericCRUDControllerImpl<Customer> {

    @Autowired
    private CustomerService customerService;

    @Override
    protected GenericService getService() {
        return this.customerService;
    }
}
