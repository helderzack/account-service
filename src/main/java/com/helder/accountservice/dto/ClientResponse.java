package com.helder.accountservice.dto;

import com.helder.accountservice.model.Client;

public record ClientResponse(Long id, String name) {
    public static ClientResponse from(Client client) {
        return new ClientResponse(client.getId(), client.getName());
    }
}