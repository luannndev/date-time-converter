package dev.luan.converter;

import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bitte geben Sie Ihren Date String im Format (yyyy-MM-dd'T'HH:mm:ss): ");
        String dateString = input.next();

        try {
            DateTimeConverter converter = new DateTimeConverter(dateString);
            System.out.println("ISO 8601 Format: " + converter.toIso8601());
            System.out.println("ISO 9075 Format: " + converter.toIso9075());
            System.out.println("RFC 3339 Format: " + converter.toRfc3339());
            System.out.println("RFC 7231 Format: " + converter.toRfc7231());
            System.out.println("UNIX Timestamp: " + converter.toUnixTimestamp());
            System.out.println("Timestamp: " + converter.toTimestamp());
            System.out.println("UTC Format: " + converter.toUtcFormat());
            System.out.println("MongoDB ObjectId: " + converter.toMongoObjectId());
            System.out.println("Excel Date: " + converter.toExcelDate());
        } catch(Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}