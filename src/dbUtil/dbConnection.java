package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static final String SQLCON = "jdbc:sqlite:InventorySystem.sqlite";

    //Method to establish connection with sqlie3
    public static Connection getConnection() throws SQLException{
        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQLCON);
        }
       catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }
}

