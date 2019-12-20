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

    @PostMapping("/cliente")
    @ApiOperation(
            value = "Crea un cliente en la base de datos.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = ResponseEntity.class,
            httpMethod = "POST",
            notes = "classpath:swagger/notes/create-client.md"
    )
    @ApiResponses({
            @ApiResponse(code = 202, message = "El cliete se creo manera exitosa")}
    )
    public ResponseEntity create(@Valid @RequestBody Client client) {
        log.info("request: {} ", JacksonUtils.getObjectAsString(client));
        clientService.createClient(client);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/cliente/kpi")
    @ApiOperation(
            value = "Obtiene el promedio de edades de los cliente registrados incluyendo la desviacion estandar.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = ResponseEntity.class,
            httpMethod = "GET",
            notes = "classpath:swagger/notes/kpi-client.md"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Se procesaron los datos del cliente de manera exitosa")}
    )
    public ResponseEntity getClientsKpi() {
        return ResponseEntity.ok(clientService.getClientsKpi());
    }

    @GetMapping("/cliente")
    @ApiOperation(
            value = "Obtiene todos los clientes registrados incluyendo la fecha probacle de muerte.",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            response = ResponseEntity.class,
            httpMethod = "GET",
            notes = "classpath:swagger/notes/retrieve-client.md"
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "-")}
    )
    public ResponseEntity getClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }


}
