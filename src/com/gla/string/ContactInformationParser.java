package com.gla.string;
import java.util.StringTokenizer;

public class ContactInformationParser {

    // Method to process and display contacts
    public static void parseContacts(String input) {

        String[] contacts = input.split("\n");
        int contactCount = 0;

        System.out.println("======= CONTACT DETAILS =======\n");

        for (String contact : contacts) {
            if (contact.trim().isEmpty()) {
                continue;
            }

            StringTokenizer tokenizer = new StringTokenizer(contact, ";");

            String name = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";
            String phone = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";
            String email = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";
            String address = tokenizer.hasMoreTokens() ? tokenizer.nextToken() : "N/A";

            contactCount++;

            // Display formatted card
            System.out.println("Contact #" + contactCount);
            System.out.println("-------------------------------");
            System.out.println("Name    : " + name);
            System.out.println("Phone   : " + phone);
            System.out.println("Email   : " + email);
            System.out.println("Address : " + address);
            System.out.println();
        }

        System.out.println("Total Contacts Processed: " + contactCount);
    }

    public static void main(String[] args) {

        String inputContacts =
                "John Doe;+1-555-0101;john@email.com;123 Main St, NYC\n" +
                        "Jane Smith;+1-555-0102;jane@email.com;456 Oak Ave, LA\n" +
                        "Mike Brown;+1-555-0103;mike@email.com;789 Pine Rd, TX\n" +
                        "Emily Davis;+1-555-0104;emily@email.com;321 Maple St, FL\n" +
                        "Chris Wilson;+1-555-0105;;901 Cedar Blvd, WA";

        parseContacts(inputContacts);
    }
}

