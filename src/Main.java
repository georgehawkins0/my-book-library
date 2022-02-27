import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("my-book-library v1.0.0\nPlease enter your custom Library Name: ");
        String libraryName = in.nextLine();  // Read user input

        Library library = new Library(libraryName);
        mainMenu(library);
        in.close();
    }

    static void mainMenu(Library library){
        System.out.println("Main Menu\n");
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Type 1 for Book insert\nType 2 to view all books\nType 3 for Book search");
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
                Book book;

                boolean valid = true;
                switch(fictionOrNonFiction){
                    case "fiction":
                        genre = "fiction";
                        book = new FictionBook(title, author, year, isbn, ageLimit ,available,genre);
                        break;
                    case "non fiction":
                        genre = "non fiction";
                        book = new NonFictionBook(title, author, year, isbn, ageLimit ,available,genre);
                        break;
                    case "non-fiction":
                        genre = "non fiction";
                        book = new NonFictionBook(title, author, year, isbn, ageLimit ,available,genre);
                        break;
                    default:
                        valid = false;
                        System.out.println("Invalid Input");
                }

                if (valid){
                    Boolean sucess = library.AddBook(book);

                    if (sucess == true){
                        System.out.println("\nSucessfully added book to library!");
                    }
                    else{
                        System.out.println("\nAdding book to library was unsucessful.");
                    }
                }
                break;
            }
                    
            case "2":{
                ArrayList<Book> books = Library.returnBookList();
                
                for (Book bookInLoop : books) {
                    String name = bookInLoop.GetName();
                    System.out.println(name); 		
               }
               System.out.println("\n");
            }
          
            case "3":{
                System.out.println("\nBook Search\n");
                in = new Scanner(System.in);
                System.out.println("Would you like to search by Title or author?");
                String searchType = in.next();
                searchType = searchType.toLowerCase();
                boolean valid = false;
                switch(searchType) {
                    case("title"):{
                        valid = true;
                    }
                    case("author"):{
                        valid = true;
                    }
                }

                if (valid == true);
                    in = new Scanner(System.in);
                    System.out.println("What is the search query: ");
                    String searchQuery = in.next();

                    ArrayList<Book> results = library.search(searchType,searchQuery);
                    int length = results.size();
                    System.out.println("Found "+length+" results:");

                    for (Book bookInLoop : results) {
                        String name = bookInLoop.GetName();
                        System.out.println(name);
                    }
                    break;

            }
        }

        mainMenu(library);
    }
}