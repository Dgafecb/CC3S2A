package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {
    private Address address = new Address("street A");
    private Address secondAdress = new Address("street B");
    private Client client;
    @BeforeEach
    void setUp(){
        client = new Client();
        // client.setSomePropertiesIfNeeded();
    }
    @Test
    void afterCreationShouldHaveNoAddress(){
       //assert that client has no addresses

    }
    @Test
    void shouldAllowToAddAddress(){
        client.addAddress(address);
    }
    @Test
    void shouldAllowToAddManyAddresses(){
        client.addAddress(address);
        client.addAddress(secondAdress);
        //assert that client has two addresses
    }
}