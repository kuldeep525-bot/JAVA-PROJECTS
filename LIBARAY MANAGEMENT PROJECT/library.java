import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

class BOOK{
  int bookld;
  String title;
  String author;
  boolean isIssued;
}


class Library extends BOOK{

  void addBook() throws IOException
  {

    try{
    InputStreamReader input=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(input);

    System.out.println("Enter the Book id:");
    int id = Integer.parseInt(br.readLine());

    System.out.println("Enter the Name:");
    String name=br.readLine();

    System.out.println("Enter the Author:");
    String author=br.readLine();

    System.out.println("Book Added Successfully!");
    }

    catch(java.lang.NumberFormatException e)
  {
    System.out.println("Please enter only the Number?");
  }

  };
  void viewsBook()
  {
    System.out.println("view book");
  };
  void searchBook()
  {
    System.out.println("search book");
  };
  void issueBook()
  {
    System.out.println("issue book");
  };
  void returnBook()
  {
    System.out.println("return book");
  };
  void removeBook()
  {
    System.out.println("remove book");
  };
  }

class main{
  public static void main(String st[]) throws IOException
  {
    InputStreamReader input=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(input);
    Library library = new Library(); 

    while(true)
    {
      System.out.println("\n.......LIBRARY MANGEMENT SYSTEM");
      System.out.println("1. Add Book");
      System.out.println("2. View Book");
      System.out.println("3. Search Book");
      System.out.println("4. Issues Book");
      System.out.println("5. Return Book");
      System.out.println("6. Remove Book");
      System.out.println("7. Exit");

         System.out.print("Enter your choice: ");

      int choice=Integer.parseInt(br.readLine());

      switch(choice)
      {
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
                    System.out.println("Welcome to coming my Library");
                    System.exit(0);

                    default:
                      System.out.println("Invalid choice! try again");
          
      }
    }
  }
}