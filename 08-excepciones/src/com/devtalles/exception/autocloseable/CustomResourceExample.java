package com.devtalles.exception.autocloseable;

public class CustomResourceExample {
    public static void main(String[] args) {

        try (FakeDataBaseConnection connection = new FakeDataBaseConnection()) {
            connection.fetchData();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
