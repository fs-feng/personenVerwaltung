package ch.informatik.m322.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Connector ist eine Singleton-Klasse, zuständig fuer die Verbindung mit der Datenbank personenVerwaltung
 * MariaDB JDBC Driver wird verwendet, um die Verbindung herzustellen.
 */
public class Connector {

    /**
     * Die Instanz der Connector Klasse
     */
    private static Connector instance = new Connector();

    /**
     * Gibt die Instanz der Connector Klasse zurueck
     *
     * @return die Instanz der Connector Klasse wird zurueckgegeben
     */
    public static Connector getInstance() {
        return instance;
    }


    Connection connection;
    Statement statement;


    /**
     * Privater Konstruktor, um eine Verbindung zur Datenbank herzustellen.
     * MariDB JDBC Driver wird geladen und eine Verbindung wird hergestellt.
     * Fehlererkennung mit einem try catch ist vorhanden.
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
     * Schliesst die Verbindung mit der Datenbank.
     * wird ausgeführt, wenn das Programm beendet wird.
     *
     * @throws SQLException Fehlerauswerfung im Fall eines Fehlers.
     */
    public void closeConnection() throws SQLException {
        connection.close();
    }

}
//user_personenVerwaltung
//n/QOXwoEFg!c5yV2