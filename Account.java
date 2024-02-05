import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

    /* Set the customer number */
    public int setCustomerNumber(int customerNumber){
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    /* Get the customer number */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /* Set pin number */
    public int setPinNumber(int pinNumber){
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* Get the pin number */
    public int getPinNumber(){
        return pinNumber;
    }

    /* Get checking Account Balance */
    public double getCheckingBalance(){
        return checkingBalance;
    }

    /* Get saving Balance */
    public double getSavingBalance(){
        return savingBalance;
    }

    /* Calculate checking Account withdrawal */
    public double calcCheckingWithdraw(double amount){
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }

    /* Calculate saving account withdrawal*/
    public double calcSavingWithdraw(double amount){
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    /* Calculate the checking account deposit */
    public double calcCheckingDeposit(double amount){
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }

    /* Calculate the saving account deposit */
    public double calcSavingDeposit (double amount){
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    /* Customer checking account withdrawal input */
    public void getCheckingWithdrawInput(){
        System.out.println("Checking Account Balance : "+ moneyFormat.format(checkingBalance));
        System.out.print("Amount you want to withdraw from checking Account :");
        double amount = input.nextDouble();
        if((checkingBalance - amount) >= 0){
            calcCheckingWithdraw(amount);
            System.out.println("New Checking Account balance : " + moneyFormat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }

    /* Customer saving account withdrawal input */
    public void getSavingWithdrawInput(){
        System.out.println("Saving Account Balance : " + moneyFormat.format(savingBalance));
        System.out.print("Among you want to withdraw from saving account :");
        double amount = input.nextDouble();
        if((savingBalance - amount)>0){
            calcSavingWithdraw(amount);
            System.out.println("New saving account balance : " + savingBalance + "\n");
        } else {
            System.out.println("Balance cannot be negative ." + "\n");
        }
    }

    /* Customer checking account deposit input */
    public void getCheckingDepositInput(){
            System.out.println("Checking Account Balance :" + moneyFormat.format(checkingBalance));
            System.out.print("Amount you want to deposit from Checking Account :");
            double amount = input.nextDouble();
        if((savingBalance - amount) >= 0){
            calcSavingDeposit(amount);
            System.out.println("New Saving balance :" + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Blance cannot be negative ." + "\n");
        }
    }
    public void getSavingDepositInput(){
        System.out.println("Saving Account Balance:" + moneyFormat.format(savingBalance));
        System.out.println("Amount you want to deposit from saving Account: ");
        double amount = input.nextDouble();

        if((savingBalance + amount) >= 0){
            calcSavingDeposit(amount);
            System.out.println("New Saving Account balance: " + moneyFormat.format(savingBalance));
        }
        else{
            System.out.println("Balance cannot be negative." + "\n");
        }
    }  
    private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;
}
