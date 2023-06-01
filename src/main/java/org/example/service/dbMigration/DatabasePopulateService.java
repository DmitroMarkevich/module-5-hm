package org.example.service.dbMigration;

import org.example.service.Database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabasePopulateService {
    private static final String PATH_DB_POPULATE = "src/main/resources/sql/init_db.sql";

    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlCommand = Files.readString(Path.of(PATH_DB_POPULATE));
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            preparedStatement.executeUpdate(sqlCommand);
            preparedStatement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
