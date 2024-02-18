package main.java;
//package main.java;
import java.io.*;// importing the java.io package.
import java.util.*;// importing the java.util package.
//import java.lang.*;
//import static java.lang.System.console;
import static java.lang.System.out;// importing the static java.lang.System.out.

interface procedure //interface which encapsulates the methods of the Banking class.
{// start of interface procedure.
  boolean isacc(int n);// method to check if the account number is valid.

  boolean passwordchk(int d);// method to check if the password is correct.

  void withdraw(int acc, double amount);// method to withdraw the amount from the user account.

  void deposit(int acc, double amount);// method to deposit the amount in the user account.

  void createAccount();// method to create an account.

  void balance(int acc);// method to check the balance of the user account.

  void statements(int acc);// method to check the statements of the user account.
  void crd();// method to reset the database.
  void crf();//to create and reset the acc.txt
  
}// end of interface procedure.

public class Banking implements procedure //Banking class implements the interface procedure.
{// start of Banking class.
  Scanner s = new Scanner(System.in);// Scanner s is used to take input from the user.
  public void crd()// method to reset the database.
  {// start of crd() method.
    try// try block is used to handle the exceptions.
      {// start of try block.
    out.println("thank you for using our bank");// printing the statement.
    File ob9=new File("acc.txt");// creating a file object ob9.
    Scanner sc=new Scanner(ob9);// creating a scanner object sc.
    while(sc.hasNextLine())// while loop is used to iterate the file till the end of the file.
      {// start of while loop.
        String data=sc.nextLine();// data is used to store the data of the file.
        data=data.concat(".txt");// concatenating the data with the .txt extension.
        File ob10=new File(data);// creating a file object ob10.                              
        ob10.delete();// deleting the file.

      }// end of while loop.
      sc.close();// closing the scanner object sc.
  }// end of try block.
    catch(Exception e)// catch block is used to handle the exceptions.
      {// start of catch block.
        e.printStackTrace();// printing the stack trace of the exception which notifies the user about the error.
      }// end of catch block.
  }// end of crd() method.
  
  public void crf()//to create and reset the acc.txt
  {// start of crf() method.
        // File name specified
        try{// try block is used to handle the exceptions.
        File obj = new File("acc.txt");//acc.txt is the name of the file which stores the account numbers
        FileWriter oj=new FileWriter("acc.txt");//creating a file writer object oj to write in the file. 
        oj.write("hello");//writing in the file.
        oj.close();//closing the file writer object.
          FileWriter oj2=new FileWriter("acc.txt");//creating a file writer object oj2 to write in the file.
          oj2.close();//closing the file writer object.
        System.out.println("File Created!" + obj.getName());// printing the statement.
      }// end of try block.
        catch(Exception e)// catch block is used to handle the exceptions.
          {// start of catch block.
            e.printStackTrace();// printing the stack trace of the exception which notifies the user about the error.
          }// end of catch block.
  }// end of crf() method.
  

  public void deposit(int acc, double amount)// method to deposit the amount in the user account. 
  {// start of deposit() method.
    try {// try block is used to handle the exceptions.
      int i = 0;// declaring i as an integer variable to store the value of the account number.
      long p;// declaring p as a long variable to store the address of the file.
      String s4;// declaring s4 as a string variable to store the value of the password.
      String s3 = String.valueOf(acc);// converting the account number to string where the account number is stored in the variable s3.
      s3 = s3.concat(".txt");// adding .txt to the account number to get the file name of the account.
      RandomAccessFile raf = new RandomAccessFile(s3, "rw");// creating a random access file object raf to read and write in the file.Here s3 is the file name and "rw" is the mode of Operation of the file.
      while (true)// while loop is used to iterate the file till the end of the file. 
      {// start of while loop.
        i++;// incrementing the value of i.
        p = raf.getFilePointer();// storing the value of the file pointer in the variable p.
        s4 = raf.readLine();// storing the value of the line in the variable s4.
        if (i == 5)// if the value of i is 5 then the password is stored in the variable s4.
          break;// breaking the loop.
      }// end of while loop.
      int b = Integer.parseInt(s4);// converting the balance from string to integer.
      b += amount;// adding the amount to the balance.
      String b3=String.valueOf(b);// converting the balance to string where the balance is stored in the variable b3.
      raf.seek(p);// setting the file pointer to the position where the password is stored.
      raf.writeBytes(b3);// writing the balance in the file.
      raf.close();// closing the file.
      FileWriter ob4 = new FileWriter(s3, true);// creating a file writer object ob4 to write in the file.
      PrintWriter pw1 = new PrintWriter(ob4);// creating a print writer object pw1 to write in the file.
      pw1.println();// printing a new line.
      pw1.println("deposited " + amount);// printing the statement.
      pw1.close();// closing the print writer object.
      out.println("deposited");// printing the statement.
    }// end of try block. 
    catch (Exception e1) {// catch block is used to handle the exceptions.
      e1.printStackTrace();// printing the stack trace of the exception which notifies the user about the error.
    }// end of catch block.
  }// end of deposit() method.

  @Override// annotation to override the method.
  public void withdraw(int acc, double amount) {// method to withdraw the amount from the user account.

    try {// try block is used to handle the exceptions.
      int i1 = 0;// declaring i1 as an integer variable to store the value of the account number.
      long p1;// declaring p1 as a long variable to store the value of the password.
      String s41;// declaring s41 as a string variable to store the value of the password.
      String s31 = String.valueOf(acc);// converting the account number to string where the account number is stored in the variable s31.
      s31 = s31.concat(".txt");// adding .txt to the account number to get the file name of the account.
      RandomAccessFile raf = new RandomAccessFile(s31, "rw");// creating a random access file object raf to read and write in the file where s31 is the file name and "rw" is the mode of Operation of the file.
      while (true) {// while loop is used to iterate the file till the end of the file.
        i1++;// incrementing the value of i1.
        p1 = raf.getFilePointer();// storing the value of the file pointer in the variable p1.
        s41 = raf.readLine();// storing the value of the line in the variable s41.
        if (i1 == 5)// if the value of i1 is 5 then the password is stored in the variable s41.
          break;// breaking the loop.
      }// end of while loop.
      int b1 = Integer.parseInt(s41);// converting the balance from string to integer.
      if(b1>amount)// if the balance is greater than the amount to be withdrawn then the if case is executed.
      b1 -= amount;// subtracting the amount from the balance.
      else// if the balance is less than the amount to be withdrawn then the else case is executed.
      {// start of else case.
        System.out.println("Insufficient funds");// printing the statement.
        return;// returning from the method.
      }// end of else case.
      String b2=String.valueOf(b1);// converting the balance to string where the balance is stored in the variable b2.
      raf.seek(p1);// setting the file pointer to the position where the password is stored.
      raf.writeBytes(b2);// writing the balance in the file.
      raf.close();// closing the file.
      FileWriter ob41 = new FileWriter(s31, true);// creating a file writer object ob41 to write in the file.
      PrintWriter pw11 = new PrintWriter(ob41);// creating a print writer object pw11 to write in the file.
      pw11.println("\nwithdrawn " + amount);// printing the statement.
      pw11.close();// closing the print writer object.
      out.println("withdrawn");// printing the statement.
    }// end of try block. 
    catch (Exception e1) {// catch block is used to handle the exceptions.
      e1.printStackTrace();// printing the stack trace of the exception which notifies the user about the error.
    }// end of catch block.
 

  }// end of withdraw() method.

  @Override// annotation to override the method.
  public boolean isacc(int n) {// method to check if the account number is valid or not.
    try {// try block is used to handle the exceptions.
      String f=String.valueOf(n);// converting the account number to string where the account number is stored in the variable f.
      File obj = new File("acc.txt");//acc.txt is the name of the file which stores the account numbers
      Scanner sc = new Scanner(obj);// creating a scanner object sc.
      while (sc.hasNextLine()) {// while loop is used to iterate the file till the end of the file.
        String data = sc.nextLine();// data is used to store the data of the file.
        String[] arr = data.split(" ");// splitting the data in the file acc.txt with the space as the delimiter.
        if (arr[0].equalsIgnoreCase(f))// checking if the account number is present in the file acc.txt. 
        {// start of if case.
          out.println("account found");// printing the statement.
          return true;// returning true.
        }// end of if case.
      }// end of while loop.

    }// end of try block. 
    catch (Exception e) {// catch block is used to handle the exceptions.
      e.printStackTrace();// printing the stack trace of the exception which notifies the user about the error.
    }// end of catch block.
    return false;// returning false.
  }// end of isacc() method.

  @Override
  public boolean passwordchk(int d) {// method to check if the password is correct or not.
    try {// try block is used to handle the exceptions.
      int i = 0, j = 5,k=0;// declaring i,j,k as an integer variables to store the value of the account number,password and the index of the password.
      int pin;// declaring pin as an integer variable to store the value of the password.
      String data;// declaring data as a string variable to store the value of the password.
      String ds = String.valueOf(d);// converting the account number to string where the account number is stored in the variable ds.
      String es = ds.concat(".txt");// adding .txt to the account number to get the file name of the account.
      File obj = new File(es);// creating a file object obj to read the file of the account.
      Scanner sc = new Scanner(obj);// creating a scanner object sc.
      while (sc.hasNextLine()) {// while loop is used to iterate the file till the end of the file.Here sc is the scanner object, obj is the file object and hasNextLine() is a method of the scanner class used to check if the file has more lines to read.
        i++;// incrementing the value of i.

          data=sc.nextLine();// storing the value of the line in the variable data.

          String[] arr = data.split(" ");// splitting the data in the file with the space as the delimiter.Here arr is an array of strings, data is the string and Split() is a method of the string class used to split the string into an array of strings.
          if(i==2){// if the value of i is 2 then the password is stored in the variable data.
            out.println("enter pin");// printing the statement.
            pin = s.nextInt();// taking input from the user to store the password.
            if (arr[0].equals(String.valueOf(pin)))// checking if the password is correct.Here arr[0] is the password and String.valueOf(pin) is the password entered by the user.The equals() method is used to compare two strings.
            {// start of if case.            
              return true;// returning true.

            }// end of if case. 
            else {// start of else case.
              out.println("wrong pin");// printing the statement.
              break;// breaking the loop.
            }// end of else case.
          }// end of if statement.

         }// end of while loop.

      sc.close();// closing the scanner object.
    }// end of try block.
     catch (Exception e2) {// catch block is used to handle the exceptions.
      e2.printStackTrace();// printing the stack trace of the exception which notifies the user about the error.
    }// end of catch block.
    return false;// returning false.
  }// end of passwordchk() method.

  @Override
  public void createAccount() {// method to create a new account.
    String s2;// declaring s2 as a string variable to store the value of the account number.
    int a;// declaring a as an integer variable to store the value of the account number.
    boolean p = true;// declaring p as a boolean variable to store the value of the password.
    while (p) {// while loop is used to iterate the file till the end of the file.
      a = (int) (Math.random() * 100000);// generating a random number between 0 and 99999.Here Math.random() is a method of the Math class used to generate a random number between 0 and 1.
      s2 = String.valueOf(a);// converting the account number to string where the account number is stored in the variable s2.
      s2 = s2.concat(".txt");// adding .txt to the account number to get the file name of the account.
      File ob1 = new File(s2);// creating a file object ob1 to read the file of the account.
      if (ob1.exists()) {// checking if the file exists.
        p = true;// setting the value of p to true.
        continue;// continuing the loop.
      }// end of if statement. 
      else {// start of else case.
        try {// try block is used to handle the exceptions.
          File obj = new File("acc.txt");// creating a file object obj to read the file of the account.
          RandomAccessFile raf = new RandomAccessFile("acc.txt", "rw");// creating a random access file object raf to read and write in the file.Here "rw" is the mode of Operation of the file and "acc.txt" is the name of the file and the file is created if it does not exist.
          while (true) {// while loop is used to iterate the file till the end of the file.
            String data = raf.readLine();// storing the value of the line in the variable data.
            if (data == null) {// checking if the line is null.
              String ss = String.valueOf(a);// converting the account number to string where the account number is stored in the variable ss.
              raf.writeBytes("\n" + ss);// writing the account number in the file where the file pointer is at the end of the file and writeBytes() is a method of the RandomAccessFile class used to write bytes in the file.

              break;// breaking the loop.
            }// end of if statement.
          }// end of while loop.
          String pwd;// declaring pwd as a string variable to store the value of the password.
          out.println(a);// printing the account number.
          File ob2 = new File(s2);// creating a file object ob2 to read the file of the account.
          PrintWriter pw = new PrintWriter(new FileWriter(s2));// creating a print writer object pw to write in the file.Here new FileWriter(s2) is used to create a file writer object to write in the file.
          pw.println(a);// writing the account number in the file.
          while(true){// while loop is used to iterate the file till the end of the file.
          out.println("enter your pin");
          pwd = s.nextLine();// taking input from the user to store the password and storing it in the variable pwd.Here the nextLine() method is used to read a line of input from the user.
          if (pwd.length()<8){// checking if the password is less than 8 characters.
            out.println("it should be more than 8 characters");// printing the statement.;
            continue;// continuing the loop.
          }// end of if statement.
          else{// start of else case.
          break;// breaking the loop.
          }// end of else case.
              }// end of while loop.
          pw.println(pwd);// writing the password in the file.
          out.println("enter your name ");// printing the statement.
          String test = s.next();// taking input from the user to store the name and storing it in the variable test.Here the next() method is used to read a single word from the user.
          pw.println(test);// writing the name in the file.
          String test1 ;// declaring test1 as a string variable to store the value of the name.
          while (true){// while loop is used to iterate the file till the end of the file.
          out.println("enter your phone number");
          test1 = s.next();// taking input from the user to store the phone number and storing it in the variable test1.Here the next() method is used to read a line of input from the user.
          if(test1.length()!=10)// checking if the phone number is not 10 digits.
            continue;// continuing the loop.
          else
            break;}// breaking the loop.
          pw.println(test1);// writing the phone number in the file.
          pw.println("0");// writing the balance in the file.
          pw.close();// closing the print writer object.
          break;// breaking the loop.
        }// end of try block.
        catch (Exception e3) {// catch block is used to handle the exceptions.
          e3.printStackTrace();// printing the stack trace of the exception which notifies the user at which line the error occurred and the error itself.
        }// end of catch block.

      }// end of else case.
    }// end of while loop.
  }// end of createAccount() method.

  @Override
  public void balance(int acc) {// method to check the balance of the account.
    try {// try block is used to handle the exceptions.
      int i = 0;// declaring i as an integer variable to store the value of the account number.
      String s5 = String.valueOf(acc);// converting the account number to string where the account number is stored in the variable s5.
      s5 = s5.concat(".txt");// adding .txt to the account number to get the file name of the account.
      File ob6 = new File(s5);// creating a file object ob6 to read the file of the account.
      Scanner sc = new Scanner(ob6);// creating a scanner object sc.
      while (sc.hasNextLine()) {// while loop is used to iterate the file till the end of the file and hasNextLine() is a method of the scanner class used to check if the file has more lines to read.
        i++;// incrementing the value of i.
        String data = sc.nextLine();// storing the value of the line in the variable data.
        if (i == 5) {// checking if the value of i is 5.

          out.println(data);// printing the value of the line in the file.
        }// end of if statement.

      }// end of while loop.
    }// end of try block. 
    catch (Exception e4) {// catch block is used to handle the exceptions.
      e4.printStackTrace();// printing the stack trace of the exception which notifies the user at which line the error occurred and the error itself.
    }// end of catch block.
  }// end of balance() method.

  @Override
  public void statements(int acc) {// method to check the statements of the account.
    try {// try block is used to handle the exceptions.
      int i = 0;// declaring i as an integer variable to store the value of the account number.
      String s6 = String.valueOf(acc);// converting the account number to string where the account number is stored in the variable s6.
      s6 = s6.concat(".txt");// adding .txt to the account number to get the file name of the account.
      File ob7 = new File(s6);// creating a file object ob7 to read the file of the account.
      Scanner sc = new Scanner(ob7);// creating a scanner object sc.
      while (sc.hasNextLine()) {// while loop is used to iterate the file till the end of the file and hasNextLine() is a method of the scanner class used to check if the file has more lines to read.
        i++;// incrementing the value of i.
        String data = sc.nextLine();// storing the value of the line in the variable data.
        if (i >= 6) {// checking if the value of i is greater than or equal to 6.

          out.println(data);// printing the value of the line in the file.
        }// end of if statement.

      }// end of while loop.
    }// end of try block. 
    catch (Exception e5) {// catch block is used to handle the exceptions.
      e5.printStackTrace();// printing the stack trace of the exception which notifies the user at which line the error occurred and the error itself.
    }// end of catch block.

  }// end of statements() method.

}// end of Banking class. 
