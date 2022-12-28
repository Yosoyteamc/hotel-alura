package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                return reservaID;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Reserva> obtenerReservas() {
        List<Reserva> reservas = new ArrayList<>();
        final Connection con = new ConnectionFactory().getConnection();
        try(con){
            final PreparedStatement statement = con.prepareStatement(
                "SELECT * FROM reservas");
            try(statement){
                statement.execute();
                final ResultSet resultSet = statement.getResultSet();
                while(resultSet.next()){
                    Reserva fila = new Reserva(
                        resultSet.getInt("id"),
                        resultSet.getString("fecha_entrada"),
                        resultSet.getString("fecha_salida"),
                        resultSet.getString("valor"),
                        resultSet.getString("forma_pago")
                    );
                    reservas.add(fila);
                }
                return reservas;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
    

