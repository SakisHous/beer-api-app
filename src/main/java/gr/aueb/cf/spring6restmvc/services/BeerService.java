package gr.aueb.cf.spring6restmvc.services;

import gr.aueb.cf.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    Optional<BeerDTO> getBeerById(UUID id);
    List<BeerDTO> listBeers();
    BeerDTO saveNewBeer(BeerDTO beer);
    Optional<BeerDTO> updateBeerById(UUID id, BeerDTO beer);
    void deleteBeerById(UUID beerId);
    void patchBeerById(UUID beerId, BeerDTO beer);
}
