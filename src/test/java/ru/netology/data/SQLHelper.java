package ru.netology.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {

    }

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://185.119.57.47:3306/app", "app", "pass");

    }

    @SneakyThrows
    public static void cleanTable() {
        var deletePaymentEntity = "DELETE FROM payment_entity ";
        var runner = new QueryRunner();
        try (var conn = DriverManager.getConnection("jdbc:mysql://185.119.57.47:3306/app", "app", "pass")) {
            runner.update(conn, deletePaymentEntity);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @SneakyThrows
    public static String getPaymentStatus() {
        String statusSQL = "SELECT status FROM payment_entity";
        return getStatus(statusSQL);
    }

    @SneakyThrows
    private static String getStatus(String query) {
        var runner = new QueryRunner();
        try (var conn = DriverManager.getConnection("jdbc:mysql://185.119.57.47:3306/app", "app", "pass")) {
            String status = runner.query(conn, query, new ScalarHandler<String>());
            return status;
        }
    }

    }


