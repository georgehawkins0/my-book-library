import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Library Name: ");
        String libraryName = in.nextLine();  // Read user input

        Library library = new Library(libraryName);
        mainMenu(library);
        in.close();
    }

    static void mainMenu(Library library){
        Scanner in = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Type 1 for Book insert\nType 2 to view all books");
        String menuOption = in.next();  // Read user input

        switch(menuOption) {
            case "1":{
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
                fictionOrNonFiction.toLowerCase();
                String genre;
                Book book;

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
                        book = new NonFictionBook(title, author, year, isbn, ageLimit ,available,"Fiction");
                        System.out.println("Invalid Input");
                }

                Boolean sucess = library.AddBook(book);

                if (sucess == true){
                    System.out.println("Sucessfully added book to library!");
                }
                else{
                    System.out.println("Adding book to library was unsucessful.");
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
          }
        mainMenu(library);
    }
}