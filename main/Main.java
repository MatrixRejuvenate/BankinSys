package main;
import java.io.*;
import java.util.*;

import main.java.Banking;

//import static java.lang.System.exit;
import static java.lang.System.out;
// import org.junit.jupiter.api.Test;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);// System.in is a standard input stream.
    Banking ob = new Banking();// ob is the reference object of Banking class.
    int g=0;//g variable to check if the user wants to continue.
    boolean h=true;//h variable to check if the user wants to continue.
    while(h)//while loop is used for iterating the Bank service till the user wants to exit.
    {
      g++;// incrementing the value of g.
      if (g==1)//if the value of g is 1 then the user is asked to enter the service he wants to use.
      {
        ob.crf();  // calling the method crf() of Banking class.
      }
    
    out.println("Enter Account Number\nPress -1 if you dont have an account");
    int n = sc.nextInt();// Variable n(Account Number) is used for taking input from the user.
    
    if (ob.isacc(n))// checking if the account number is valid by calling the method isacc() of Banking class.
    {
      if (ob.passwordchk(n))// checking if the password is correct by calling the method passwordchk() of Banking class.
      {
        out.println("Enter choice as per the services: \n1.Money Transfer\n2.Bank Statement\n3.Withdraw\n4.Balance\n5.Deposit\n6.Exit");
        int choice = sc.nextInt();// taking input from the user of the service he wants to use which is stored in the variable choice.
        switch (choice)// using switch case to check the value of choice.
          {
          case 1:
            out.println("Enter Receipent's Account number");// taking input from the user of the receipent's account number.
            int acc1 = sc.nextInt();// storing the value of the receipent's account number in the variable acc1.
            out.println("Enter the Amount");// taking input from the user of the amount.
            double amount = sc.nextDouble();// storing the value of the amount in the variable amount.
            if (ob.isacc(n) && ob.isacc(acc1)) // checking if the receipent's account number is valid by calling the method isacc() of Banking class.
            {
              ob.withdraw(n, amount);// calling the method withdraw() of Banking class with the parameters n and amount denoting the user account number and the amount.
              ob.deposit(acc1, amount);// calling the method deposit() of Banking class with the parameters of acc1 and amount denoting the receipent's account number and the amount.
            }
            break;
          case 2:
            ob.statements(n);// calling the method statements() of Banking class with the parameter n deneoting the user account number.
            break;
          case 3:
            double amt;// declaring amt as a double variable to store the withdrawal amount.
            out.println("Enter the Amount to be withdrawn");// taking input from the user of the amount to be withdrawn.;
            amt = sc.nextInt();// taking input from the user to store the withdrawal amount.
            ob.withdraw(n, amt);// calling the method withdraw() of Banking class with the parameters n and amt denoting the user account number and the amount.
            break;
          case 4:
            ob.balance(n);// calling the method balance() of Banking class with the parameter n denoting the user account number.
            break;
          case 5:
            int amt1;// declaring a variable amt1 to store the deposit amount.
            out.println("Enter the Amount to be Deposited ");// printing the statement
            amt1 = sc.nextInt();// taking input from the user to store the amount to be deposited.
            ob.deposit(n, amt1);// calling the method deposit() of Banking class with the parameters n and amt1 denoting the user account number and the amount.
            break;
          default:// if the user enters any other number than the ones mentioned above then the default case is executed.
            out.println("invalid choice");// printing the statement

        }// end of switch case.

      }// end of inner if statement.
    }// end of outer if statement.
        else // if the account number is invalid then the else case is executed.
          {
           out.println("Account not found");// printing the statement
           out.println("Write True for creating an Account Write False for exiting");
           boolean q = sc.nextBoolean();// taking input of type Boolean from the user to check if the user wants to create an account or not which is stored in the variable q.Here q is a boolean variable.
            if (q)// if the user wants to create an account then the if case is executed. 
               {
               ob.createAccount();// calling the method createAccount() of Banking class with the reference object ob.
               }// end of if case.
         else// if the user does not want to create an account then the else case is executed.
          {
        out.println("Interrupted");// printing the statement
         }// end of else case.

    }// end of else case.
    out.print("Type True to continue and False to exit: ");// printing the statement;
    h=sc.nextBoolean();// taking input from the user to check if the user wants to continue or not which is stored in the variable h.
  }// end of while loop.
    ob.crd();// calling the method crd() of Banking class with the reference object ob.
  }// end of main method.
}// end of Main class.