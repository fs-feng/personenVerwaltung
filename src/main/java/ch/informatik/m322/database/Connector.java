package ch.informatik.m322.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Connector is a Singleton class responsible for building the connection to the database.
 * MariaDB JDBC Driver is used to build the connection.
 */
public class Connector {

    /**
     * Connector instance.
     */
    private static Connector instance = new Connector();

    /**
     * returns the instance of the Singleton class Connector.
     *
     * @return instance of Connector class will be returned.
     */
    public static Connector getInstance() {
        return instance;
    }


    Connection connection;
    Statement statement;


    /**
     * private constructor for building the connection.
     * MariDB JDBC Driver will run and build a connection.
     * Errors will be handled via try-catch.
     */
    private Connector() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String jdbcUrl = "jdbc:mariadb://frank-feng.synology.me:3306/personenVerwaltung";
            String username = "user_personenVerwaltung";
            String password = "n/QOXwoEFg!c5yV2";

            connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.printf("Connection established");


        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * closes the connection to the database.
     * executes when the application closes.
     *
     * @throws SQLException Catch error.
     */
    public void closeConnection() throws SQLException {
        connection.close();
    }

}
//user_personenVerwaltung
//n/QOXwoEFg!c5yV2