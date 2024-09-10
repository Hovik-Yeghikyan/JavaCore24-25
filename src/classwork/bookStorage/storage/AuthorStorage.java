package classwork.bookStorage.storage;

import classwork.bookStorage.model.Author;

public class AuthorStorage {

    Author[] authors = new Author[10];
    private int size;

    public void add(Author author) {
        if (size == authors.length) {
            extend();
        }
        authors[size++] = author;

    }

    private void extend() {
        Author[] tmp = new Author[size + 10];
        System.arraycopy(authors, 0, tmp, 0, authors.length);
        authors = tmp;

    }

    public void printAllAuthors() {
        for (int i = 0; i < size; i++) {
            System.out.println(authors[i]);
        }
    }


    public Author getAuthorById(String id) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getId().equals(id)) {
                return authors[i];
            }
        }
        return null;
    }

    public void deleteAuthorById(String id) {
        int index = getAuthorIndex(id);
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                authors[i - 1] = authors[i];
            }
            size--;
        }

    }

    private int getAuthorIndex(String id) {
        for (int i = 0; i < size; i++) {
            if (authors[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}


