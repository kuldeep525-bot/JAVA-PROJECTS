import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.String;

class Book {
    int bookld;
    String name;
    String author;
    boolean isIssued;

    Book(int bookld, String name, String author) {
        this.bookld = bookld;
        this.name = name;
        this.author = author;
        this.isIssued=false;
    }

    //convert Book object to text or string format
    public String toString() {
         return bookld + "  " + name + "  " + author + "  | Issued: " + isIssued;
    }
}

class Library{

    ArrayList<Book> books = new ArrayList<Book>();

    void addBook() throws IOException {
        try {
            InputStreamReader input = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(input);

            System.out.println("Enter the Book id:");
            int bookld = Integer.parseInt(br.readLine());

            System.out.println("Enter the Book Name:");
            String name = br.readLine();

            System.out.println("Enter the Author:");
            String author = br.readLine();

            Book b = new Book(bookld, name, author);
            books.add(b);//add() is inbuild function in java , but it belongs to arraylist,not itself

            System.out.println("Book Added Successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Please enter only the Number!");
        }
    }

    void viewsBook() {
        System.out.println("------ All Books ------");

        System.out.println("The Total Books added:"+" "+books.size());
        for (Book b : books) {
            System.out.println("The Book Id:"+b.bookld);
            System.out.println("The Book Name:"+b.name);
            System.out.println("The Book Author:"+b.author);
             System.out.println("-----------------------");
        }
    }

    void searchBook() throws IOException
     {

      try {
      InputStreamReader input=new InputStreamReader(System.in);
      BufferedReader br=new BufferedReader(input);
      System.out.println("Enter Book Id or Book Name to Search:");

      String SearchInput=br.readLine();

      boolean found=false;

        for(Book b: books)
        {
          if(String.valueOf(b.bookld).equals(SearchInput) || b.name.equalsIgnoreCase(SearchInput))
          {
            System.out.println("\nBook Found!");
            System.out.println("....INFRORMATION ABOUT BOOK....");
            System.out.println("The Book Id:"+b.bookld);
            System.out.println("The Book Name:"+b.name);
            System.out.println("The Book Author:"+b.author);
            found =true;
            break;
          }
        }

        if(!found)
        {
           System.out.println("No book found!");
            System.out.println("SORRY!!!");
        }
      } 

        catch (NumberFormatException e) {
            System.out.println("Please enter only the Number!");
        }
    }

void issueBook() throws IOException
  {
      InputStreamReader input=new InputStreamReader(System.in);
      BufferedReader br=new BufferedReader(input);
      System.out.println("Enter the Book Name to Issue:");
      String Input=br.readLine();

      boolean found=false;
        //book exits or not
       for(Book b: books)
        {
            if(b.name.equalsIgnoreCase(Input))
            {

            found =true;

            if(b.isIssued==false)
            {
            b.isIssued=true;
            System.out.println("\nBook Issued Successfully!");
            System.out.println("Issued Book Details:");
            System.out.println("Book Id: " + b.bookld);
            System.out.println("Name: " + b.name);
            System.out.println("Author: " + b.author);
          }

          else{
            System.out.println("\nSorry! This book is already issued");
          }
            
          }

        }
        if(!found)
        {
           System.out.println("No book found!");
            System.out.println("SORRY!!!");
        }
  }

    void returnBook() throws IOException {
        InputStreamReader input=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(input);

          System.out.println("Enter the Book Name to Retrun:");
          String Input=br.readLine();
           boolean found=false;

             for(Book b: books)
        {
            if(b.name.equalsIgnoreCase(Input))
            {
            found =true;
            if(b.isIssued==true)
            {
            b.isIssued=false;
            System.out.println("\nBook Return Successfully!");
          }

          else if(b.isIssued==false){
              System.out.println("\nSorry! Firstly to issueBook then retrun it.");
          }
          else{
            System.out.println("\nSorry! This book is already issued");
          } 
          }

        }
        if(!found)
        {
           System.out.println("No book found!");
            System.out.println("SORRY!!!");
        }
  }

void removeBook() throws IOException {

    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(input);

    System.out.println("Enter Book ID to Remove:");
    String userInput = br.readLine();

    boolean removed = false;

    for (Book b : books) {
        if (String.valueOf(b.bookld).equals(userInput)) {
            books.remove(b);
            System.out.println("Book Removed Successfully!");
            removed = true;
            break; 
        }
    }
    if (!removed) {
        System.out.println("Book not found!");
    }
}

}

class main {
    public static void main(String[] args) throws IOException {

        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        Library library = new Library();

        while (true) {
            System.out.println("\n.......LIBRARY MANAGEMENT SYSTEM.........");
            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Remove Book");
            System.out.println("7. Exit\n");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    library.addBook();
                    break;

                case 2:
                    library.viewsBook();
                    break;

                case 3:
                    library.searchBook();
                    break;

                case 4:
                    library.issueBook();
                    break;

                case 5:
                    library.returnBook();
                    break;

                case 6:
                    library.removeBook();
                    break;

                case 7:
                    System.out.println("Thank you for using Library System!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! try again");
            }
        }
    }
}
