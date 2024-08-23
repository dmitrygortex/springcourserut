package org.example.repositories;

import org.example.entities.Facility;

import java.util.List;

public interface FacilityRepository {

    List<Facility> findFacilitiesByName(String name);

    List<Facility> findFacilitiesByPriceRange(Integer minPrice, Integer maxPrice);

    List<Facility> findAllFacilities();
}