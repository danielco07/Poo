package com.cogollo;

public class Plato {
    private final String nombre;
    private int precio;
    private String descripcion;
    private final Restaurante restaurante;

    public Plato(String nombre, int precio, String descripcion, Restaurante restaurante) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El plato debe tener nombre");
        }
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        if (descripcion == null || descripcion.isBlank()) {
            throw new IllegalArgumentException("El plato debe tener descripcion");
        }
        if (restaurante == null) {
            throw new IllegalArgumentException("Todo plato debe estar asociado a un restaurante");
        }
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.restaurante = restaurante;
    }

    public void modificarPrecioYDescripcion(int nuevoPrecio, String nuevaDescripcion) {
        if (nuevoPrecio <= 0) {
            throw new IllegalArgumentException("El precio debe ser positivo");
        }
        if (nuevaDescripcion == null || nuevaDescripcion.isBlank()) {
            throw new IllegalArgumentException("La descripcion es obligatoria");
        }
        this.precio = nuevoPrecio;
        this.descripcion = nuevaDescripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }
}
