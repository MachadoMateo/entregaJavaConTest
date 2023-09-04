package org.example.validaciones;

import com.sun.nio.sctp.Association;
import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioValidacionTest {
    UsuarioValidacion usuarioValidacion;


    @BeforeEach
    public void configurarPruebas(){
        System.out.println("estoy ejecutando la prueba");
        this.usuarioValidacion = new UsuarioValidacion();
    }
    @Test
    public void validarNombreFallaPorNombreCorto(){
        //prepare
        String nombrePrueba = "Juan";
        //ejecute
        Exception respuesta = Assertions.assertThrows(Exception.class,()-> this.usuarioValidacion.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensaje.LONGITUD_NOMBRE.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarNombreFallaPorCaracteresEspeciales(){
        String nombrePrueba = "M@ateo";
        Exception respuesta2 = Assertions.assertThrows(Exception.class,()-> this.usuarioValidacion.validarNombre((nombrePrueba)));
        Assertions.assertEquals(Mensaje.FORMATO_NOMBRE.getMensaje(),respuesta2.getMessage());

    }
    @Test
    public void validarNombreCorrecto(){
        String nombrePrueba = "MateoMachado";
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.usuarioValidacion.validarNombre(nombrePrueba));
        Assertions.assertTrue(respuesta);
        }



    @Test
    public void validarCorreoIncorrecto(){
        String correoPrueba = "juan.com";
        Exception respuesta = Assertions.assertThrows(Exception.class,() -> this.usuarioValidacion.validarCorreo(correoPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_CORREO.getMensaje(),respuesta.getMessage());

    }


    @Test
    public  void validarCorreoCorrecto(){
        String correoPrueba = "juan@gmail.com";
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.usuarioValidacion.validarCorreo(correoPrueba));
        Assertions.assertTrue(respuesta);
    }



    @Test
    public void ubicacionIncorrecta(){
        int ubicacionPrueba = 6;
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.usuarioValidacion.validarUbicacion(ubicacionPrueba));
        Assertions.assertEquals(Mensaje.FORMATO_UBICACION.getMensaje(),respuesta.getMessage());

    }


    @Test
    public void ubicacionCorrecta(){
        int ubicacionPrueba = 4;
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.usuarioValidacion.validarUbicacion(ubicacionPrueba));
        Assertions.assertTrue(respuesta);
    }






}


