/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginsystem;

/**
 *
 * @author tumim
 */

import java.util.Scanner;

public class LoginSystem {

static String storedUsername = "";
static String storedPassword = "";
static String firstName = "";
static String lastName = "";

public static void main(String[] args) {

Scanner input = new Scanner(System.in);

System.out.println("=== REGISTER ===");

System.out.print("Enter first name:");
firstName = input.nextLine();

System.out.print("Enter last name:");
lastName = input.nextLine();

System.out.print("Enter username:");
String username = input.nextLine(); 

if (checkUserName(username)) {
System.out.println("Username successfully capture");
} else {
System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length");
return;
}

System.out.print("Enter password:");
String password = input.nextLine();

if (checkPasswordComplexity(password)) {
System.out.println("Password successfully");
} else {
System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character");
return;
}

System.out.print("Enter cell phone number:");
String cell = input.nextLine();

if (checkCellPhoneNumber(cell)) {
System.out.println("cell phone number successfully added");
} else {
System.out.println("cell phone number is incorrectly formatted; please ensure it starts with +27 and is 12 digits long");
return;
}

String message = registerUser(username, password);
System.out.println(message);

System.out.println("\n=== LOGIN ===");

System.out.print("Enter username:");
String loginUser = input.nextLine();

System.out.print("Enter password:");
String loginPass = input.nextLine();

boolean login = loginUser(loginUser, loginPass); 

System.out.println(returnLoginStatus(login));

input.close();
}

// Username check
public static boolean checkUserName(String username) {
return username.contains("_") && username.length() <= 5;
}

// Password check
public static boolean checkPasswordComplexity(String password) {

boolean hasCapital = false;
boolean hasNumber = false;
boolean hasSpecial = false;

for (int i = 0; i < password.length(); i++) {

char ch = password.charAt(i); 

if (Character.isUpperCase(ch)) {
hasCapital = true;
} else if (Character.isDigit(ch)) { 
hasNumber = true;
} else if (!Character.isLetterOrDigit(ch)) { 
hasSpecial = true;
}
}

return password.length() >= 8 &&
hasCapital && hasNumber && hasSpecial;
}

// cell phone check
public static boolean checkCellPhoneNumber(String number) {
return number.startsWith("+27") && number.length() == 12;

}


// Register user
public static String registerUser(String username, String password) {

if (!checkUserName(username)) {
return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
}

if (!checkPasswordComplexity(password)) { 
return "password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.";
}

storedUsername = username; 
storedPassword = password; 

return "User registered successfully.";
}

// login
public static boolean loginUser(String username, String password) {
return username.equals(storedUsername) && password.equals(storedPassword); 
}

// login status
public static String returnLoginStatus(boolean status) {

if (status) {
return "welcome " + firstName + "," + lastName + " it is great to see you.";
} else {
return "Username or password incorrect, please try again.";
}
}
}


