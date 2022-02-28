/**
 * Book is a parent class to FictionBook and NonFictionBook.
 */

public class Book{   
    String title;
    String author;
    short year;
    long isbn;
    byte ageLimit;
    boolean available;
    
    /**
     * This is a Parameterized Constructor for parent class Book. It sets up the attributes/fields.
     * @param title The title of the book.
     * @param author The author of the book.
     * @param year The year of publication.
     * @param isbn This is a 13 digit numeric unique code asssigned to every book published. Read more at https://www.isbn-international.org/content/what-isbn
     * @param ageLimit The age limit of the book.
     * @param available A bool value to show whether the book is currently availble for someone to borrow at the library.
     */
    public Book(String title, String author, short year, long isbn, byte ageLimit ,boolean available){
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.ageLimit = ageLimit;
        this.available = available;
    }

    public Book(){}

    /**
     * Settr method for availble
     * @param available A bool value to show whether the book is currently availble for someone to borrow at the library.
     */
    public void SetAvailability(boolean availablity){
        available = availablity;
    }

    /**
     * Gettr method for availble
     * @param available A bool value to show whether the book is currently availble for someone to borrow at the library.
     */
    public boolean GetAvailability(){
        return available;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getTitle(){
        return this.title;
    }
    
    public long getIsbn(){
        return this.isbn;
    }


    /**
     * A method to return the name. This consists of title, author and year.
     */
    public String GetName(){
        return title+" By "+author+" ("+year+")";
    }
}