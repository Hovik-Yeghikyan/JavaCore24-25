package classwork.bookStorage;

public interface LibraryCommands {
    String EXIT = "0";
    String ADD_BOOK = "1";
    String ADD_AUTHOR = "2";
    String PRINT_ALL_BOOKS = "3";
    String PRINT_ALL_AUTHORS = "4";
    String SEARCH_BOOK_BY_TITLE = "5";
    String UPDATE_BOOK = "6";
    String DELETE_BOOK = "7";
    String SEARCH_BY_PRICE = "8";
    String SEARCH_BOOK_BY_AUTHOR = "9";




         static void printAllCommands() {
        System.out.println("Please Enter " + EXIT + " for EXIT");
        System.out.println("Please Enter " + ADD_BOOK + " for ADD BOOK");
        System.out.println("Please Enter " + ADD_AUTHOR + " for ADD_AUTHOR");
        System.out.println("Please Enter " + PRINT_ALL_BOOKS + " for PRINT ALL BOOKS");
        System.out.println("Please Enter " + PRINT_ALL_AUTHORS + " for PRINT_ALL_AUTHORS");
        System.out.println("Please Enter " + SEARCH_BOOK_BY_TITLE + " for SEARCH BOOK BY TITLE");
        System.out.println("Please Enter " + UPDATE_BOOK + " for UPDATE BOOK");
        System.out.println("Please Enter " + DELETE_BOOK + " for DELETE BOOK");
        System.out.println("Please Enter " + SEARCH_BY_PRICE + " for SEARCH BOOKS BY PRICE");
        System.out.println("Please Enter " + SEARCH_BOOK_BY_AUTHOR + " for SEARCH_BOOK_BY_AUTHOR");
    }
}
