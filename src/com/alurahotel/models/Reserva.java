package com.alurahotel.models;

public class Reserva {
    private Integer id;
    private String fechaEntrada;
    private String fechaSalida;
    private String valor;
    private String FormadePago; 

    public Reserva(Integer id, String fechaEntrada, String fechaSalida, String valor, String FormadePago) {
        this.id = id;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.FormadePago = FormadePago;
    }

    public Reserva(String fechaEntrada, String fechaSalida, String valor, String FormadePago) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.valor = valor;
        this.FormadePago = FormadePago;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getFormaPago() {
        return FormadePago;
    }

    public void setFormaPago(String FormadePago) {
        this.FormadePago = FormadePago;
    }

    @Override
    public String toString() {
        return "Reserva [FormadePago=" + FormadePago + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida
                + ", id=" + id + ", valor=" + valor + "]";
    }
}
