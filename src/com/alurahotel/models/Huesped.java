package com.alurahotel.models;

import java.util.List;

public class Huesped {
    private Integer id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private String telefono;
    private Reserva reserva;
    private List<Reserva> reservas;

    public Huesped(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono, Reserva reserva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reserva = reserva;
    }

    public Huesped(String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono, Reserva reserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reserva = reserva;
    }

}
