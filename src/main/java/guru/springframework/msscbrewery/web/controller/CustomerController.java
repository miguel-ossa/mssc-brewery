package guru.springframework.msscbrewery.web.controller;

import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import guru.springframework.msscbrewery.services.CustomerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;
    
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){

        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping // POST create a new beer
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto) {
    	
		CustomerDto savedDto = customerService.saveNewCustomer(customerDto);
    	
    	HttpHeaders headers = new HttpHeaders();
    	//TODO: add hostname to url
    	headers.add("Location", "/api/v1/customer/" + savedDto.getId().toString());
    	
    	return new ResponseEntity(headers, HttpStatus.CREATED);
    }
	
	@SuppressWarnings("rawtypes")
	@PutMapping({"/{customerId}"})
	public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, @RequestBody BeerDto beerDto) {
		
		customerService.updateCustomer(customerId, beerDto);
		
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping({"/{customerId}"})
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable("customerId") UUID customerId) {
		
		customerService.deleteById(customerId);
	}
}
