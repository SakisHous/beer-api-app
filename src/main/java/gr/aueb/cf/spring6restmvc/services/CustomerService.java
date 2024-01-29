package gr.aueb.cf.spring6restmvc.services;

import gr.aueb.cf.spring6restmvc.model.CustomerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<CustomerDTO> listCustomers();
    Optional<CustomerDTO> getCustomerById(UUID id);
    CustomerDTO saveNewCustomer(CustomerDTO customer);
    void updateCustomerById(UUID customerId, CustomerDTO customer);
    void deleteCustomerById(UUID customerId);
    void updateCustomerPatchById(UUID customerId, CustomerDTO customer);
}
