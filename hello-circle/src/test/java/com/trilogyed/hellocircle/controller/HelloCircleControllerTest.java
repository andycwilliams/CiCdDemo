package com.trilogyed.hellocircle.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloCircleController.class)
public class HelloCircleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void shouldReturn200AndSayHello() throws Exception {
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Circle!"));

    }

    @Test
    public void shouldReturn200AndGiveAnswer() throws Exception {
        // Arrange and Act
        mockMvc.perform(get("/answer"))
                .andDo(print())
                .andExpect(status().isOk())

                // Assert
                .andExpect(content().string("The answer is 42!"));
    }
}