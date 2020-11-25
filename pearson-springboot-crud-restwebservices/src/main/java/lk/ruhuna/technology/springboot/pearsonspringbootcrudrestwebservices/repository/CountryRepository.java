package lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lk.ruhuna.technology.springboot.pearsonspringbootcrudrestwebservices.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

}
