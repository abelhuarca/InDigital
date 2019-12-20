package com.indigital.client.service.impl;

import static com.indigital.client.constant.Constants.DATE_FORMAT;
import static com.indigital.client.util.DateUtils.formatDate;
import static com.indigital.client.util.DateUtils.getStringFromDate;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.indigital.client.api.model.Client;
import com.indigital.client.api.model.StatisticsClient;
import com.indigital.client.entity.ClientEntity;
import com.indigital.client.repository.ClientRepository;
import com.indigital.client.service.ClientService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public void createClient(Client client) {
        clientRepository.save(
                ClientEntity.builder()
                        .id(UUID.randomUUID())
                        .firstName(client.getName())
                        .lastName(client.getLastName())
                        .birthDate(formatDate(DATE_FORMAT, client.getBirthDate()))
                        .build());
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll()
                .stream()
                .map(cli -> Client.builder()
                        .name(cli.getFirstName())
                        .lastName(cli.getLastName())
                        .birthDate(getStringFromDate(DATE_FORMAT, cli.getBirthDate()))
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public StatisticsClient getClientsKpi() {
        List<ClientEntity> clients = clientRepository.findAll();
        return StatisticsClient
                .builder()
                .averageAge(
                        clients.stream()
                                .mapToInt(cli -> 12)
                                .average().getAsDouble())
                .standardDeviationAge(
                        calculateStandardDeviationFromList(
                                clients.stream()
                                        .mapToDouble(cli -> 12)
                                        .boxed()
                                        .collect(Collectors.toList()))
                ).build();
    }

    public double calculateStandardDeviationFromList(List<Double> ageClientList) {
        return Math.sqrt(
                ageClientList
                        .stream()
                        .reduce(0.0, (a, b) -> a + Math.pow(b - (
                                ageClientList
                                        .stream()
                                        .reduce(0.0, Double::sum) / ageClientList.size()), 2)
                        ) / ageClientList.size());
    }

}



