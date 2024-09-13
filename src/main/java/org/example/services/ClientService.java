package org.example.services;


import org.example.dto.ClientDto;
import org.example.entities.Client;


public interface ClientService {

    public boolean addClient(ClientDto clientDto);

    ClientDto findClientById(int id);

}
