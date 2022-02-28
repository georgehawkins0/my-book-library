import java.util.Scanner;
import java.util.ArrayList;

/**
 * A simple library script to add books, search for a specific book, and view all.  
 * @author  www.github.com/georgehawkins0
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("my-book-library v1.0.0\nPlease enter your custom Library Name: ");
        String libraryName = in.nextLine();  // Read user input

        Library library = new Library(libraryName);

        boolean testing = false; // for when tesing. auto adds a book so I dont have to add one each time I test something.
        if (testing){
            short year = 1; 
            long isbn = 1;
            byte ageLimit = 1;
            Book book = new FictionBook("title", "author", year, isbn, ageLimit ,true,"fiction");

            library.AddBook(book);
        }
        mainMenu(library);
        in.close();
    }

    static void mainMenu(Library library){
        System.out.println("Main Menu\n");
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Type 1 for Book insert\nType 2 to view all books\nType 3 for Book search\nType 4 for Library information");
        String menuOption = in.next();  // Read user input

        switch(menuOption) {
            case "1":{
                System.out.println("\nBook Insert\n");
                in = new Scanner(System.in);
                System.out.println("Title: ");
                String title = in.nextLine();

                in = new Scanner(System.in);
                System.out.println("Author: ");
                String author = in.nextLine();

                in = new Scanner(System.in);
                System.out.println("Year: ");
                short year = in.nextShort();

                in = new Scanner(System.in);
                System.out.println("ISBN: ");
                int isbn = in.nextInt();

                in = new Scanner(System.in);
                System.out.println("Age Limit: ");
                byte ageLimit = in.nextByte();

                in = new Scanner(System.in);
                System.out.println("Available?: ");
                Boolean available = in.nextBoolean();

                in = new Scanner(System.in);
                System.out.println("Fiction or Non fiction?: ");
                String fictionOrNonFiction = in.nextLine();
                fictionOrNonFiction = fictionOrNonFiction.toLowerCase();
                String genre;

                boolean valid = true;
                switch(fictionOrNonFiction){
                    case "fiction":{
                        Book book = new FictionBook(title, author, year, isbn, ageLimit ,available,"fiction");
                        Boolean sucess = library.AddBook(book);

                        if (sucess == true){
                            System.out.println("\nSucessfully added book to library!");
                        }
                        else{
                            System.out.println("\nAdding book to library was unsucessful.");
                        }
                        break;
                    }
                    case "non fiction":
                    case "non-fiction":{
                        Book book = new NonFictionBook(title, author, year, isbn, ageLimit ,available,"Non fiction");
                        Boolean sucess = library.AddBook(book);

                        if (sucess == true){
                            System.out.println("\nSucessfully added book to library!");
                        }
                        else{
                            System.out.println("\nAdding book to library was unsucessful.");
                        }
                        break;
                    }
                    default:
                        System.out.println("Invalid Input");
                }
                break;
            }
                    
            case "2":{
                ArrayList<Book> books = Library.returnBookList();
                int size = books.size();
                for (Book bookInLoop : books) {
                    String name = bookInLoop.GetName();
                    System.out.println(name); 		
               }
               if (size == 0){ // if there is nothing in the books array that is returned
                   System.out.println("No books in library!");
               }
               System.out.println("\n");
               break;
            }
          
            case "3":{
                System.out.println("\nBook Search\n");
                in = new Scanner(System.in);
                System.out.println("Would you like to search by Title, author, or ISBN?");
                String searchType = in.next();
                searchType = searchType.toLowerCase();
                boolean valid = false;
                switch(searchType) {
                    case("title"):
                    case("author"):
                    case("isbn"):
                        valid = true;
                }

                String searchQuery = "";
                long searchQueryLong = 0;

                if (valid == true){
                    in = new Scanner(System.in);
                    System.out.println("What is the search query: ");
                    switch(searchType){
                        case("isbn"):{
                            searchQueryLong = in.nextLong();
                            break;
                        }
                        default:{
                            searchQuery = in.next();
                            break;
                        }
                    }
                    

                    ArrayList<Book> results = library.search(searchType,searchQuery,searchQueryLong);
                    int length = results.size();
                    System.out.println("Found "+length+" results:");

                    for (Book bookInLoop : results) {
                        String name = bookInLoop.GetName();
                        System.out.println(name);
                    }
                    System.out.println("\n");
                }
                break;
                    
            }
            case "4":
                String generalInfo = library.ReturnLibraryInformation();
                System.out.println(generalInfo);
            
        }

        mainMenu(library);
    }
}