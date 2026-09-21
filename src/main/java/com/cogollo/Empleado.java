package com.cogollo;

public class Empleado {
    private final String nombre;

    Empleado(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El empleado debe tener nombre");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
