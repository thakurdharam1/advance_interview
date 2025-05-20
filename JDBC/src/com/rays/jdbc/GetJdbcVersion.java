package com.rays.jdbc;

import java.sql.Driver;

public class GetJdbcVersion {
    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class driverClass = Class.forName("com.mysql.cj.jdbc.Driver");
          //  Driver driver = (Driver) driverClass.getDeclaredConstructor().newInstance();
            Driver driver = (Driver) driverClass.newInstance();

            // Get the JDBC version
            int majorVersion = driver.getMajorVersion();
            int minorVersion = driver.getMinorVersion();

            System.out.println("MySQL JDBC Version: " + majorVersion + "." + minorVersion);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}