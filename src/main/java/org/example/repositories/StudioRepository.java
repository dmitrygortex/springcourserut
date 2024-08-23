package org.example.repositories;

import org.example.entities.Studio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface StudioRepository {

    List<Studio> findStudiosByName(String name);

    List<Studio> findStudiosByAddress( String address);

    List<Studio> findStudiosByRentFee( Integer rentFee);

    List<Studio> findAllStudios();
}
