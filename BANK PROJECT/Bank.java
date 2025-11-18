import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;

class Account{
int accountNumber;
int pin;
int balance;
ArrayList<String> miniStatement = new ArrayList<String>();

Account(int accountNumber,int pin,int balance)
{
  this.accountNumber=accountNumber;
  this.pin=pin;
  this.balance=balance;
}

boolean validatePin(int enteredPin){
  return this.pin==enteredPin;
}

// void Deposit(){
//   System.out.println("Enter the desposit amount:");
// }
// void Withdraw()
// {
//     System.out.println("Enter the Withdraw amount:");
// }
// void GetBalance()
// {
//     System.out.println("Balance:");
// }

// void AddTransation();
// void GetMiniStatement(){
//     System.out.println("Mini Statement");
// }
}


class AtmMachine{

  Account currentAccount;

  //constructor

  AtmMachine(Account acc)
  {
    this.currentAccount=acc;
  }

boolean login() throws IOException
{
  try{
  InputStreamReader Input=new InputStreamReader(System.in);
  BufferedReader br=new BufferedReader(Input);
  System.out.println("Enter the 4 digit pin:");
  int pin=Integer.parseInt(br.readLine());
  return currentAccount.validatePin(pin);
  }

  catch(java.lang.NumberFormatException e)
  {
    System.out.println("Enter the Pin only Number format:"+e.getMessage());
    return false;
  }
}

void checkBalance() {}
    void withdraw() {}
    void deposit() {}
    void miniStatement() {}
}



class main{
public static void main(String st[]) throws IOException
{
  Account acc=new Account(12345,1234,5000);
  AtmMachine atm=new AtmMachine(acc);
  InputStreamReader Input=new InputStreamReader(System.in);
  BufferedReader br=new BufferedReader(Input);

   System.out.println("----- ATM Login -----");

        if (!atm.login()) {
            System.out.println("Invalid PIN!");
            return;
        }


   while (true) {
            System.out.println("\n.......ATM MENU.........");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Mini Statement");
            System.out.println("5. Exit\n");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
               case 1: atm.checkBalance(); break;
                case 2: atm.withdraw(); break;
                case 3: atm.deposit(); break;
                case 4: atm.miniStatement(); break;
                case 5: System.exit(0);
                default: System.out.println("Invalid Choice!");
            }
        }
}
}