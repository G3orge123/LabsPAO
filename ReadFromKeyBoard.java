package basics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadFromKeyBoard {

    private static Map<String, Integer> userData = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter Command >>> ");
        while (scanner.hasNext()) {
            String command = scanner.next();
            switch (command.toLowerCase()) {
                case "create":
                    create();
                    break;
                case "read":
                    read();
                    break;
                case "update":
                    update();
                    break;
                case "delete":
                    delete();
                    break;
                case "help":
                    help();
                    break;
                case "quit":
                    quit();
                    return;
                default:
                    System.out.println("Invalid command. Type 'help' for a list of commands.");
            }
            System.out.println("Enter Command >>> ");
        }
    }

    private static void create() {
        System.out.println("Command received: create");
        System.out.print("Username: >>> ");
        String username = scanner.next();
        System.out.print("Sold: >>> ");
        int sold = scanner.nextInt();
        userData.put(username, sold);
        System.out.println("User " + username + " was created with sold " + sold);
    }

    private static void read() {
        System.out.println("Command received: read");
        System.out.print("Username: >>> ");
        String username = scanner.next();
        if (userData.containsKey(username)) {
            System.out.println("The sold for user " + username + " is " + userData.get(username));
        } else {
            System.out.println("User not found.");
        }
    }

    private static void update() {
        System.out.println("Command received: update");
        System.out.print("Username: >>> ");
        String username = scanner.next();
        System.out.print("Sold: >>> ");
        int sold = scanner.nextInt();
        if (userData.containsKey(username)) {
            userData.put(username, sold);
            System.out.println("The sold was updated for user " + username + " to " + sold);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void delete() {
        System.out.println("Command received: delete");
        System.out.print("Username: >>> ");
        String username = scanner.next();
        if (userData.remove(username) != null) {
            System.out.println("User " + username + " was deleted.");
        } else {
            System.out.println("User not found.");
        }
    }

    private static void help() {
        System.out.println("\n\tAccepted commands:");
        System.out.println("\t\thelp: Instructions on how to use the application");
        System.out.println("\t\tcreate: Create a new user. Can receive two parameters: username and sold.");
        System.out.println("\t\tread: Read user's data. Receive the username.");
        System.out.println("\t\tupdate: Update user's sold. Can receive two parameters: username and sold.");
        System.out.println("\t\tdelete: Delete the user's data. Receive the username.");
        System.out.println("\t\tquit: Close the application.\n");
    }

    private static void quit() {
        System.out.println("Application closing...");
        scanner.close();
    }
}
