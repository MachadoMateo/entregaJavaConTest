package org.example.modelos;

import org.example.utilidades.Util;
import org.example.validaciones.OfertaValidacion;
import org.example.validaciones.ReservaValidacion;

import java.time.LocalDate;

public class Reserva {
    private int id;
    private int idusuario;
    private int idoferta;
    private double costototal;
    private LocalDate fechareserva;
    private String numeropersona;

    private Util util = new Util();
    private ReservaValidacion validacion = new ReservaValidacion();





    public Reserva() {
    }

    public Reserva(int id, int idusuario, int idoferta, double costototal, LocalDate fechareserva, String numeropersona) {
        this.id = id;
        this.idusuario = idusuario;
        this.idoferta = idoferta;
        this.costototal = costototal;
        this.fechareserva = fechareserva;
        this.numeropersona = numeropersona;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", idusuario=" + idusuario +
                ", idoferta=" + idoferta +
                ", costototal=" + costototal +
                ", fechareserva=" + fechareserva +
                ", numeropersona='" + numeropersona + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdoferta() {
        return idoferta;
    }

    public void setIdoferta(int idoferta) {
        this.idoferta = idoferta;
    }

    public double getCostototal() {
        return costototal;
    }

    public void setCostototal(double costototal) {
        this.costototal = costototal;
    }

    public LocalDate getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(String fechareserva) {
        try {
            this.validacion.validarFechaRes(fechareserva);
            this.fechareserva = this.util.convertirStringEnLocalDate(fechareserva);
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }

    public String getNumeropersona() {
        return numeropersona;
    }

    public void setNumeropersona(String numeropersona) {
        try {
            this.validacion.validarNumeroPer(numeropersona);
            this.numeropersona = numeropersona;
        }catch (Exception error){
            System.out.println(error.getMessage());
        }
    }
}























