package com.gla.string;

import java.text.SimpleDateFormat;
import java.util.Date;

class LogBuffer {
    // Thread-safe buffer
    static StringBuffer logs = new StringBuffer();

    // Counters per service
    static int webCount = 0;
    static int dbCount = 0;
    static int cacheCount = 0;
    static int apiCount = 0;

    // Add log entry
    public static synchronized void addLog(String service, String level, String message) {
        String timestamp = new SimpleDateFormat("HH:mm:ss.SSS").format(new Date());
        logs.append("[").append(timestamp).append("] ")
                .append("[").append(service).append("] ")
                .append("[").append(level).append("] ")
                .append(message).append("\n");

        // Count logs per service
        switch (service) {
            case "WebServer": webCount++; break;
            case "Database": dbCount++; break;
            case "Cache": cacheCount++; break;
            case "APIGateway": apiCount++; break;
        }
    }
}

// Web Server Thread
class WebServer extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            LogBuffer.addLog("WebServer", "INFO", "HTTP request processed " + i);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
        }
    }
}

// Database Server Thread
class DatabaseServer extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            LogBuffer.addLog("Database", "WARNING", "Query executed " + i);
            try { Thread.sleep(150); } catch (InterruptedException e) {}
        }
    }
}

// Cache Server Thread
class CacheServer extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            LogBuffer.addLog("Cache", "INFO", "Cache hit/miss " + i);
            try { Thread.sleep(80); } catch (InterruptedException e) {}
        }
    }
}

// API Gateway Thread
class APIGateway extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            LogBuffer.addLog("APIGateway", "ERROR", "API call handled " + i);
            try { Thread.sleep(120); } catch (InterruptedException e) {}
        }
    }
}

public class MultiThreadedLogAggregator {

    public static void main(String[] args) {

        Thread web = new WebServer();
        Thread db = new DatabaseServer();
        Thread cache = new CacheServer();
        Thread api = new APIGateway();

        // Start all services
        web.start();
        db.start();
        cache.start();
        api.start();

        // Wait for all threads to finish
        try {
            web.join();
            db.join();
            cache.join();
            api.join();
        } catch (InterruptedException e) {}

        // Display consolidated logs
        System.out.println("========= CONSOLIDATED LOGS =========");
        System.out.println(LogBuffer.logs);

        // Final statistics
        System.out.println("========= LOG STATISTICS =========");
        System.out.println("Web Server Logs     : " + LogBuffer.webCount);
        System.out.println("Database Logs       : " + LogBuffer.dbCount);
        System.out.println("Cache Server Logs   : " + LogBuffer.cacheCount);
        System.out.println("API Gateway Logs    : " + LogBuffer.apiCount);

        int totalLogs = LogBuffer.webCount + LogBuffer.dbCount +
                LogBuffer.cacheCount + LogBuffer.apiCount;

        System.out.println("Total Log Entries   : " + totalLogs);
        System.out.println("Total Log Size (chars): " + LogBuffer.logs.length());
    }
}
