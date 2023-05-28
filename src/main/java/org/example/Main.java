package org.example;

import org.example.service.DatabaseQueryService;

public class Main {
    public static void main(String[] args) {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        System.out.println("databaseQueryService.findLongestProject() = " + databaseQueryService.findLongestProject());
    }
}
