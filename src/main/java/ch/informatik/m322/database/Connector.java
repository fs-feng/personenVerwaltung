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


    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private String sqlQuery;


    /**
     * private constructor for building the connection.
     * MariDB JDBC Driver will run and build a connection.
     * Errors will be handled via try-catch.
     */
    private Connector() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String jdbcUrl = "jdbc:mariadb://192.168.1.215:3306/personenVerwaltung";
            String username = "user_personenVerwaltung";
            String password = "n/QOXwoEFg!c5yV2";

            connection = DriverManager.getConnection(jdbcUrl, username, password);

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
        if (resultSet != null)
            resultSet.close();
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }




    public Connection getConnection() {
        return connection;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public PreparedStatement getPreparedStatement() {
        return preparedStatement;
    }

    public void setPreparedStatement(PreparedStatement preparedStatement) {
        this.preparedStatement = preparedStatement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}
//user_personenVerwaltung
//n/QOXwoEFg!c5yV2