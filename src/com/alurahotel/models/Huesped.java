package com.alurahotel.models;

import java.util.List;

public class Huesped {
    private Integer id;
    private String nombre;
    private String apellido;
    private String fechaNacimiento;
    private String nacionalidad;
    private String telefono;
    private Integer reserva;
    // private List<Reserva> reservas;

    public Huesped(Integer id, String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono, Integer reserva) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reserva = reserva;
    }

    public Huesped(String nombre, String apellido, String fechaNacimiento, String nacionalidad, String telefono, String nReserva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.telefono = telefono;
        this.reserva = Integer.parseInt(nReserva);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getReserva() {
        return reserva;
    }

    public void setReserva(Integer reserva) {
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Huesped [apellido=" + apellido + ", fechaNacimiento=" + fechaNacimiento + ", id=" + id + ", nacionalidad="
                + nacionalidad + ", nombre=" + nombre + ", reserva=" + reserva + ", telefono=" + telefono + "]";
    }
}
