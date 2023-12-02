/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

/**
 *
 * @author Afnan
 */
public abstract class Person {

    private static String Fname;
    private static String Lname;
    private static String Username;
    private static String Password;
    private static String ID;
    private static int PhoneNum;
    private static String Email;

    public static String getFname() {
        return Fname;
    }

    public static String getLname() {
        return Lname;
    }

    public static String getUsername() {
        return Username;
    }

    public static String getPassword() {
        return Password;
    }

    public static String getID() {
        return ID;
    }

    public static int getPhoneNum() {
        return PhoneNum;
    }

    public static String getEmail() {
        return Email;
    }

    public static void setFname(String Fname) {
        Person.Fname = Fname;
    }

    public static void setLname(String Lname) {
        Person.Lname = Lname;
    }

    public static void setUsername(String Username) {
        Person.Username = Username;
    }

    public static void setPassword(String Password) {
        Person.Password = Password;
    }

    public static void setID(String ID) {
        Person.ID = ID;
    }

    public static void setPhoneNum(int PhoneNum) {
        Person.PhoneNum = PhoneNum;
    }

    public static void setEmail(String Email) {
        Person.Email = Email;
    }

    
}
