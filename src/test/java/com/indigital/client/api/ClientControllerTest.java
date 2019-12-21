package com.indigital.client.api;

import static com.indigital.client.util.WiremockUtil.obtainResource;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.indigital.client.BaseMockMvcTest;
import com.indigital.client.api.model.Client;
import com.indigital.client.api.model.StatisticsClient;
import com.indigital.client.service.ClientService;

public class ClientControllerTest extends BaseMockMvcTest {

    public static final String URL_ENDPOINT_CREATE_CLIENT = "/api/client";
    public static final String URL_ENDPOINT_GET_CLIENT_KPI = "/api/client/kpi";
    public static final String URL_ENDPOINT_GET_ALL_CLIENTS = "/api/clients";

    @MockBean
    private ClientService clientService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createClient() throws Exception {
        doNothing().when(clientService).createClient(any());
        mvc.perform(post(URL_ENDPOINT_CREATE_CLIENT)
                .content(obtainResource("json/client_mock.json"))
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    @Test
    public void getClientKPI() throws Exception {
        when(clientService.getClientsKpi()).thenReturn(StatisticsClient.builder()
                .standardDeviationAge(1.00)
                .averageAge(1.00).build());
        mvc.perform(get(URL_ENDPOINT_GET_CLIENT_KPI)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void obtainsAllClientsProbableDateDeath() throws Exception {
        when(clientService.getAllClients()).thenReturn(getAllClients());
        mvc.perform(get(URL_ENDPOINT_GET_ALL_CLIENTS)
                .contentType(APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public List<Client> getAllClients() {
        return new ArrayList<>();
    }

}
