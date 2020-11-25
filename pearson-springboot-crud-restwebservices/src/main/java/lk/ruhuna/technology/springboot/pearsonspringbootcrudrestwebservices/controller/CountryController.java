package lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices.exception.ResourceNotFoundException;
import lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices.model.Country;
import lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices.repository.CountryRepository;

@RestController
public class CountryController {
	@Autowired
	
	private CountryRepository countryRepository;
	
	//create get all countries api
	@GetMapping("/countries")
	public List<Country>getAllCountries(){
		return countryRepository.findAll();
	}
	
	// add country
	@PostMapping("/countries")
	public Country addCountry(Country country) {
		return countryRepository.save(country);
	}
	
	// get country by id
	@GetMapping("countries/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable(value = "id")long countryId) throws ResourceNotFoundException{
		Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("country not found for this id ::"+countryId));
		return ResponseEntity.ok().body(country);
	}
	
	// update country
	@PutMapping("/countries/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable(value = "id")long countryId, @RequestBody Country countryDetails) throws ResourceNotFoundException {
		Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("country not found for this id ::"+countryId));
		country.setCountryName(countryDetails.getCountryName());
		countryRepository.save(country);
		return ResponseEntity.ok().body(country);
		
	}
	
	// delete country
	
	@DeleteMapping("/countries/{id}")
	public ResponseEntity<?> deleteCountry(@PathVariable(value = "id")long countryId) throws ResourceNotFoundException {
		Country country = countryRepository.findById(countryId).orElseThrow(() -> new ResourceNotFoundException("country not found for this id ::"+countryId));
		countryRepository.deleteById(countryId);
		return ResponseEntity.ok().build();
	}
	
	
}
