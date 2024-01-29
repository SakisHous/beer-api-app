package gr.aueb.cf.spring6restmvc.mappers;

import gr.aueb.cf.spring6restmvc.entities.Customer;
import gr.aueb.cf.spring6restmvc.model.CustomerDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-29T22:35:34+0200",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.9 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDtoToCustomer(CustomerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( dto.getId() );
        customer.name( dto.getName() );
        customer.version( dto.getVersion() );
        customer.createdDate( dto.getCreatedDate() );
        customer.lastUpdatedDate( dto.getLastUpdatedDate() );

        return customer.build();
    }

    @Override
    public CustomerDTO customerToCustomerDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO.CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.name( customer.getName() );
        customerDTO.version( customer.getVersion() );
        customerDTO.createdDate( customer.getCreatedDate() );
        customerDTO.lastUpdatedDate( customer.getLastUpdatedDate() );

        return customerDTO.build();
    }
}
