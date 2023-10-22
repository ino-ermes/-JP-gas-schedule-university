
package com.mio.DAL;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnection {
    
    private static DatabaseConnection instance;
    private Connection connection;
    
    public static DatabaseConnection getInstance() {
        if(instance == null)
            instance = new DatabaseConnection();
        return instance;
    }
    
    private DatabaseConnection() {
    }
    
    public void connectToDatabase() throws SQLException, ClassNotFoundException {
        String server = "localhost";
        String port = "3306";
        String database = "university";
        String user = "lain";
        String password = "password";
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = java.sql.DriverManager.getConnection("jdbc:mysql://" + server + ":" + port + "/" + database + "?verifyServerCertificate=true&useSSL=false&allowPublicKeyRetrieval=true", user, password);
    }

    public Connection getConnection() {
        return connection;
    }
}
