package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.models.Reserva;

public class ReservasDAO {
    private Connection con;

    public ReservasDAO(Connection con) {
        this.con = con;
    }

    public int guardar(Reserva reserva) {
        int reservaID = 0;
        final Connection con = new ConnectionFactory().getConnection();
        try(con){
            final PreparedStatement statement = con.prepareStatement(
                "INSERT INTO reservas (fecha_entrada, fecha_salida, valor, forma_pago) VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, reserva.getFechaEntrada());
            statement.setString(2, reserva.getFechaSalida());
            statement.setString(3, reserva.getValor());
            statement.setString(4, reserva.getFormaPago());
            statement.execute();

            final ResultSet resultSet = statement.getGeneratedKeys();
            try(resultSet) {
                while(resultSet.next()) {
                    reservaID = resultSet.getInt(1);
                    reserva.setId(reservaID);
                    System.out.println("Reserva guardada con éxito" + reserva);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reservaID;
    }
    
}
