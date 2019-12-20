package com.indigital.client.service.impl;

import static com.indigital.client.util.WiremockUtil.obtainResource;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indigital.client.BaseSpringTest;
import com.indigital.client.api.model.Client;
import com.indigital.client.config.ApplicationProperties;
import com.indigital.client.entity.ClientEntity;
import com.indigital.client.repository.ClientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientServiceImplTest extends BaseSpringTest {

    @InjectMocks
    private ClientServiceImpl clientService;

    @Mock
    private ClientRepository clientRepositoryMock;

    @Mock
    private ApplicationProperties appPropertiesMock;

    @Autowired
    private ApplicationProperties appProperties;

    @Before
    public void load() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createClient() throws Exception {
        when(appPropertiesMock.getLifeExpectancyMan()).thenReturn(Math.toIntExact(63));
        when(clientRepositoryMock.save(new ClientEntity())).thenReturn(new ClientEntity());
        clientService.createClient(getClient());
    }

    @Test
    public void getAllClients() throws Exception {
        when(clientRepositoryMock.findAll()).thenReturn(getClientEntity());
        clientService.getAllClients();
    }

    @Test
    public void getClientsKpi() throws Exception {
        when(clientRepositoryMock.findAll()).thenReturn(getClientEntity());
        clientService.getClientsKpi();
    }

    private Client getClient() throws IOException {
        return new ObjectMapper().readValue(obtainResource("json/client_mock.json"), Client.class);
    }

    private List<ClientEntity> getClientEntity() {
        List<ClientEntity> ls = new ArrayList<>();
        ls.add(createClientEntity("Juan", "Perez", 23));
        ls.add(createClientEntity("Jorge", "Perez", 34));
        return ls;
    }

    private ClientEntity createClientEntity(String firstName, String lastName, int age) {
    	ClientEntity clients = ClientEntity.builder()
                .id(UUID.randomUUID())
                .firstName(firstName)
                .lastName(lastName)
                .birthDate(new Date()).build();
        log.info("object client: {} ", clients.toString());
        return clients;
    }

}
