package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalValidacionTest {
    LocalValidacion localValidacion;

    @BeforeEach
    public void configurarPruebas(){
        System.out.println("Estoy ejecutando la prueba");
        this.localValidacion = new LocalValidacion();
    }


    @Test
    public void validarNitConMasDeDiezDigitos(){
        String nitPrueba = "12345678910";
        Exception respuesta = Assertions.assertThrows(Exception.class,() -> this.localValidacion.validarNit(nitPrueba));
        Assertions.assertEquals(Mensaje.LONGITUD_NIT.getMensaje(),respuesta.getMessage());

    }

    @Test
    public void validarNitCorrecto(){
        String nitPrueba = "123";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.localValidacion.validarNit(nitPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarNombreEmpresaConMasDe30Caracteres(){
        String nombrePrueba = "aquihaymasdetreintacaracteresimposiblesino";
        Exception respuesta = Assertions.assertThrows(Exception.class,()-> this.localValidacion.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensaje.LONGITUD_NOMBRE_NIT.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarNombreEmpresaCorrecto(){
        String nombrePrueba = "aqui";
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.localValidacion.validarNombre(nombrePrueba));
        Assertions.assertTrue(respuesta);
    }



}