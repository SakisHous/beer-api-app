package gr.aueb.cf.spring6restmvc.controller;

import gr.aueb.cf.spring6restmvc.model.BeerDTO;
import gr.aueb.cf.spring6restmvc.services.BeerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class BeerController {
    public static final String BEER_PATH = "/api/v1/beer";
    public static final String BEER_PATH_ID = BEER_PATH + "/{beerId}";

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @RequestMapping(value = BEER_PATH, method = RequestMethod.GET)
    public List<BeerDTO> listBeers() {
        return beerService.listBeers();
    }

    @RequestMapping(value = BEER_PATH_ID, method = RequestMethod.GET)
    public BeerDTO getBeerById(@PathVariable("beerId") UUID beerId) {
        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }

    @PostMapping(value = BEER_PATH)
    public ResponseEntity insertBeer(@RequestBody BeerDTO beerDTO) {
        BeerDTO savedBeer = beerService.saveNewBeer(beerDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beerDTO/" + savedBeer.getId());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO) {

        beerService.updateBeerById(beerId, beerDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(BEER_PATH_ID)
    public ResponseEntity deleteBeer(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeerById(beerId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PatchMapping(BEER_PATH_ID)
    public ResponseEntity updateBeerPatch(@PathVariable("beerId") UUID beerId, @RequestBody BeerDTO beerDTO) {
        beerService.patchBeerById(beerId, beerDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
