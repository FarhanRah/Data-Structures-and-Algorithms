import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private int availableBooks = 0;
    private int notLent = 0;
    private int lentOut = 0;

    // Constructors
    public Library() {
        // Generating four books and placing them on the shelves
        String[] bookNames = {"Charlotte's Web", "Magic Treehouse", "Charlie & The Chocolate Factory", "Wrinkle in Time"};
        String[] authors = {"Garth Williams", "Mary Pope Osborne", "Roald Dahl", "Madeleine L'Engle"};
        books = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Book temp = new Book(bookNames[i], authors[i], true, i);
            books.add(temp);
            availableBooks++;
            notLent++;
        }
    }

    // Additional functions
    // checkingOut simply changes the status of the book, it reserves its slot until it is returned.
    public void checkingOut(int id) {
        try {
            if (id < 0 || id > books.size()) {
                throw new ArrayIndexOutOfBoundsException("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
            }

            if (!books.get(id).getAvailable()) {
                System.out.println("[LIBRARY ERROR] Book with ID: " + id + " is already lent out, wait for it to be returned!");
            } else {
                books.get(id).setAvailable(false);
                notLent--;
                lentOut++;
                System.out.println("Book with ID: " + id + " has been successfully lent.");
            }
        } catch(ArrayIndexOutOfBoundsException error) {
            System.out.println("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
        }
    }
    public void returning(int id) {
        try {
            if (id < 0 || id > books.size()) {
                throw new ArrayIndexOutOfBoundsException("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
            }

            if (books.get(id).getAvailable()) {
                System.out.println("[LIBRARY ERROR] Book with ID: " + id + " is already available on our shelves, it has not been LENT!");
            } else {
                books.get(id).setAvailable(true);
                notLent++;
                lentOut--;
                System.out.println("The book with ID: " + id + " has been successfully returned.");
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
        }
    }
    public void status(int id) {
        try {
            if (id < 0 || id > books.size()) {
                throw new ArrayIndexOutOfBoundsException("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
            }
            String bookStatus = (books.get(id).getAvailable()) ? "available" : "not available";
            System.out.println("The book named " + books.get(id).getName() + " at ID: " + id + " is currently " + bookStatus + ".");
        } catch(ArrayIndexOutOfBoundsException error) {
            System.out.println("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
        }
    }
    public void name(int id) {
        try {
            if (id < 0 || id > books.size()) {
                throw new ArrayIndexOutOfBoundsException("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
            }
            System.out.println("Name of the book at ID: " + id + " is: " + books.get(id).getName() + ".");
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
        }
    }
    public void remove(int id) {
        try {
            if (id < 0 || id > books.size()) {
                throw new ArrayIndexOutOfBoundsException("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
            }

            if (!books.get(id).getAvailable()) {
                System.out.println("[LIBRARY ERROR] Sorry you can not remove a book that is currently lent out!");
            } else {
                books.set(id, null);
                availableBooks--;
                notLent--;
                System.out.println("Book at ID: " + id + " has been successfully removed from the shelves.");
            }
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
        }
    }
    // I have made two add methods, one requires a precise ID and the other one looks for any empty slot and adds the book there
    public void add(int id, Book b) {
        if (books.get(id) == null) {
            System.out.println("Book has been successfully added at empty slot ID: " + id + ".");
            books.set(id, b);
            availableBooks++;
            notLent++;
        } else {
            System.out.println("[LIBRARY ERROR] Sorry, the slot you provided is not empty.");
        }
    }
    public void add(Book b) {
        if (availableBooks == books.size()) {
            System.out.println("Sorry the book can not be added to our shelves right now (max numbers of books already available)!");
        } else {
            for (int i = 0; i < books.size(); i++) {
                if (books.get(i) == null) {
                    b.setId(i);
                    books.set(i, b);
                    availableBooks++;
                    notLent++;
                    System.out.println("Book has been successfully added at empty slot ID: " + i + ".");
                    break;
                }
            }
        }
    }
    public void swap(int id, Book b) {
        try {
            if (id < 0 || id > books.size()) {
                throw new ArrayIndexOutOfBoundsException("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
            }
            System.out.println("The book at ID: " + id + " has been swapped.");
            books.set(id, b);
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("The index needs to be between 0 and " + (books.size() - 1) + " (inclusive).");
        }
    }
    public void numOfBooks() {
        System.out.println("Our library currently has a total of: " + availableBooks + " books.");
        System.out.println("\tAvailable: " + notLent);
        System.out.println("\tLent out: " + lentOut);
    }
    public void print() {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i) != null) {
                books.get(i).print();
            } else {
                System.out.println("No book available in ID: " + i + ".");
            }
        }
    }
}

class Book {

    private String name;
    private String author;
    private boolean isAvailable;
    private int id;

    // Constructors
    public Book(String name, String author, boolean isAvailable, int id) {
        this.name = name;
        this.author = author;
        this.isAvailable = isAvailable;
        this.id = id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getAuthor() {
        return author;
    }
    public boolean getAvailable() {
        return isAvailable;
    }
    public int getId() {
        return id;
    }

    // Additional functions
    public void print() {
        System.out.println("------------------------");
        System.out.println("Name: " + name);
        System.out.println("Author: " + author);
        String available = (isAvailable) ? "Yes" : "No";
        System.out.println("Currently Available: " + available + ".");
        System.out.println("ID: " + id);
        System.out.println("------------------------");
    }
}
