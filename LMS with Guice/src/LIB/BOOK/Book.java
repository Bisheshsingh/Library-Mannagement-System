package LIB.BOOK;

import java.util.List;

public interface Book {
    int getID();

    boolean isAvailable();

    String getName();

    List<String> getAuthors();
    void Available();
    void Unavailable();
}
