package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReservaValidacionTest {
    ReservaValidacion reservaValidacion;

    @BeforeEach
    public void configurarPruebas(){
        System.out.println("Se esta ejecutando la prueba");
        this.reservaValidacion = new ReservaValidacion();
    }

    @Test
    public void formatoFechaIncorrecto(){
        //preparo pongo la semilla
        String prueba = "11-22-2023";
        //ejecuto
        Exception respuesta = Assertions.assertThrows(Exception.class, ()-> this.reservaValidacion.validarFechaRes(prueba));
        Assertions.assertEquals(Mensaje.FORMATO_FECHA.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void formatoFechaCorrecto(){
        //preparo pongo la semmilla
        String prueba = "10-02-2023";
        //ejecuto
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.reservaValidacion.validarFechaRes(prueba));
        Assertions.assertTrue(respuesta);
    }


    @Test
    public void personasReservaIncorrecto(){
        String prueba = "30";
        Exception respuesta = Assertions.assertThrows(Exception.class,()-> this.reservaValidacion.validarNumeroPer(prueba));
        Assertions.assertEquals(Mensaje.CANTIDAD_PERSONAS_RESERVA.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void personasReservaCorrecto(){
        String prueba = "2";
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.reservaValidacion.validarNumeroPer(prueba));
        Assertions.assertTrue(respuesta);
    }

}