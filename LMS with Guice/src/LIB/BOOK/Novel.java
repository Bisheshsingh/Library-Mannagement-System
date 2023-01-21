package LIB.BOOK;

import java.util.List;

public class Novel implements Book{
    private int id;
    private boolean available;
    private String name;
    private List<String> authors;

    public Novel(int id, String name, List<String> authors) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.available=true;
    }

    @Override
    public int getID() {
        return id;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public void Available() {
        this.available=true;
    }

    @Override
    public void Unavailable() {
        this.available=false;
    }
}
