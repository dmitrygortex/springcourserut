package org.example.repositories.impl;

import jakarta.persistence.TypedQuery;
import org.example.entities.Client;
import org.example.repositories.ClientRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepositoryImpl extends BaseRepositoryImpl<Client> implements ClientRepository {

    public ClientRepositoryImpl() {
        super(Client.class);
    }

    @Override
    public Client findClientByEmail(String email) {
        TypedQuery<Client> query = entityManager.createQuery(
                "SELECT c FROM Client c WHERE c.email = :email AND c.isDeleted = false", Client.class);
        query.setParameter("email", email);
        return query.getSingleResult();
    }

    @Override
    public List<Client> findClientsByName(String firstName, String lastName) {
        TypedQuery<Client> query = entityManager.createQuery(
                "SELECT c FROM Client c WHERE c.firstName = :firstName AND c.lastName = :lastName AND c.isDeleted = false", Client.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

    @Override
    public Client findClientByPhoneNumber(String phoneNumber) {
        TypedQuery<Client> query = entityManager.createQuery(
                "SELECT c FROM Client c WHERE c.phoneNumber = :phoneNumber AND c.isDeleted = false", Client.class);
        query.setParameter("phoneNumber", phoneNumber);
        return query.getSingleResult();
    }

    @Override
    public List<Client> findAllClients() {
        TypedQuery<Client> query = entityManager.createQuery(
                "SELECT c FROM Client c WHERE c.isDeleted = false", Client.class);
        return query.getResultList();
    }
}
