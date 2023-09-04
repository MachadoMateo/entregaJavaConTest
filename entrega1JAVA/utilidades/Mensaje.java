package org.example.utilidades;

public enum Mensaje {
    FORMATO_NOMBRE("Revise el formato del nombre ingresado"),
    LONGITUD_NOMBRE("longitud de nombre es muy corta"),
    FORMATO_CORREO("El correo no es valido"),
    FORMATO_UBICACION("Revise la ubicacion"),
    LONGITUD_NIT("Longitud nit no puede superar los 10 numeros"),
    LONGITUD_NOMBRE_NIT("El nombre no puede superar los 30 caracteres"),
    FORMATO_LOCAL("Revise formato NIT"),
    FORMATO_OFERTA("Revise formato Titulo"),
    LONGITUD_TITULO("El titulo no puede sobrepasar los 20 caracteres"),
    FORMATO_FECHA("Revise el formato de fecha ingresado"),
    FECHA_INICIO_FIN("La fecha inicial no puede ser mayor a la fecha final"),
    COSTO_PERSONA("El costo no puede ser negativo"),
    CANTIDAD_PERSONAS_RESERVA("El numero de personas por reserva no puede ser mayor a 4 personas");
    private String mensaje;
    Mensaje(String mensaje){this.mensaje = mensaje;}
    public String getMensaje(){return mensaje;}

    public void setMensaje(String mensaje){this.mensaje = mensaje;}

}
