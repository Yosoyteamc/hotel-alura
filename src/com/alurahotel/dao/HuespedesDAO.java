package com.alurahotel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alurahotel.factory.ConnectionFactory;
import com.alurahotel.models.Huesped;

public class HuespedesDAO {
    
    private Connection con;

    public HuespedesDAO(Connection con) {
        this.con = con;
    }

    public int guardar(Huesped huesped) {
        int huespedID = 0;
        final Connection con = new ConnectionFactory().getConnection();
        try(con){
            final PreparedStatement statement = con.prepareStatement(
                "INSERT INTO HUESPEDES (NOMBRE, APELLIDO, FECHA_NACIMIENTO, NACIONALIDAD, TELEFONO, RESERVA_ID) VALUES (?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, huesped.getNombre());
            statement.setString(2, huesped.getApellido());
            statement.setString(3, huesped.getFechaNacimiento());
            statement.setString(4, huesped.getNacionalidad());
            statement.setString(5, huesped.getTelefono());
            statement.setInt(6, huesped.getReserva());
            statement.execute();

            final ResultSet resultSet = statement.getGeneratedKeys();
            try(resultSet) {
                while(resultSet.next()) {
                    huespedID = resultSet.getInt(1);
                    huesped.setId(huespedID);
                    System.out.println("Huesped guardado con éxito" + huesped);
                }
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return huespedID;
    }
}
