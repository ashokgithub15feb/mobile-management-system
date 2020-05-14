package com.nineleaps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nineleaps.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

}
