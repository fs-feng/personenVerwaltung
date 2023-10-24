package ch.informatik.m322;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    private static Connector instance = new Connector();
    public static Connector getInstance() {
        return instance;
    }
    private Connector() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String jdbcUrl = "jdbc:mariadb://frank-feng.synology.me:3306/personenVerwaltung";
            String username = "user_personenVerwaltung";
            String password = "n/QOXwoEFg!c5yV2";

            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            System.out.printf("it worked!!!");
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

}
//user_personenVerwaltung
//n/QOXwoEFg!c5yV2