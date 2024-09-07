package classwork.bookStorage;

import java.util.Scanner;

public class Library implements LibraryCommands {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookStorage bookstorage = new BookStorage();


    public static void main(String[] args) {
        boolean isRun = true;
        while (isRun) {
            LibraryCommands.printAllCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookstorage.printAllBooks();
                    break;
                case SEARCH_BOOK_BY_TITLE:
                    searchBookByTitle();
                    break;
                case UPDATE_BOOK:
                    updateBook();
                    break;
                case DELETE_BOOK:
                    deleteBookByID();
                    break;
                case SEARCH_BY_PRICE:
                    searchBookByPrice();
                    break;
                default:
                    System.out.println("Wrong command !!! Please try again");
                    break;
            }
        }
    }


    private static void deleteBookByID() {
        System.out.println("Please enter book id which you to delete");
        String id = scanner.nextLine();
        Book bookById = bookstorage.getBookById(id);
        if (bookById != null) {
            bookstorage.deleteBookById(id);
            System.out.println("Book is deleted");
        } else {
            System.out.println("No any book for delete");
        }
    }




    private static void addBook() {
        System.out.println("Please enter id");
        String id = scanner.nextLine();
        System.out.println("Please enter title");
        String title = scanner.nextLine();
        System.out.println("Please enter author name");
        String authorName = scanner.nextLine();
        System.out.println("Please enter price");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please enter quantity");
        int quantity = Integer.parseInt(scanner.nextLine());
        Book book = new Book(id, title, authorName, price, quantity);
        Book bookById = bookstorage.getBookById(id);
        if (bookById == null) {
            bookstorage.add(book);
            System.out.println("Book added!");

        } else {
            System.out.println("Book is already exists!");
        }
    }

    private static void updateBook() {
        System.out.println("Please inter id for update book");
        String id = scanner.nextLine();
        Book book = bookstorage.getBookById(id);
        if (book != null) {
            System.out.println("Please enter new title");
            String title = scanner.nextLine();
            System.out.println("Please enter new author name");
            String authorName = scanner.nextLine();
            System.out.println("Please enter new price");
            String priceStr = scanner.nextLine();
            System.out.println("Please enter new quantity");
            String quantityStr = scanner.nextLine();
            if (title != null && !title.isEmpty()) {
                book.setTitle(title);
            }
            if (authorName != null && !authorName.isEmpty()) {
                book.setAuthorName(authorName);
            }
            if (priceStr != null && !priceStr.isEmpty()) {
                book.setPrice(Double.parseDouble(priceStr));
            }
            if (quantityStr != null && !quantityStr.isEmpty()) {
                book.setQuantity(Integer.parseInt(quantityStr));
            }
            System.out.println("Book updated!");
        } else {
            System.out.println("Book with id " + id + " is not exists");
        }

    }


    private static void searchBookByTitle() {
        System.out.println("Please title for search");
        String title = scanner.nextLine();
        if (bookstorage.searchBookByTitle(title) == null) {
            System.out.println("Cant find any book with " + title + " title");
        } else if (!title.isEmpty()) {
            System.out.println(bookstorage.searchBookByTitle(title));
        } else {
            System.out.println("Please enter any word");
        }
    }

    private static void searchBookByPrice() {
        System.out.println("Please enter minimum price");
        String minStr = scanner.nextLine();
        System.out.println("Please enter maximum price");
        String maxStr = scanner.nextLine();
        Book[] book = bookstorage.searchByPrice(Double.parseDouble(minStr), Double.parseDouble(maxStr));
        for (Book book1 : book) {
            if (book1 != null) {
                System.out.println(book1);
            }
        }
    }
}
