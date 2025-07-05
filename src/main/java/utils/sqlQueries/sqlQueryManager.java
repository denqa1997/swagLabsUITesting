package utils.sqlQueries;

import org.junit.jupiter.api.Assertions;

import java.sql.*;

import static utils.propertyManager.SetUpProperty.*;

public class sqlQueryManager {
    private static Connection connection;
    private static Connection getConnectionToDataBase() throws SQLException {
        connection = DriverManager.getConnection(getEnvs("jdbcURL"));
        connection.setAutoCommit(false);
        return connection;
    }

    public static void selectQueryWithAssert(String sqlQuery, Object expectedResult) throws SQLException {
        try (Statement statement = getConnectionToDataBase().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            resultSet.next();
            Object actualResult = resultSet.getObject(1);
            Assertions.assertEquals(expectedResult, actualResult, "Test failed");
        } catch (Exception e) {
            e.printStackTrace();
        }
        connection.rollback();
        connection.close();
        if (connection.isClosed()) {
            System.out.println("Клиент отключен от БД");
        } else System.out.println("Клиент все еще подключен к БД");
    }
}
