package com.indigital.client.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indigital.client.entity.ClientEntity;


@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, UUID>{

}
