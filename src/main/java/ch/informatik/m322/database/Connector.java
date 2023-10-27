package ch.informatik.m322.database;

import java.sql.*;


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
    ResultSet resultSet;


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
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM personen");
            System.out.printf("Connection established");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String vorname = resultSet.getString("vorname");
                String geschlecht = resultSet.getString("geschlecht");
                String geburtsdatum = resultSet.getString("geburtsdatum");
                String ahvnummer = resultSet.getString("ahvnummer");
                String region = resultSet.getString("region");
                int kinder = resultSet.getInt("kinder");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Vorname: " + vorname);
                System.out.println("Geschlecht: " + geschlecht);
                System.out.println("Geburtsdatum: " + geburtsdatum);
                System.out.println("AHV-Nummer: " + ahvnummer);
                System.out.println("Region: " + region);
                System.out.println("Kinder: " + kinder);
                System.out.println("----------------------------------");
            }

            // Verbindung schließen
            resultSet.close();
            statement.close();

            closeConnection();
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