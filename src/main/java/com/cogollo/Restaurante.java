package com.cogollo;

public class Restaurante {
    private final String nombre;
    private final Propietario propietario;

    public Restaurante(String nombre, Propietario propietario) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El restaurante debe tener nombre");
        }
        if (propietario == null) {
            throw new IllegalArgumentException("El restaurante debe tener propietario");
        }
        this.nombre = nombre;
        this.propietario = propietario;
    }

    public String getNombre() {
        return nombre;
    }

    public Propietario getPropietario() {
        return propietario;
    }
}
