package com.cogollo;

import java.util.ArrayList;
import java.util.List;

public class Propietario {
    private final String nombre;
    private final List<Empleado> empleados = new ArrayList<>();

    public Propietario(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El propietario debe tener nombre");
        }
        this.nombre = nombre;
    }

    public Empleado crearEmpleado(String nombreEmpleado) {
        var empleado = new Empleado(nombreEmpleado);
        empleados.add(empleado);
        return empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return List.copyOf(empleados);
    }
}
