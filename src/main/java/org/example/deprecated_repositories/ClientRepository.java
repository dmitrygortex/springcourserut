package org.example.deprecated_repositories;

import org.example.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT c FROM Client c WHERE c.email = :email")
    Client findClientByEmail(@Param("email") String email);

    @Query("SELECT c FROM Client c WHERE c.firstName LIKE %:firstName% AND c.lastName LIKE %:lastName%")
    List<Client> findClientsByName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT c FROM Client c WHERE c.phoneNumber = :phoneNumber")
    Client findClientByPhoneNumber(@Param("phoneNumber") String phoneNumber);

    @Query("SELECT c FROM Client c")
    List<Client> findAllClients();

}
