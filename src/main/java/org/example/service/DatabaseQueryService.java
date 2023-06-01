package org.example.service;

import org.example.entities.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseQueryService {
    private static final String PATH_DB_MAX_PROJECTS_COUNT = "src/main/resources/sql/find_max_projects_client.sql";
    private static final String PATH_DB_MAX_SALARY_WORKER = "src/main/resources/sql/find_max_salary_worker.sql";
    private static final String PATH_DB_LONGEST_PROJECT = "src/main/resources/sql/find_longest_project.sql";
    private static final String PATH_DB_YOUNGEST_ELDEST_WORKER = "src/main/resources/sql/find_youngest_eldest_workers.sql";
    private static final String PATH_DB_PRINT_PROJECT_PRICES = "src/main/resources/sql/print_project_prices.sql";

    public List<MaxProjectCountClient> findMaxProjectCountClient() {
        List<MaxProjectCountClient> maxProjectCountClients = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlCommand = Files.readString(Path.of(PATH_DB_MAX_PROJECTS_COUNT));
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectCount = resultSet.getInt("project_count");
                maxProjectCountClients.add(new MaxProjectCountClient(name, projectCount));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return maxProjectCountClients;
    }

    public List<MaxSalaryWorker> findMaxSalaryWorker() {
        List<MaxSalaryWorker> maxSalaryWorkers = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlCommand = Files.readString(Path.of(PATH_DB_MAX_SALARY_WORKER));
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int workerSalary = resultSet.getInt("salary");
                maxSalaryWorkers.add(new MaxSalaryWorker(name, workerSalary));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return maxSalaryWorkers;
    }

    public List<LongestProject> findLongestProject() {
        List<LongestProject> longestProjects = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlCommand = Files.readString(Path.of(PATH_DB_LONGEST_PROJECT));
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int projectMonthCount = resultSet.getInt("MONTH_COUNT");
                longestProjects.add(new LongestProject(name, projectMonthCount));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return longestProjects;
    }

    public List<YoungestEldestWorker> findYoungestEldestWorker() {
        List<YoungestEldestWorker> youngestEldestWorkers = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlCommand = Files.readString(Path.of(PATH_DB_YOUNGEST_ELDEST_WORKER));
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                Date workerBirthday = resultSet.getDate("birthday");
                youngestEldestWorkers.add(new YoungestEldestWorker(type, name, workerBirthday));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return youngestEldestWorkers;
    }

    public List<Project> findProjects() {
        List<Project> projects = new ArrayList<>();

        try (Connection connection = Database.getInstance().getConnection()) {
            String sqlCommand = Files.readString(Path.of(PATH_DB_PRINT_PROJECT_PRICES));
            PreparedStatement preparedStatement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("id");
                int projectPrice = resultSet.getInt("price");
                projects.add(new Project(name, projectPrice));
            }
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return projects;
    }
}
