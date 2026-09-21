package com.cogollo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertSame;

class Hu03PlatoTest {
    @Test
    void todoPlatoDebeEstarAsociadoAUnRestaurante() {
        var propietario = new Propietario("Daniel");

        assertThrows(IllegalArgumentException.class,
            () -> new Plato("Hamburguesa", 18000, "Con queso", null));
    }

    @Test
    void platoGuardaElRestauranteAsociado() {
        var propietario = new Propietario("Daniel");
        var restaurante = new Restaurante("Restaurante Central", propietario);
        var plato = new Plato("Hamburguesa", 18000, "Con queso", restaurante);

        assertSame(restaurante, plato.getRestaurante());
    }
}
