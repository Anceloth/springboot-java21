package com.example.api.unit.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.api.application.IUseCase;
import com.example.api.infra.CalculateController;

@WebMvcTest(CalculateController.class)
public class CalculateControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUseCase useCase;

    @Test
    void testejecutar_Case1() throws Exception {
        when(useCase.ejecutar(7, 5, 12345)).thenReturn(12339);
        mockMvc.perform(get("/calculate")
                .param("x", "7")
                .param("y", "5")
                .param("n", "12345"))
                .andExpect(status().isOk())
                .andExpect(content().string("12339"));
    }

    @Test
    void testejecutar_Case2() throws Exception {
        when(useCase.ejecutar(5, 0, 4)).thenReturn(0);
        mockMvc.perform(get("/calculate")
                .param("x", "5")
                .param("y", "0")
                .param("n", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
    }

    @Test
    void testejecutar_Case3() throws Exception {
        when(useCase.ejecutar(10, 5, 15)).thenReturn(15);
        mockMvc.perform(get("/calculate")
                .param("x", "10")
                .param("y", "5")
                .param("n", "15"))
                .andExpect(status().isOk())
                .andExpect(content().string("15"));
    }

    @Test
    void testejecutar_Case4() throws Exception {
        when(useCase.ejecutar(17, 8, 54321)).thenReturn(54306);
        mockMvc.perform(get("/calculate")
                .param("x", "17")
                .param("y", "8")
                .param("n", "54321"))
                .andExpect(status().isOk())
                .andExpect(content().string("54306"));
    }

    @Test
    void testejecutar_Case5() throws Exception {
        when(useCase.ejecutar(499999993, 9, 1000000000)).thenReturn(999999995);
        mockMvc.perform(get("/calculate")
                .param("x", "499999993")
                .param("y", "9")
                .param("n", "1000000000"))
                .andExpect(status().isOk())
                .andExpect(content().string("999999995"));
    }

    @Test
    void testejecutar_Case6() throws Exception {
        when(useCase.ejecutar(10, 5, 187)).thenReturn(185);
        mockMvc.perform(get("/calculate")
                .param("x", "10")
                .param("y", "5")
                .param("n", "187"))
                .andExpect(status().isOk())
                .andExpect(content().string("185"));
    }

    @Test
    void testejecutar_Case7() throws Exception {
        when(useCase.ejecutar(2, 0, 999999999)).thenReturn(999999998);
        mockMvc.perform(get("/calculate")
                .param("x", "2")
                .param("y", "0")
                .param("n", "999999999"))
                .andExpect(status().isOk())
                .andExpect(content().string("999999998"));
    }
    
    @Test
    void testValidation_xMenorQue2() throws Exception {
        // x = 1 (debe fallar porque x < 2)
        mockMvc.perform(get("/calculate")
                .param("x", "1")
                .param("y", "0")
                .param("n", "10"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testValidation_yNoMenorQuex() throws Exception {
        // y = 5, x = 5 (debe fallar porque y < x no se cumple)
        mockMvc.perform(get("/calculate")
                .param("x", "5")
                .param("y", "5")
                .param("n", "10"))
                .andExpect(status().isBadRequest());
    }
}
