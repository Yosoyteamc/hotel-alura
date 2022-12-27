package com.alurahotel.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alurahotel.dao.ReservasDAO;
import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.models.Reserva;

public class ReservasController {

    private ReservasDAO reservasDAO;

    public ReservasController() {
        var connection = new ConnectionFactory();
        this.reservasDAO = new ReservasDAO(connection.getConnection());
    }

    public double calcularValorTotalReserva(Date fechaEntrada, Date fechaSalida, double valorDiario) {
        long dias = (fechaSalida.getTime() - fechaEntrada.getTime()) / (1000 * 60 * 60 * 24);
        return dias * valorDiario;
    }

    public int guardarReserva(Date entrada, Date salida, String valor, String formaPago) {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatedEntrada = dmyFormat.format(entrada);
        String formatedSalida = dmyFormat.format(salida);

        var reserva = new Reserva(formatedEntrada, formatedSalida, valor, formaPago);
        return reservasDAO.guardar(reserva);
    }
}

