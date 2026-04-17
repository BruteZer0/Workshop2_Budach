package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Book[] books = new Book[] {
                new Book(1, "978-1-4028-9462-6", "Shadow of the Forgotten"),
                new Book(2, "978-0-545-01022-1", "Echoes of Tomorrow"),
                new Book(3, "978-1-86197-876-9", "The Silent Horizon"),
                new Book(4, "978-0-7432-7356-5", "Crimson Skies"),
                new Book(5, "978-1-250-30660-8", "The Last Ember"),
                new Book(6, "978-0-316-76948-0", "Winds of Eternity"),
                new Book(7, "978-1-5011-8756-4", "Fragments of Light"),
                new Book(8, "978-0-06-112008-4", "The Hidden Path"),
                new Book(9, "978-1-4028-9462-3", "Midnight Whispers"),
                new Book(10, "978-0-452-28423-4", "The Broken Realm"),
                new Book(11, "978-0-14-044913-6", "Veil of Secrets"),
                new Book(12, "978-1-56619-909-4", "The Iron Pact"),
                new Book(13, "978-0-307-29136-2", "Stormbound"),
                new Book(14, "978-1-250-08071-3", "Ashes of the Fallen"),
                new Book(15, "978-0-399-16405-5", "The Glass Kingdom"),
                new Book(16, "978-0-553-21311-7", "Whispers in the Dark"),
                new Book(17, "978-1-250-30661-5", "The Golden Cipher"),
                new Book(18, "978-0-7432-7357-2", "The Infinite Maze"),
                new Book(19, "978-1-5011-8757-1", "Dreams of the Void"),
                new Book(20, "978-0-06-231609-7", "The Final Constellation")
        };

        while(true){
            System.out.println("\n=== BOOK STORE HOME SCREEN ===");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int userInput = scanner.nextInt();

            if(userInput == 1) {
                    System.out.println("\n=== AVAILABLE BOOKS ===");
                    for (Book book : books) {
                        if (book.isCheckedOut() == false) {
                            System.out.println(book.getId() + ". " + book.getTitle() + " (" + book.getIsbn() + ")");
                        }
                    }
                    while(true) {
                        System.out.println("\n1. Check out");
                        System.out.println("2. Exit");
                        System.out.print("Enter your choice: ");

                        int userInput1 = scanner.nextInt();

                        if (userInput1 == 1) {
                            scanner.nextLine();
                            System.out.println("Name:");
                            String name = scanner.nextLine();
                            System.out.println("ID: ");
                            int idInput = scanner.nextInt();
                            boolean available = false;
                            for (Book book : books) {
                                if (book.getId() == idInput) {
                                    book.checkOut(name);
                                    System.out.println(name + " checked out: " + book.getTitle());
                                    available = true;
                                }
                            }
                            if(available = false){
                                System.out.println("ERROR: Invalid Book ID");
                                break;
                            }
                        }
                        else if (userInput1 == 2) {
                            break;
                        } else {
                            System.out.println("ERROR: Invalid Option");
                        }
                    }
            }

            else if(userInput == 2){
                System.out.println("\n=== CHECKED OUT BOOKS ===");
                for (Book book: books){
                    if(book.isCheckedOut()){
                        System.out.println(book.getId() + ". " + book.getTitle() + " (" + book.getIsbn() + ")");
                        break;
                    }
                }
            }

            else if(userInput == 3){
            System.out.println("Goodbye!");
            break;
            }

            else{
                System.out.println("ERROR: Invalid Option In Menu");
            }
        }
    }
}