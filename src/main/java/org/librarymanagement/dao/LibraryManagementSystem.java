package org.librarymanagement.dao;

import org.librarymanagement.dto.Author;
import org.librarymanagement.dto.Book;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        AuthorDao authorDAO = new AuthorDao();
        BookDao bookDAO = new BookDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System:");
            System.out.println("1. Add Author");
            System.out.println("2. Add Book");
            System.out.println("3. View All Authors");
            System.out.println("4. View All Books");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter author name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter nationality: ");
                    String nationality = scanner.nextLine();

                    Author author = new Author();
                    author.setName(name);
                    author.setNationality(nationality);

                    authorDAO.addAuthor(author);
                    break;

                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("Enter year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter author ID: ");
                    int authorId = scanner.nextInt();

                    Author bookAuthor = authorDAO.getAllAuthors().stream()
                            .filter(a -> a.getId() == authorId)
                            .findFirst()
                            .orElse(null);

                    if (bookAuthor == null) {
                        System.out.println("Author not found!");
                    } else {
                        Book book = new Book();
                        book.setTitle(title);
                        book.setPublisher(publisher);
                        book.setYear(year);
                        book.setPrice(price);
                        book.setAuthor(bookAuthor);

                        bookDAO.addBook(book);
                    }
                    break;

                case 3:
                    authorDAO.getAllAuthors().forEach(a ->
                            System.out.println(a.getId() + ": " + a.getName() + " (" + a.getNationality() + ")"));
                    break;

                case 4:
                    bookDAO.getAllBooks().forEach(b ->
                            System.out.println(b.getTitle() + " by " + b.getAuthor().getName()));
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
