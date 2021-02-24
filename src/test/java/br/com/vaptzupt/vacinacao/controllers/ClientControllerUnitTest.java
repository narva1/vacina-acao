package br.com.vaptzupt.vacinacao.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ClientControllerUnitTest {

    @Test
    void test() {
        ClientController cc = new ClientController();

        assertEquals("Hello Diogo", cc.test("Diogo"));
    }

}