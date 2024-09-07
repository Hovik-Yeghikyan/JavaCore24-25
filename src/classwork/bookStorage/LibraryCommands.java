package classwork.bookStorage;

public interface LibraryCommands {
    String EXIT = "0";
    String ADD_BOOK = "1";
    String PRINT_ALL_BOOKS = "2";
    String SEARCH_BOOK_BY_TITLE = "3";
    String UPDATE_BOOK = "4";
    String DELETE_BOOK = "5";
    String SEARCH_BY_PRICE = "6";




         static void printAllCommands() {
        System.out.println("Please Enter " + EXIT + " for EXIT");
        System.out.println("Please Enter " + ADD_BOOK + " for ADD BOOK");
        System.out.println("Please Enter " + PRINT_ALL_BOOKS + " for PRINT ALL BOOKS");
        System.out.println("Please Enter " + SEARCH_BOOK_BY_TITLE + " for SEARCH BOOK BY TITLE");
        System.out.println("Please Enter " + UPDATE_BOOK + " for UPDATE BOOK");
        System.out.println("Please Enter " + DELETE_BOOK + " for DELETE BOOK");
        System.out.println("Please Enter " + SEARCH_BY_PRICE + " for SEARCH BOOKS BY PRICE");
    }
}
