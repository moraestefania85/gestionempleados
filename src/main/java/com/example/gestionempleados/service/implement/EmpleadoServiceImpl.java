package com.example.gestionempleados.service.implement;

import com.example.gestionempleados.entity.Empleado;
import com.example.gestionempleados.repository.EmpleadoRepository;
import com.example.gestionempleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Double calcularSalarioTotal() {
        return empleadoRepository.findAll().stream()
                .mapToDouble(Empleado::getSalario)
                .sum();
    }
}
