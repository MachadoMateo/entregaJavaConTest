package org.example.validaciones;

import org.example.modelos.Local;
import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

public class OfertaValidacionTest {
    OfertaValidacion ofertaValidacion;


    @BeforeEach
    public void configurarPrueba(){
        System.out.println("Estoy ejecutando la prueba");
        this.ofertaValidacion = new OfertaValidacion();
    }

    @Test
    public void tituloOfertaConMasDeVeinteCaracteres(){
        String tituloPrueba = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Exception respuesta = Assertions.assertThrows(Exception.class,()-> this.ofertaValidacion.validarTitulo(tituloPrueba));
        Assertions.assertEquals(Mensaje.LONGITUD_TITULO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void tituloCorrecto(){
        String tituloPrueba = "titulocorrecto";
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.ofertaValidacion.validarTitulo(tituloPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void costoPorPersonaNegativo(){
        double costoPrueba = -1;
        Exception respuesta = Assertions.assertThrows(Exception.class,()-> this.ofertaValidacion.validarCostoPersona(costoPrueba));
        Assertions.assertEquals(Mensaje.COSTO_PERSONA.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void costoPorPersonaCorrecto(){
        double costoPrueba = 1;
        Boolean respuesta = Assertions.assertDoesNotThrow(()-> this.ofertaValidacion.validarCostoPersona(costoPrueba));
        Assertions.assertTrue(respuesta);
    }

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Test
    public void formatoFechaIncorrecta()throws Exception{
        OfertaValidacion ofertaValidacion = new OfertaValidacion();
        String pruebaFecha = "21-22-2023";
        Exception respuesta = Assertions.assertThrows(Exception.class,()-> this.ofertaValidacion.validarFormatoFecha(pruebaFecha));
        Assertions.assertEquals(Mensaje.FORMATO_FECHA.getMensaje(),respuesta.getMessage());

    }

    @Test
    public void formatoFechaCorrecto()throws Exception{
        OfertaValidacion ofertaValidacion = new OfertaValidacion();
        String pruebaFecha = "11-01-2023";
        boolean respuesta = ofertaValidacion.validarFormatoFecha(pruebaFecha);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void fechaReservaCorrecta()throws Exception{
        OfertaValidacion ofertaValidacion = new OfertaValidacion();
        LocalDate fechaInicio = LocalDate.parse("22-12-2023", formatter);
        LocalDate fechaFin = LocalDate.parse("23-12-2023", formatter);
        Boolean respuesta = ofertaValidacion.validarDirenciaFechas(fechaInicio,fechaFin);
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void  fechaReservaIncorrecta()throws Exception{
        OfertaValidacion ofertaValidacion = new OfertaValidacion();
        LocalDate fechaInicio = LocalDate.parse("22-12-2023", formatter);
        LocalDate fechaFin = LocalDate.parse("02-11-2023", formatter);
        Exception respuesta = Assertions.assertThrows(Exception.class,()-> this.ofertaValidacion.validarDirenciaFechas(fechaInicio,fechaFin));

    }




}