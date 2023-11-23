/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CPIT251Project {

    private static ArrayList<CreateFile> fileIdeas = new ArrayList<>();
    private static CreateFile file = new CreateFile();
    private static String OwnerName;
    private static String desc;
    private static String IdeaName;
    private static String FavIdea;
    private static String Acceptance;
    private static int NoFileIdea;
    private static int operationNum;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas.txt");

        String job;
        // Main loop to handle different roles and operations
        do {

            showMenu();
            job = in.next();

            switch (job) {
                case "Owner":
                case "owner":
                case "OWNER":
                case "1": {
                     do { 
                    OwnerMenu();
                    operationNum = in.nextInt();// Get the user's operation choice
                    if (operationNum == 1) {
                        SubmitFileIdea(in, PrintInFile);// Call the SubmitFileIdea method

                    } else if (operationNum == 2) {
                        DeleteFileIdea(in, PrintInFile); // call DeleteFileIdea method

                    } else {

                      Quite("owner");

                      
                    }
                      } while (operationNum != 3);

                    break;
                }
                case "Investor":
                case "investor":
                case "INVESTOR":
                case "2": {
                    // Check if the list of file ideas is empty

                    if (fileIdeas.isEmpty()) {
                        System.out.println("The file is empty");
                    } else {

                        do { 
                            InvestorMenu();// Display the investor menu and prompt for an operation choice
                            operationNum = in.nextInt();

                            // Perform the selected operation based on the user's choice
                            if (operationNum == 1) {
                                // If the user chooses to add a file to favorites, invoke the AddFavoriteIdea method
                                AddFavoriteIdea(in, PrintInFile);
                            } else {
                                // If the user chooses any other operation, exit the specified job
                                Quite("investor");
                            }

                        } while (operationNum != 2);

                    }
                    // Exit the loop
                    break;
                }
                case "Staff":
                case "staff":
                case "STAFF":
                case "3": {
                    // Check if the list of file ideas is empty
                    if (fileIdeas.isEmpty()) {
                        System.out.println("The file is empty");
                    } else {

                        do {    
                            StaffMenu();// Display the staff menu and prompt for an operation choice
                            operationNum = in.nextInt();

                            if (operationNum == 1) {
                                Acceptance(operationNum, in, PrintInFile);

                            } else {
                                Quite("staff");  // Exit the staff job
                            }

                        } while (operationNum != 2);

                    }
                    // Exit the loop

                    break;
                }
                case "Stop":
                case "stop":
                case "STOP":
                case "4": {
                    System.exit(0);// Exit the program
            
                }
                default:
                    break;
            }

        } while (!"".equals(job));// Continue looping until an empty string is entered

        PrintInFile.close();
        PrintInFile.flush();
        in.close();

    }

    public static void showMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------                JOBS               ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. OWNER                                    |");
        System.out.println("|   2. INVESTOR                                 |");
        System.out.println("|   3. STAFF                                    |");
        System.out.println("|   4. STOP                                     |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter your job: ");

    }

    public static void OwnerMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------           OWNER OPERATIONS        ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. add file idea                            |");
        System.out.println("|   2. delete                                   |");
        System.out.println("|   3. quite                                    |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter number of operation for OWNER: ");

    }

    public static void InvestorMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------        INVESTOR OPERATIONS        ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. add in favorite place                    |");
        System.out.println("|   2. quite                                    |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter number of operation for INVESTOR: ");

    }

    public static void StaffMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------            STAFF OPERATIONS       ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. change state to accept                   |");
        System.out.println("|   2. quite                                    |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter number of operation for STAFF: ");

    }

    public static void SubmitFileIdea(Scanner in, PrintWriter PrintInFile) {
        System.out.println("Enter the number of file idea that you want to added: ");
        NoFileIdea = in.nextInt();
        for (int i = 1; i <= NoFileIdea; i++) {
            // Display and write the file number
            String firstLine = "File number: " + i;
            PrintInFile.write(firstLine);
            System.out.println(firstLine);
            // Prompt the user to enter the owner's name, idea name, and description
            System.out.println("Enter your name as owner idea: ");
            OwnerName = in.next();
            System.out.println("Enter the idea name: ");
            IdeaName = in.next();
            System.out.println("Enter describtion of idea: ");
            desc = in.next();
            // Create a new file with the provided information
            file = new CreateFile(IdeaName, desc, OwnerName);
            // Add the file to the list of file ideas
            fileIdeas.add(file);
            PrintInFile.println(fileIdeas.toString());      // Write the list of file ideas to the file
            // Display a success message for adding the idea
            System.out.println("Succuessful added the idea! ");
        }

    }

    //Deletes a file idea from the list of fileIdeas
    public static void DeleteFileIdea(Scanner in, PrintWriter PrintInFile) {
        // Check if the list of fileIdeas is empty
        if (fileIdeas.isEmpty()) {
            System.out.println("the file is empty");
        } else {

            // Display the list of file ideas and get the index to delete
            int indexFile = DisplayIdeaFile(in); // call DisplayIdeaFile method
            // Remove the file idea at the specified index
            fileIdeas.remove(indexFile);
            System.out.println("Succuessful deleted the file idea!");

        }

    }
//Add ideas to Favorite place

    public static void AddFavoriteIdea(Scanner in, PrintWriter PrintInFile) {
        // Call DisplayIdeaFile method to display all ideas and get the index of the selected file
        int indexFile = DisplayIdeaFile(in);

        // Update the favorite status of the selected file
        fileIdeas.get(indexFile).ChangeFavoriteIdea();

        // Create a new file object with the updated information
        file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());

        // Write the modified file information in file
        PrintInFile.write(file.toString());
    }

    public static void Acceptance(int operationNum, Scanner in, PrintWriter PrintInFile) {
        // Call DisplayIdeaFile method to display all ideas and get the index of the selected file
        int indexFile = DisplayIdeaFile(in);

        // Change the state of the selected idea to indicate it has been accepted
        fileIdeas.get(indexFile).ChangeStateIdea();
        // Print a success message to the console
        System.out.println("Successful added in accepted file");

        // Create a new file instance with the idea's details
        file = new CreateFile(IdeaName, desc, OwnerName, fileIdeas.get(indexFile).getFavoriteState(), fileIdeas.get(indexFile).getState());
        // Write the file's string representation to the PrintWriter object, to save it in a file
        PrintInFile.write(file.toString());

    }

    //Displays all file ideas and returns the index of the selected file idea
    public static int DisplayIdeaFile(Scanner in) {
        //Display all file in (Ideas File)
        for (int i = 0; i < fileIdeas.size(); i++) {
            System.out.println("File number " + (i + 1) + "\tIdea name: " + fileIdeas.get(i).getIdeaName());
        }
        // Prompt the user to enter the number of the file idea they want to select
        System.out.println("Enter the number of file that you want: ");
        int selectedFile = in.nextInt();
        // Calculate the index based on the user's selection
        int indexFile = selectedFile - 1;
        // Return the index of the selected file idea
        return indexFile;

    }

    public static void Quite(String job) {
        System.out.println("Quite the operation of " + job);

    }

}
