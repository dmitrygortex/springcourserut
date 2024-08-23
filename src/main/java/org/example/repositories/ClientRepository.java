package org.example.repositories;

import org.example.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ClientRepository {
    Client findClientByEmail(String email);

    List<Client> findClientsByName(String firstName, String lastName);

    Client findClientByPhoneNumber(String phoneNumber);

    List<Client> findAllClients();
}
