package com.artem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exercises {

    public static int firstTask(int countFloor, Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT COUNT(number) FROM chart WHERE CAST(TRIM(number_floor,'абвгдеёжзийклмнопрстуфхцчшщъыьэюя-М') AS INTEGER) == ?")) {
            statement.setObject(1, countFloor);
            return statement.executeQuery().getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public static String secondTask(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT address FROM chart WHERE(appellation == 'Зарегистрированный участок' AND  prefix_code == 9881 )")) {
            StringBuilder builder = new StringBuilder();
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                builder.append(resultSet.getString(1)).append('\n');
            }
            return builder.toString();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }

    public static String thirdTask(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT address, prefix_code FROM chart WHERE appellation LIKE 'Университет' AND CAST(TRIM(number_floor,'абвгдеёжзийклмнопрстуфхцчшщъыьэюя-М') AS INTEGER) > 5 AND year_construction != ''")) {
            StringBuilder builder = new StringBuilder();
            int i = 0;
            int avg = 0;
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                builder.append(resultSet.getString(1)).append('\n');
                avg += resultSet.getInt(2);
                i++;
            }
            builder.append("\naverage prefix code = " + avg / i);
            return builder.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }
}
