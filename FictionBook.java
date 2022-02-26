public class FictionBook extends Book{
    String genre;
    public FictionBook(String title, String author, short year, long isbn, byte ageLimit, boolean available, String genre){
        super(title,author,year,isbn,ageLimit,available);
        this.genre = genre;
    }
}
