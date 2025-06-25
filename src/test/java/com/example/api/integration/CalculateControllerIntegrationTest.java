package com.example.api.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CalculateControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCalculate_Case1() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("x", "7")
                .param("y", "5")
                .param("n", "12345"))
                .andExpect(status().isOk())
                .andExpect(content().string("12339"));
    }

    @Test
    void testCalculate_Case2() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("x", "5")
                .param("y", "0")
                .param("n", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void testCalculate_Case3() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("x", "10")
                .param("y", "5")
                .param("n", "15"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }

    @Test
    void testCalculate_Case4() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("x", "17")
                .param("y", "8")
                .param("n", "54321"))
                .andExpect(status().isOk())
                .andExpect(content().string("54306"));
    }

    @Test
    void testCalculate_Case5() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("x", "499999993")
                .param("y", "9")
                .param("n", "1000000000"))
                .andExpect(status().isOk())
                .andExpect(content().string("999999995"));
    }

    @Test
    void testCalculate_Case6() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("x", "10")
                .param("y", "5")
                .param("n", "187"))
                .andExpect(status().isOk())
                .andExpect(content().string("185"));
    }

    @Test
    void testCalculate_Case7() throws Exception {
        mockMvc.perform(get("/calculate")
                .param("x", "2")
                .param("y", "0")
                .param("n", "999999999"))
                .andExpect(status().isOk())
                .andExpect(content().string("999999998"));
    }
}
