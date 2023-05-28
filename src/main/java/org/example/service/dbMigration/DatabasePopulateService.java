package org.example.service.dbMigration;

import org.example.service.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    private static final String PATH_DB_POPULATE = "src/main/resources/sql/init_db.sql";

    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement statement = connection.createStatement()) {
            String sqlCommand = Files.readString(Path.of(PATH_DB_POPULATE));
            statement.executeUpdate(sqlCommand);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
