package gr.aueb.cf.spring6restmvc.mappers;

import gr.aueb.cf.spring6restmvc.entities.Beer;
import gr.aueb.cf.spring6restmvc.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDTO dto);
    BeerDTO beerToBeerDto(Beer beer);
}
