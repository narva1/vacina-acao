package br.com.vaptzupt.vacinacao.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ClientController.class)
class ClientControllerIntTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void test() throws Exception {
        // VERBOSE WAY
//        RequestBuilder req = get("/test");
//
//        MvcResult res = mockMvc
//            .perform(req)
//            .andReturn();
//
//        assertEquals("Hello world!", res.getResponse().getContentAsString());

        // SUCCINCT WAY
        mockMvc
            .perform(get("/test"))
            .andExpect(content().string("Hello world!"));

    }

    @Test
    void testWithName() throws Exception {
        mockMvc
            .perform(get("/test?name=Diogo"))
            .andExpect(
                content()
                    .string("Hello Diogo")
            );
    }
}