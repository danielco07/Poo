package com.cogollo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Hu05EmpleadoTest {
    @Test
    void soloElPropietarioCreaEmpleados() {
        var propietario = new Propietario("Daniel");

        var empleado = propietario.crearEmpleado("Carlos");

        assertEquals("Carlos", empleado.getNombre());
        assertEquals(1, propietario.getEmpleados().size());
    }
}
