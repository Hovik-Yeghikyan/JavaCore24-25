package classwork.bookStorage.storage;

import classwork.bookStorage.model.Author;
import classwork.bookStorage.model.Book;

public class BookStorage {

    Book[] books = new Book[10];
    private int size;

    public void add(Book book) {
        if (size == books.length) {
            extend();
        }
        books[size++] = book;

    }

    private void extend() {
        Book[] tmp = new Book[size + 10];
        System.arraycopy(books, 0, tmp, 0, books.length);
        books = tmp;

    }

    public void printAllBooks() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public Book searchBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book getBookById(String id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equals(id)) {
                return books[i];
            }
        }
        return null;
    }

    public void deleteBookById(String id) {
        int index = getBookIndex(id);
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                books[i - 1] = books[i];
            }
            size--;
        }

    }

    private int getBookIndex(String id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void searchByPrice(double minPrice, double maxPrice) {
        minPrice = Math.min(minPrice, maxPrice);
        maxPrice = Math.max(maxPrice, minPrice);
        for (int i = 0; i < size; i++) {
            if (books[i].getPrice() >= minPrice && books[i].getPrice() <= maxPrice) {
                System.out.println(books[i]);
            }
        }
    }

    public void searchByAuthor(Author author) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(author)) {
                System.out.println(books[i]);
            }
        }
    }
}


