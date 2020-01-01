package guru.springframework.msscbrewery.services;

import java.util.UUID;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerId);

	CustomerDto saveNewCustomer(CustomerDto customerDto);

	void updateCustomer(UUID customerId, BeerDto beerDto);

	void deleteById(UUID customerId);
}
