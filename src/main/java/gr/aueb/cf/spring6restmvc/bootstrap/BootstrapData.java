package gr.aueb.cf.spring6restmvc.bootstrap;

import gr.aueb.cf.spring6restmvc.entities.Beer;
import gr.aueb.cf.spring6restmvc.entities.Customer;
import gr.aueb.cf.spring6restmvc.model.BeerDTO;
import gr.aueb.cf.spring6restmvc.model.BeerStyle;
import gr.aueb.cf.spring6restmvc.model.CustomerDTO;
import gr.aueb.cf.spring6restmvc.repositories.BeerRepository;
import gr.aueb.cf.spring6restmvc.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BeerRepository beerRepository;
    private final CustomerRepository customerRepository;

    public BootstrapData(BeerRepository beerRepository, CustomerRepository customerRepository) {
        this.beerRepository = beerRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerData();
        loadCustomerData();
    }

    private void loadBeerData() {
        if (beerRepository.count() == 0){
            Beer beer1 = Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12356")
                    .price(new BigDecimal("12.99"))
                    .quantityOnHand(122)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer2 = Beer.builder()
                    .beerName("Crank")
                    .beerStyle(BeerStyle.PALE_ALE)
                    .upc("12356222")
                    .price(new BigDecimal("11.99"))
                    .quantityOnHand(392)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            Beer beer3 = Beer.builder()
                    .beerName("Sunshine City")
                    .beerStyle(BeerStyle.IPA)
                    .upc("12356")
                    .price(new BigDecimal("13.99"))
                    .quantityOnHand(144)
                    .createdDate(LocalDateTime.now())
                    .updateDate(LocalDateTime.now())
                    .build();

            beerRepository.save(beer1);
            beerRepository.save(beer2);
            beerRepository.save(beer3);
        }

    }

    private void loadCustomerData() {

        if (customerRepository.count() == 0) {

            Customer customer1 = Customer.builder()
                    .name("John Doe")
                    .createdDate(LocalDateTime.now())
                    .lastUpdatedDate(LocalDateTime.now())
                    .build();

            Customer customer2 = Customer.builder()
                    .name("Peter Brooks")
                    .createdDate(LocalDateTime.now())
                    .lastUpdatedDate(LocalDateTime.now())
                    .build();

            Customer customer3 = Customer.builder()
                    .name("Tim Lawrence")
                    .createdDate(LocalDateTime.now())
                    .lastUpdatedDate(LocalDateTime.now())
                    .build();

            customerRepository.saveAll(Arrays.asList(customer1, customer2, customer3));
        }

    }
}
