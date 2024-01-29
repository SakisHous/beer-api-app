package gr.aueb.cf.spring6restmvc.mappers;

import gr.aueb.cf.spring6restmvc.entities.Customer;
import gr.aueb.cf.spring6restmvc.model.CustomerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDTO dto);
    CustomerDTO customerToCustomerDto(Customer customer);
}
