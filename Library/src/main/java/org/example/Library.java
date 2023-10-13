package org.example;

import java.util.Scanner;

import java.util.Scanner;
public class Library {
    public static void main(String[] args) {
        Book[] inventory = new Book[20];


        inventory[0] = new Book(1, "000-0-00-00000-0", "Book One");
        inventory[1] = new Book(2, "000-0-00-00000-1", "Book Two");
        inventory[2] = new Book(3, "000-0-00-00000-2", "Book Three");
        inventory[3] = new Book(4, "000-0-00-00000-3", "Book Four");
        inventory[4] = new Book(5, "000-0-00-00000-4", "Book Five");
        inventory[5] = new Book(6, "000-0-00-00000-5", "Book Six");
        inventory[6] = new Book(7, "000-0-00-00000-6", "Book Seven");
        inventory[7] = new Book(8, "000-0-00-00000-7", "Book Eight");
        inventory[8] = new Book(9, "000-0-00-00000-8", "Book Nine");
        inventory[9] = new Book(10, "000-0-00-00000-9", "Book Ten");
        inventory[10] = new Book(11, "000-0-00-00001-0", "Book Eleven");
        inventory[11] = new Book(12, "000-0-00-00001-1", "Book Twelve");
        inventory[12] = new Book(13, "000-0-00-00001-2", "Book Thirteen");
        inventory[13] = new Book(14, "000-0-00-00001-3", "Book Fourteen");
        inventory[14] = new Book(15, "000-0-00-00001-4", "Book Fifteen");
        inventory[15] = new Book(16, "000-0-00-00001-5", "Book Sixteen");
        inventory[16] = new Book(17, "000-0-00-00001-6", "Book Seventeen");
        inventory[17] = new Book(18, "000-0-00-00001-7", "Book Eighteen");
        inventory[18] = new Book(19, "000-0-00-00001-8", "Book Nineteen");
        inventory[19] = new Book(20, "000-0-00-00001-9", "Book Twenty");

        Scanner scanner = new Scanner(System.in);




        while (true) {
            System.out.println("Store Home Screen:");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    showAvailableBooks(inventory);
                    break;
                case 2:
                    showCheckedOutBooks(inventory);
                    break;
                case 3:
                    System.out.println("Exiting the Book Store. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    public static void showAvailableBooks(Book[] inventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Available Books:");
        for (Book book : inventory) {
            if (book != null && !book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() +
                        ", ISBN: " + book.getIsbn() +
                        ", Title: " + book.getTitle());
            }
        }
        System.out.println("Enter the ID of the book to check out, or 'exit' to go back to the home screen:");
        String input = scanner.nextLine();
        if (!input.equalsIgnoreCase("exit")) {
            int bookId = Integer.parseInt(input);
            checkOutBook(bookId, inventory);
        }
    }
    public static void showCheckedOutBooks(Book[] inventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Checked Out Books:");
        for (Book book : inventory) {
            if (book != null && book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() +
                        ", ISBN: " + book.getIsbn() +
                        ", Title: " + book.getTitle() +
                        ", Checked Out To: " + book.getCheckedOutTo());
            }
        }
        System.out.println("Enter 'C' to check out a book, or 'X' to go back to the home screen:");
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("C")) {
            System.out.println("Enter the ID of the book to check in:");
            int bookId = Integer.parseInt(scanner.nextLine());
            checkInBook(bookId, inventory);
        }
    }
        public static void checkOutBook (int bookId, Book[] inventory){
        Scanner scanner = new Scanner(System.in);
            for (Book book : inventory) {
                if (book != null && book.getId() == bookId && !book.isCheckedOut()) {
                    System.out.println("Enter your name to check out the book:");
                    String name = scanner.nextLine();
                    book.setCheckedOutTo(name);
                    System.out.println("Book checked out successfully!");
                    return;
                }
            }
            System.out.println("Invalid book ID or the book is already checked out.");
        }
        public static void checkInBook ( int bookId, Book[] inventory){
            for (Book book : inventory) {
                if (book != null && book.getId() == bookId && book.isCheckedOut()) {
                    System.out.println("Book checked in successfully!");
                    return;
                }
            }
            System.out.println("Invalid book ID or the book is not checked out.");
        }
    }



