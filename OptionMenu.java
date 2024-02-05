import java.io.IOException;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.HashMap;
import java.text.DecimalFormat;

public class OptionMenu extends Account {
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat ("'$' ###,## 0.00");
    HashMap <Integer,Integer> data = new HashMap <Integer,Integer>();

    public void getLogin() throws IOException{
        int x = 1;
        do{
            try{
                data.put(9876543,9876);
                data.put(8989898,1890);
                
                System.out.print("Welcome to the Atm project!");
                System.out.print("Enter Your Customer Number : ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("Enter Your Pin Number :");
                setPinNumber(menuInput.nextInt());
            }
            catch (Exception e){
                System.out.println("\n"+"Invalid character(s).Only numbers."+"\n");
                x = 2;
            }   
            for(Entry<Integer, Integer>entry : data.entrySet()){
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()){
                    getAccountType();
                }
            }
            System.out.println("\n" + " wrong CustomerNumber or PinNumber." + "\n");
        } while(x == 1);
    }

    // Mehtod 1
    public void getAccountType(){
        System.out.println("Select the Account ypu want to access:");
        System.out.println("Type 1-Checking Account");
        System.out.println("Type 2-Checking Account");
        System.out.println("Type 3-Saving Account");
        System.out.print("Choice : ");

        selection = menuInput.nextInt();

        switch (selection) {
        case 1:
            getChecking();
            break;

        case 2:
            getSavingBalance();
            break;

        case 3:
            System.out.println("Thank You for using this Atm , bye.");
            break;

        default:
            System.out.println("\n" + "Invalid Choice ." + "\n");
            getAccountType();
        }
    }


    public void getChecking(){
        System.out.println("Checking Account :");
        System.out.println("Type 1- View Balance");
        System.out.println("Type 2- Withdraw Funds");
        System.out.println("Type 3- Deposit Funds");
        System.out.println("Type 4- Exit");
        System.out.print("Choice :");   
        selection = menuInput.nextInt();

        switch (selection){
        case 1:
            System.out.println("Saving Account Balance :" + moneyFormat.format(getCheckingBalance()));
            getAccountType();
            break;
        case 2:
            getCheckingWithdrawInput();
            getAccountType();
            break;
        case 3:
            getCheckingDepositInput();
            getAccountType();
            break;
        case 4:
            System.out.println("Thank You for using this Atm , bye.");
            break;
        default : 
            System.out.println("\n" + "Invalid Choice ." + "\n");
            getChecking();
        }
    }

    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type - 1 - View Balance ");
        System.out.println("Type - 2 - Withdraw Funds ");
        System.out.println("Type - 3 - Deposit Funds ");
        System.out.println("Type - 4 - Exit ");
        System.out.print("Choise: ");

        selection = menuInput.nextInt();

        switch(selection){
        case 1:
            System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
            getAccountType();
            break;

        case 2:
            getSavingWithdrawInput();
            getAccountType();
            break;
        case 3:
            getCheckingDepositInput();
            getAccountType();
        case 4:
            System.out.println("Thank you for using ATM, bye");
            break;
        default:
            System.out.println("\n" + "Invalid choise." + "\n");
            getSaving();
        }
    }
    int selection;
}