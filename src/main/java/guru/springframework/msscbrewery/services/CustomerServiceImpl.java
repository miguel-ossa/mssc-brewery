package guru.springframework.msscbrewery.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import guru.springframework.msscbrewery.web.model.BeerDto;
import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{
    @Override
    public CustomerDto getCustomerById(UUID customerId) {
        return CustomerDto.builder().id(UUID.randomUUID())
                .customerName("John Pale")
                .build();
    }

	@Override
	public CustomerDto saveNewCustomer(CustomerDto customerDto) {
		return CustomerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateCustomer(UUID customerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(UUID customerId) {
		
		log.debug("Deleting a customer...");
	}
}
