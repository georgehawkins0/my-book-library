import java.util.ArrayList;
import java.time.LocalDateTime;

public class Library {
    String name;
    LocalDateTime creationTime;

    static ArrayList<Book> books = new ArrayList<Book>(); // Create an ArrayList object

    /**
     * This is a Parameterized Constructor for Library. It sets up the attributes/fields.
     * @param name Name of the library.
     */
    public Library(String name){
        this.name = name;
        this.creationTime = LocalDateTime.now();
    }

    /**
     * A method to add a Book to the books array.
     * @param book The given book to add to the array
     */
    public boolean AddBook(Book book){
        return books.add(book);
    }

    public int numberOfBooks(){
        return books.size();
    }
    public static ArrayList<Book> returnBookList(){
        return books;
    }

    public String ReturnLibraryInformation(){
        String name = this.name;
        LocalDateTime creationTime = this.creationTime;
        int size = this.numberOfBooks();
        return "Library "+name+" created on "+creationTime+" has "+size+" books.";

    }

    public ArrayList<Book> search(String seachType, String searchQuery, long searchQueryLong){
        ArrayList<Book> foundBooks = new ArrayList<Book>(); // Create an ArrayList object
        books = returnBookList();

        for (Book bookInLoop : books) {
            String author = bookInLoop.getAuthor();
            author = author.toLowerCase();
            String title = bookInLoop.getTitle();
            title = title.toLowerCase();
            String name = bookInLoop.GetName();
            name = name.toLowerCase();
            long isbn = bookInLoop.getIsbn();
            switch(seachType){
                case("author"):{
                    if (author.equals(searchQuery)){ // you have to use .equals for strings
                        foundBooks.add(bookInLoop);
                    }
                }
                case("title"):{
                    if (title.equals(searchQuery)){
                        foundBooks.add(bookInLoop);
                    }
                }
                case("isbn"):{
                    if (isbn == searchQueryLong){
                        foundBooks.add(bookInLoop);
                    }
                }
            }
            
        }
        return foundBooks; // just to make it fun ffs


    }
}

