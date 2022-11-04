import java.sql.*;
import java.util.Scanner;

public class Patient {
    public static void main(String[] args)
    {

        int choice,pid,pin;
        String name,drn,adress,symptoms;
        double phno;

        Scanner sc=new Scanner(System.in);
        while (true)
        {
            System.out.println("Select an option");
            System.out.println("1. Add patient");
            System.out.println("2. view all patients");
            System.out.println("3. search a patient");
            System.out.println("4. update patient");
            System.out.println("5. Delete patient");
            System.out.println("6.Exit");

            choice=sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.println("Add patient selected");


                    break;
                case 2:
                    System.out.println("view all patient selected");

                    break;
                case 3:
                    System.out.println("search a patient selected");

                    break;
                case 4:
                    System.out.println("update patient selected");
                    break;
                case 5:
                    System.out.println("Delete a patient selected");

                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
}


