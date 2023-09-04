package org.example;

import org.example.modelos.*;
import org.example.validaciones.LocalValidacion;
import org.example.validaciones.OfertaValidacion;
import org.example.validaciones.ReservaValidacion;
import org.example.validaciones.UsuarioValidacion;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        UsuarioValidacion usuarioValidacion = new UsuarioValidacion();
        OfertaValidacion ofertaValidacion = new OfertaValidacion();
        LocalValidacion localValidacion = new LocalValidacion();
        ReservaValidacion reservaValidacion = new ReservaValidacion();
        Scanner teclado= new Scanner(System.in);
        Usuario objetoUsuario = new Usuario();
        Oferta objetoOferta = new Oferta();
        Local objetoLocal = new Local();
        Reserva objetoReserva = new Reserva();


        System.out.println("ingrese la cantidad de personas para la reserva");
        objetoReserva.setNumeropersona(teclado.nextLine());
        /*System.out.println("Digite el costo por persona");
        objetoOferta.setTitulo(teclado.nextLine());*/

        /*System.out.println("Digite su nombre ");
        objetoUsuario.setNombre(teclado.nextLine());*/

        /*System.out.println("Ingrese su ubicación");
        objetoUsuario.setUbicacion(teclado.nextInt());
        teclado.nextLine();*/

        /*System.out.println("Ingrese su correo");
        objetoUsuario.setCorreo(teclado.nextLine());*/

        /*System.out.println("Ingrese fecha inicio");
        objetoOferta.setFechainicio(teclado.nextLine());*/

        /*System.out.println("Ingrese fecha inicio");
        objetoOferta.setFechainicio(teclado.nextLine());

        System.out.println("ingrese fecha fin");
        objetoOferta.setFechafin(teclado.nextLine());*/




    }
}