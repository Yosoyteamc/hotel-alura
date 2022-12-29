package com.alurahotel.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alurahotel.dao.HuespedesDAO;
import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.models.Huesped;

public class HuespedesController {
    
    private HuespedesDAO huespedesDAO;

    public HuespedesController() {
        var connection = new ConnectionFactory();
        this.huespedesDAO = new HuespedesDAO(connection.getConnection());
    }

    public int guardarHuesped(String nombre, String apellido, Date nacimiento,String nacionalidad, String telefono, String nReserva ) {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formatednacimiento = dmyFormat.format(nacimiento);

        Huesped huesped = new Huesped(nombre, apellido, formatednacimiento, nacionalidad, telefono, nReserva);
        return huespedesDAO.guardar(huesped);
    }

	public List<Huesped> obtenerHuespedes() {
		return huespedesDAO.obtenerHuespedes();
	}

    public int modificarHuesped(Huesped huesped) {
        return huespedesDAO.modificar(huesped);
    }
}
