package lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices.model.Country;

@SpringBootApplication
@RestController
public class PearsonSpringbootCrudRestwebservicesApplication {
	
	@GetMapping("/findAllCountries")
	public List<Country> getCountries(){
		return null;
		
		
	}
	

	public static void main(String[] args) {
		SpringApplication.run(PearsonSpringbootCrudRestwebservicesApplication.class, args);
	}

}
