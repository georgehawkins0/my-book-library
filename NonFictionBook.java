public class NonFictionBook extends Book{
    String genre;
    public NonFictionBook(String title, String author, short year, long isbn, byte ageLimit, boolean available, String genre){
        super(title,author,year,isbn,ageLimit,available);
        this.genre = genre;
    }
}
