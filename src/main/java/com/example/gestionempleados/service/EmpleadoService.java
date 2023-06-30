package com.example.gestionempleados.service;

import com.example.gestionempleados.entity.Empleado;
import java.util.List;

public interface EmpleadoService {

    Empleado saveEmpleado(Empleado empleado);

    List<Empleado> getAllEmpleados();

    Double calcularSalarioTotal();

}