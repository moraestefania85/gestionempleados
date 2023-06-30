package com.example.gestionempleados.controller;

import com.example.gestionempleados.entity.Empleado;
import com.example.gestionempleados.service.EmpleadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmpleadoController.class)
public class EmpleadoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmpleadoService empleadoService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllEmpleados() throws Exception {
        Empleado empleado1 = new Empleado("Alice", "Developer", 1200.00);
        Empleado empleado2 = new Empleado("Bob", "Manager", 2000.00);

        when(empleadoService.getAllEmpleados()).thenReturn(Arrays.asList(empleado1, empleado2));

        mockMvc.perform(get("/api/empleados"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetSalarioTotal() throws Exception {
        when(empleadoService.calcularSalarioTotal()).thenReturn(3200.00);

        mockMvc.perform(get("/api/empleados/salario-total"))
                .andExpect(status().isOk())
                .andExpect(content().string("3200.0"));
    }
}
