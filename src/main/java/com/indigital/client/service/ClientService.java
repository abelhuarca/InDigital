package com.indigital.client.service;


import java.util.List;

import com.indigital.client.api.model.Client;
import com.indigital.client.api.model.StatisticsClient;

public interface ClientService {

    void createClient(Client client);

    List<Client> getAllClients();

    StatisticsClient getClientsKpi();

}
