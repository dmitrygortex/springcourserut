package org.example.services.impl;

import org.example.dto.ClientDto;
import org.example.entities.Client;
import org.example.repositories.ClientRepository;
import org.example.repositories.impl.ClientRepositoryImpl;
import org.example.services.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepositoryImpl clientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean addClient(ClientDto clientDto) {
        clientRepository.save(modelMapper.map(clientDto, Client.class));
        return true;
    }

    @Override
    public ClientDto findClientById(int id) {
        return modelMapper.map(clientRepository.findById(id).get(), ClientDto.class);
    }


}
