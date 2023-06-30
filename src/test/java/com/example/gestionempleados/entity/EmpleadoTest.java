package com.example.gestionempleados.entity;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmpleadoTest {

    @Test
    public void testEmpleado() {
        Empleado empleado = new Empleado();
        empleado.setNombre("John Doe");
        empleado.setCargo("Developer");
        empleado.setSalario(1000.00);

        assertEquals("John Doe", empleado.getNombre());
        assertEquals("Developer", empleado.getCargo());
        assertEquals(1000.00, empleado.getSalario());
    }
}
