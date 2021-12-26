package com.artem;


import org.sqlite.JDBC;

import java.sql.*;

public class SqlGenerator {

    private static final String CON_STR = "jdbc:sqlite:identifier.sqlite";

    public final Connection connection;

    public SqlGenerator() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public void generateString(Base base) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO chart(`number`,`address`, `number_floor`, `appellation`, `prefix_code`, `year_construction`) " +
                        "VALUES(?, ?, ?, ?, ?, ?)")) {
            statement.setObject(1, base.getNumber());
            statement.setObject(2, base.getAddress());
            statement.setObject(3, base.getNumberFloor());
            statement.setObject(4, base.getAppellation());
            statement.setObject(5, base.getPrefixCode());
            statement.setObject(6, base.getYearConstruction());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}