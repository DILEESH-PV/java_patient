import java.sql.*;
import java.util.Scanner;

public class Patient {
    public static void main(String[] args)
    {

        int choice,pid,pin;
        String name,drn,address,symptom;
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

                    System.out.println("Enter the patientID");
                    pid=sc.nextInt();
                    System.out.println("Enter the name");
                    name= sc.next();
                    System.out.println("Enter the Address");
                    address= sc.next();
                    System.out.println("Enter the pin code");
                    pin=sc.nextInt();
                    System.out.println("Enter the phone number");
                    phno=sc.nextDouble();
                    System.out.println("Enter the Symptom");
                    symptom=sc.next();
                    System.out.println("Enter the docter name");
                    drn=sc.next();
                    System.out.println("Added patient details");

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql=" INSERT INTO `patient`(`PatientID`, `Name`, `Address`, `PIN`, `Phno`, `Symptoms`, `Docter`) VALUES (?,?,?,?,?,?,?)";
                        PreparedStatement stmt=con.prepareStatement(sql);
                        stmt.setInt(1,pid);
                        stmt.setString(2,name);
                        stmt.setString(3,address);
                        stmt.setInt(4,pin);
                        stmt.setDouble(5,phno);
                        stmt.setString(6,symptom);
                        stmt.setString(7,drn);
                        stmt.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("view all patient selected");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql="SELECT `PatientID`, `Name`, `Address`, `PIN`, `Phno`, `Symptoms`, `Docter` FROM `patient` ";
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while (rs.next())
                         {
                            String getPid=rs.getString("PatientID");
                            String getName=rs.getString("Name");
                            String getAdr=rs.getString("Address");
                            String getPin=rs.getString("PIN");
                            String getPh=rs.getString("Phno");
                            String getSym=rs.getString("Symptoms");
                            String getDrname=rs.getString("Docter");
                            System.out.println("Patient ID : "+getPid);
                            System.out.println("Name       : "+getName);
                            System.out.println("Address    : "+getAdr);
                            System.out.println("Pin Code   : "+getPin);
                            System.out.println("Symptoms   : "+getSym);
                            System.out.println("DR Name    : "+getDrname+"\n");
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);}

                    break;
                case 3:
                    System.out.println("search a patient selected");
                    System.out.println("Enter the patient id for searching patient");
                    pid= sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql="SELECT `PatientID`, `Name`, `Address`, `PIN`, `Phno`, `Symptoms`, `Docter` FROM `patient` WHERE `PatientID`= "+String.valueOf(pid);
                        Statement stmt=con.createStatement();
                        ResultSet rs=stmt.executeQuery(sql);
                        while (rs.next())
                        {
                            String getPid=rs.getString("PatientID");
                            String getName=rs.getString("Name");
                            String getAdr=rs.getString("Address");
                            String getPin=rs.getString("PIN");
                            String getPh=rs.getString("Phno");
                            String getSym=rs.getString("Symptoms");
                            String getDrname=rs.getString("Docter");
                            System.out.println("Patient ID : "+getPid);
                            System.out.println("Name       : "+getName);
                            System.out.println("Address    : "+getAdr);
                            System.out.println("Pin Code   : "+getPin);
                            System.out.println("Symptoms   : "+getSym);
                            System.out.println("DR Name    : "+getDrname+"\n");
                        }
                    }
                    catch (Exception e){
                        System.out.println(e);}
                    break;
                case 4:
                    System.out.println("update patient selected");
                    System.out.println("Enter the patient id");
                    String pd=sc.next();
                    System.out.println("Enter the Name to be updated");
                    name=sc.next();
                    System.out.println("Enter the address to be updated");
                    address=sc.next();
                    System.out.println("Enter the pin to be updated");
                    pin=sc.nextInt();
                    System.out.println("Enter the phone number to be updated");
                    phno=sc.nextDouble();
                    System.out.println("Enter the symptoms to be updated");
                    symptom=sc.next();
                    System.out.println("Enter the Docter name to be update");
                    drn=sc.next();
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "");
                        String sql = "UPDATE `patient` SET `Name`='" + name + "',`Address`='" + address + "',`PIN`='" + pin + "',`Phno`='" + phno + "',`Symptoms`='" + symptom + "',`Docter`='" + drn + "' WHERE `PatientID`=" + pd;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);}

                    break;
                case 5:
                    System.out.println("Delete a patient selected");
                    System.out.println("Enter the patient id that you want to delete");
                    String pid1=sc.next();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitaldb","root","");
                        String sql="DELETE FROM `patient` WHERE `PatientID`="+pid1;
                        Statement stmt=con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("deleted successfully");

                    }
                    catch (Exception e){
                        System.out.println(e);}

                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Enter correct choice");
            }

        }
    }
}


