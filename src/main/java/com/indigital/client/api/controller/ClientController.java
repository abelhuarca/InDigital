package com.indigital.client.api.controller;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indigital.client.api.model.Client;
import com.indigital.client.api.model.ClientRequest;
import com.indigital.client.service.ClientService;
import com.indigital.client.util.JacksonUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ClientController {

    private ClientService clientService;

    @PostMapping("/client")
    @ApiOperation(
            value = "Create client into data base",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = ResponseEntity.class,
            httpMethod = "POST"
    )
    @ApiResponses({
            @ApiResponse(code = 202, message = "The client was successfully created")}
    )
    public ResponseEntity create(@Valid @RequestBody ClientRequest client) {
        log.info("request: {} ", JacksonUtils.getObjectAsString(client));
        clientService.createClient(client);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/client/kpi")
    @ApiOperation(
            value = "Show the average age of registered customers and the standard deviation.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = ResponseEntity.class,
            httpMethod = "GET"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Client information was successfully processed")}
    )
    public ResponseEntity getClientsKpi() {
        return ResponseEntity.ok(clientService.getClientsKpi());
    }

    @GetMapping("/clients")
    @ApiOperation(
            value = "Show all registered customers including the probable date of death..",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = ResponseEntity.class,
            httpMethod = "GET"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Client information was successfully processed")}
    )
    public ResponseEntity getClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }


}
