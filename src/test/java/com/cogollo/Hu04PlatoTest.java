package com.cogollo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class Hu04PlatoTest {
    @Test
    void soloSeModificanPrecioYDescripcion() {
        var propietario = new Propietario("Daniel");
        var restaurante = new Restaurante("Restaurante Central", propietario);
        var plato = new Plato("Hamburguesa", 18000, "Con queso", restaurante);

        plato.modificarPrecioYDescripcion(22000, "Con queso y tocineta");

        assertEquals("Hamburguesa", plato.getNombre());
        assertEquals(22000, plato.getPrecio());
        assertEquals("Con queso y tocineta", plato.getDescripcion());
        assertSame(restaurante, plato.getRestaurante());
    }
}
