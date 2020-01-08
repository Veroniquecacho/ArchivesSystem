package dk.archivesnaviair.archives.MySQL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
public class MySql {
    private final String CONN_STRING = "jdbc:mysql://%s:%s/%s?user=%s&password=%s";
    private String db;
    private String connString;


    private MySql(@Value("${spring.datasource.host}") String host,
                  @Value("${spring.datasource.port}") String port,
                  @Value("${spring.datasource.username}") String username,
                  @Value("${spring.datasource.password}") String password,
                  @Value("${spring.datasource.db}") String db) {
        // Hardcoded local db credentials
        // CHANGE
        connString = String.format(CONN_STRING, host, port, db, username, password);
        this.db = db;
    }

    public Connection getConn() throws SQLException {
        return DriverManager.getConnection(connString);
    }
}
