package com.example.gestionempleados.service.implement;

import com.example.gestionempleados.entity.Empleado;
import com.example.gestionempleados.repository.EmpleadoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmpleadoServiceImplTest {

    @Mock
    private EmpleadoRepository empleadoRepository;

    @InjectMocks
    private EmpleadoServiceImpl empleadoService;

    @Test
    public void testGetAllEmpleados() {
        Empleado empleado1 = new Empleado("Alice", "Developer", 1200.00);
        Empleado empleado2 = new Empleado("Bob", "Manager", 2000.00);

        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado1, empleado2));

        List<Empleado> empleados = empleadoService.getAllEmpleados();

        assertEquals(2, empleados.size());
        assertEquals("Alice", empleados.get(0).getNombre());
        assertEquals("Bob", empleados.get(1).getNombre());
    }

    @Test
    public void testCalcularSalarioTotal() {
        Empleado empleado1 = new Empleado("Alice", "Developer", 1200.00);
        Empleado empleado2 = new Empleado("Bob", "Manager", 2000.00);

        when(empleadoRepository.findAll()).thenReturn(Arrays.asList(empleado1, empleado2));

        Double salarioTotal = empleadoService.calcularSalarioTotal();

        assertEquals(3200.00, salarioTotal);
    }
}
