package classwork.bookStorage;

import classwork.bookStorage.model.Author;
import classwork.bookStorage.model.Book;
import classwork.bookStorage.storage.AuthorStorage;
import classwork.bookStorage.storage.BookStorage;
import classwork.bookStorage.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Library implements LibraryCommands {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BookStorage bookstorage = new BookStorage();
    private static final AuthorStorage authorStorage = new AuthorStorage();


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

                case ADD_AUTHOR:
                    addAuthor();
                    break;

                case PRINT_ALL_BOOKS:
                    bookstorage.printAllBooks();
                    break;

                case PRINT_ALL_AUTHORS:
                    authorStorage.printAllAuthors();
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

                case SEARCH_BOOK_BY_AUTHOR:
                    searchBooksByAuthor();
                    break;

                default:
                    System.out.println("Wrong command !!! Please try again");
                    break;
            }
        }
    }

    private static void searchBooksByAuthor() {
        authorStorage.printAllAuthors();
        System.out.println("Please choose author ID");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if (author != null) {
            bookstorage.searchByAuthor(author);
        }
    }

    private static void addAuthor() {
        System.out.println("Please input ID, name, surname, phone, dateOfBirthday(01-10-2000)");
        String authorDataStr = scanner.nextLine();
        String[] authorDataArr = authorDataStr.split(",");
        if (authorDataArr.length == 5) {
            String id = authorDataArr[0];
            if (authorStorage.getAuthorById(id) == null) {
                try {
                Author author = new Author();
                author.setId(id);
                author.setName(authorDataArr[1]);
                author.setSurname(authorDataArr[2]);
                author.setPhone(authorDataArr[3]);
                author.setDateOfBirthday(DateUtil.fromStringToDate(authorDataArr[4]));
                authorStorage.add(author);
                System.out.println("Author added!");
                } catch (ParseException e) {
                    System.out.println("Date of BirthDay is incorrect");;
                }
            } else {
                System.out.println("Author with id " + id + " is already exists!");
            }
        } else {
            System.out.println("Wrong author Id");
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
        authorStorage.printAllAuthors();
        System.out.println("Please choose author ID");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if (author != null) {
            System.out.println("Please enter id");
            String id = scanner.nextLine();
            System.out.println("Please enter title");
            String title = scanner.nextLine();
            System.out.println("Please enter price");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Please enter quantity");
            int quantity = Integer.parseInt(scanner.nextLine());
            Book book = new Book(id, title, author, price, quantity,new Date());
            Book bookById = bookstorage.getBookById(id);
            if (bookById == null) {
                bookstorage.add(book);
                System.out.println("Book added!");

            } else {
                System.out.println("Book is already exists!");
            }
        }

    }

    private static void updateBook() {
        System.out.println("Please inter id for update book");
        String id = scanner.nextLine();
        Book book = bookstorage.getBookById(id);
        if (book != null) {
            authorStorage.printAllAuthors();
            System.out.println("Please choose author ID");
            String authorId = scanner.nextLine();
            Author author = authorStorage.getAuthorById(authorId);
            if (author != null) {
                System.out.println("Please enter new title");
                String title = scanner.nextLine();
                System.out.println("Please enter new price");
                String priceStr = scanner.nextLine();
                System.out.println("Please enter new quantity");
                String quantityStr = scanner.nextLine();
                if (title != null && !title.isEmpty()) {
                    book.setTitle(title);
                }
                book.setAuthor(author);
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
        System.out.println("Please enter minimum and maximum prices");
        String pricesStr = scanner.nextLine();
        String[] pricesArray = pricesStr.split("-");
        if (pricesArray.length == 2) {
            try {
                double min = Double.parseDouble(pricesArray[0]);
                double max = Double.parseDouble(pricesArray[1]);
                bookstorage.searchByPrice(min, max);
            } catch (NumberFormatException e) {
                System.out.println("Please input only digits!");
            }


        }
    }
}
