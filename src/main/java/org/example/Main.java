package org.example;

import org.example.service.DatabaseQueryService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        // System.out.println("databaseQueryService.findLongestProject() = " + databaseQueryService.findLongestProject());
        Thread.sleep(1000);
        System.out.println("databaseQueryService.findMaxProjectCountClient() = " + databaseQueryService.findMaxProjectCountClient());
        Thread.sleep(1000);
        System.out.println("databaseQueryService.findMaxSalaryWorker() = " + databaseQueryService.findMaxSalaryWorker());
    }
}
