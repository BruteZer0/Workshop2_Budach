package org.example;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //only one scanner is needed

        Book[] books = new Book[] { //created the 20 book arrays with info, did not include isCheckedOut and checkedOutTo, I've set default params in constructor
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

        while(true){ //main menu will keep looping unless option 3 is selected to exit system
            System.out.println("\n=== BOOK STORE HOME SCREEN ===");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int userInput = scanner.nextInt(); //retrieve user's integer input

            if(userInput == 1) { // if option 1 is selected
                    System.out.println("\n=== AVAILABLE BOOKS ===");
                    for (Book book : books) { //enhanced loop to show all books that are not checked out, Goes to Book class, set "book" variable, then get "books" array list
                        if (!book.isCheckedOut()) { //!book.isCheckedOut() is similar to book.isCheckedOut() == false
                            System.out.println(book.getId() + ". " + book.getTitle() + " (" + book.getIsbn() + ")"); //prints the book ID, title, and ISBN
                        }
                    }
                    while(true) { //set it to loop unless option 2 is selected to exit submenu
                        System.out.println("\n1. Check out");
                        System.out.println("2. Exit");
                        System.out.print("Enter Your Choice: ");

                        int userInput1 = scanner.nextInt(); //retrieve user inputs for integer options

                        if (userInput1 == 1) { //if option 1 is selected, name and id input will be requested for check out
                            scanner.nextLine(); //had to add scanner.nextLine() to be able to go from int to String input
                            System.out.println("Name:");
                            String name = scanner.nextLine(); //created a string name variable for input
                            System.out.println("Enter Book ID To Check Out: ");
                            int idInput = scanner.nextInt(); //created idInput variable for int input
                            boolean available = false; //created "available" variable in order to verify if book is checked out or not
                            for (Book book : books) { //enhanced loop
                                if (book.getId() == idInput && !book.isCheckedOut()) { //if Book ID equals Input AND book is not already checked out
                                    book.checkOut(name); //sets the input name in checkOut method, activating isCheckedOut to true from default params (false)
                                    System.out.println(name + " Checked Out: " + book.getTitle()); //print name checked out book title
                                    available = true; //sets book availability to true for check out so ERROR doesn't show
                                }
                            }
                            if(!available){ //if Book ID is invalid due to either book being already checked out or it's not a book ID between 1-20
                                System.out.println("ERROR: Invalid Book ID or Book Checked in"); //prints error...
                                //break; //if I want to bring user back to Main Menu after invalid input
                            }
                        }
                        else if (userInput1 == 2) { //exit option will bring user back to main menu
                            break;
                        }
                        else { //any options other than 1 or 2 will print ERROR
                            System.out.println("ERROR: Invalid Option");
                        }
                    }
            }

            else if(userInput == 2){ // user selects option 2 to view checked out books or to check in
                while(true) { //the submenu can loop unless option 2 is selected to exit
                    boolean available = false;
                    System.out.println("\n=== CHECKED OUT BOOKS ===");
                    for (Book book : books) {
                        if (book.isCheckedOut()) {
                            System.out.println(book.getId() + ". " + book.getTitle() + " (" + book.getIsbn() + ") by " + book.getCheckedOutTo());
                            available = true;
                        }
                    }
                    if(!available){
                        System.out.println("No Books Are Currently Checked Out.");
                    }
                    System.out.println("\n1. Check In");
                    System.out.println("2. Exit");
                    System.out.println("Enter Your Choice: ");

                    int userInput2 = scanner.nextInt();

                    if (userInput2 == 1) {
                        System.out.println("Enter Book ID To Check In: ");
                        boolean valid = false;
                        int idInput = scanner.nextInt();
                        for (Book book : books) {
                            if (book.getId() == idInput && book.isCheckedOut()) {
                                System.out.println("Checked In: " + book.getTitle() + " (" + book.getIsbn() + ") By " + book.getCheckedOutTo());
                                book.checkIn();
                                valid = true;
                            }
                        }
                        if(!valid){
                            System.out.println("Book Is Not Checked Out.");
                        }
                    }
                    else if (userInput2 == 2) { //exit option in order to go Main menu
                        break;
                    }
                    else {
                        System.out.println("ERROR: Invalid Option"); //prints invalid input and will loop in submenu
                    }
                }
            }


            else if(userInput == 3){ //menu exit option
            System.out.println("Goodbye!");
            System.exit(0); //break; does the same thing, used system.exit to follow rules...
            }

            else{ // if any other input in menu, will loop and print error
                System.out.println("ERROR: Invalid Option In Menu");
            }
        }
    }
}