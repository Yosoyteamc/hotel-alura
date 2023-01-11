package com.alurahotel.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    public List<Reserva> obtenerReservas() {
        return reservasDAO.obtener();
    }

    public int modificarReserva(Reserva reserva) {
        SimpleDateFormat formated = new SimpleDateFormat("yyyy-MM-dd");
        Double valorTemp;
        try {
            Date entrada = formated.parse(reserva.getFechaEntrada());
            Date salida = formated.parse(reserva.getFechaSalida());
            valorTemp = calcularValorTotalReserva(entrada, salida, 50000);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(valorTemp > 0.0){
            reserva.setValor(valorTemp.toString());
            return reservasDAO.modificar(reserva);
        }
        return 0;
    }

    public int eliminarReserva(Integer id) {
        return reservasDAO.eliminar(id);
    }
}

