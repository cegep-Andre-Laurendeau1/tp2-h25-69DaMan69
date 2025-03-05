package ca.cal.tp1.persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RepositoryParent {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:mem:tp1;DB_CLOSE_DELAY=-1";
    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";
    static Connection conn;

    static {
        // STEP 1: Register JDBC driver
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            String sql =  "CREATE TABLE  UTILISATEUR " +
                    "(userid INTEGER not NULL, " +
                    " name VARCHAR(255), " +
                    " email VARCHAR(255), " +
                    " phoneNumber VARCHAR(255), " +
                    " PRIMARY KEY ( userid ))";
            stmt.executeUpdate(sql);
            stmt = conn.createStatement();
            sql = "CREATE TABLE  Livre " +
                    "(isbn VARCHAR(255) not NULL, " +
                    " auteur VARCHAR(255), " +
                    " editeur VARCHAR(255), " +
                    " nombrePages INTEGER, " +
                    " PRIMARY KEY ( isbn ))";
            stmt.executeUpdate(sql);
            stmt = conn.createStatement();
            sql = "CREATE TABLE  Document " +
                    "(id INTEGER not NULL, " +
                    " titre VARCHAR(255), " +
                    " nombreExemplaires Integer, " +
                    " PRIMARY KEY ( id ))";
            stmt.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
