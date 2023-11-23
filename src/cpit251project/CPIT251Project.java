package cpit251project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
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

        String job;
        // Main loop to handle different roles and operations
        do {

            showMenu();
            job = in.next();

            // Check if the job is related to "Owner"
            if ("Owner".equalsIgnoreCase(job) || "1".equals(job)) {
                OwnerOperation(in);
            } else if ("Investor".equalsIgnoreCase(job) || "2".equals(job)) {
                InvestorOperation(in);
            } else if ("Staff".equalsIgnoreCase(job) || "3".equals(job)) {
                StaffOperation(in);
            } else if ("Stop".equalsIgnoreCase(job) || "4".equals(job)) {
                // Execute the following block for "Stop" job
                // Save data to file and exit the program
                writeOnFile();
                System.exit(0);
            } else {
                // Handle the default case if none of the specified conditions are met
            }

        } while (!"".equals(job));// Continue looping until an empty string is entered

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

    public static void OwnerOperation(Scanner in) {
        // Execute the following block for "Owner" job
        do {
            try {
                // Display the owner menu and prompt for an operation choice
                OwnerMenu();
                // Get the user's operation choice
                operationNum = in.nextInt();
                if (operationNum == 1) {
                    // If the user chooses to add a file idea, invoke the SubmitFileIdea method
                    SubmitFileIdea(in);
                } else if (operationNum == 2) {
                    // If the user chooses to delete a file idea, invoke the DeleteFileIdea method
                    DeleteFileIdea(in);
                } else {
                    // If the user chooses to quit the owner job, exit the loop
                    Quite("owner");
                }
            } catch (InputMismatchException e) {
                // Handle InputMismatchException (non-integer input)
                System.out.println("Invalid input. Please enter a valid integer.");
                in.nextLine(); // Clear the buffer
            }
        } while (operationNum != 3);

    }

    public static void InvestorOperation(Scanner in) {
        // Check if the list of file ideas is empty
        if (fileIdeas.isEmpty()) {
            System.out.println("The file is empty");
        } else {
            // Execute the following block for "Investor" job
            do {
                try {
                    // Display the investor menu and prompt for an operation choice
                    InvestorMenu();
                    // Get the user's operation choice
                    operationNum = in.nextInt();
                    if (operationNum == 1) {
                        // If the user chooses to add a file to favorites, invoke the AddFavoriteIdea method
                        AddFavoriteIdea(in);
                    } else {
                        // If the user chooses any other operation, exit the specified job
                        Quite("investor");
                    }
                } catch (InputMismatchException e) {
                    // Handle InputMismatchException (non-integer input)
                    System.out.println("Invalid input. Please enter a valid integer.");
                    in.nextLine(); // Clear the buffer
                }

            } while (operationNum != 2);
        }

    }

    public static void StaffOperation(Scanner in) {
        // Check if the list of file ideas is empty
        if (fileIdeas.isEmpty()) {
            System.out.println("The file is empty");
        } else {
            // Execute the following block for "Staff" job
            do {
                try {
                    // Display the staff menu and prompt for an operation choice
                    StaffMenu();
                    // Get the user's operation choice
                    operationNum = in.nextInt();
                    if (operationNum == 1) {
                        // If the user chooses to change the idea state, invoke the Acceptance method
                        Acceptance(operationNum, in);
                    } else {
                        // If the user chooses to quit the staff job, exit the loop
                        Quite("staff");
                    }
                } catch (InputMismatchException e) {
                    // Handle InputMismatchException (non-integer input)
                    System.out.println("Invalid input. Please enter a valid integer.");
                    in.nextLine(); // Clear the buffer
                }

            } while (operationNum != 2);
        }
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

    public static void SubmitFileIdea(Scanner in) {
        System.out.println("Enter the number of file idea that you want to added: ");
        NoFileIdea = in.nextInt();
        for (int i = 1; i <= NoFileIdea; i++) {
            // Display and write the file number
            String firstLine = "File number: " + i;
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
            // Display a success message for adding the idea
            System.out.println("Succuessful added the idea! ");
        }

    }

    //Deletes a file idea from the list of fileIdeas
    public static void DeleteFileIdea(Scanner in) {
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

    public static void AddFavoriteIdea(Scanner in) {
        // Call DisplayIdeaFile method to display all ideas and get the index of the selected file
        int indexFile = DisplayIdeaFile(in);

        // Update the favorite status of the selected file
        fileIdeas.get(indexFile).ChangeFavoriteIdea();

        // Create a new file object with the updated information
        file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());

    }

    public static void Acceptance(int operationNum, Scanner in) {
        // Call DisplayIdeaFile method to display all ideas and get the index of the selected file
        int indexFile = DisplayIdeaFile(in);

        // Change the state of the selected idea to indicate it has been accepted
        fileIdeas.get(indexFile).ChangeStateIdea();
        // Print a success message to the console
        System.out.println("Successful added in accepted file");

        // Create a new file instance with the idea's details
        file = new CreateFile(IdeaName, desc, OwnerName, fileIdeas.get(indexFile).getFavoriteState(), fileIdeas.get(indexFile).getState());

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

    public static void writeOnFile() throws FileNotFoundException {
        // Create a PrintWriter to write to the "Ideas.txt" file
        PrintWriter PrintInFile = new PrintWriter("Ideas.txt");

        // Write header and spacing to the file
        PrintInFile.println(" --------------- IDEA FILES ---------------");
        PrintInFile.println("\n");

        // Iterate through the list of fileIdeas
        for (int i = 0; i < fileIdeas.size(); i++) {
            // Write the file number and separator to the file
            PrintInFile.println("The number of file: " + (i + 1));
            PrintInFile.println(" ------------------------------------------");

            // Write the information of the current file idea to the file
            PrintInFile.println(fileIdeas.get(i).toString());
            PrintInFile.println(); // Add an empty line for better readability
        }

        // Display success message
        System.out.println("Successfully added the ideas!");
        // Close the PrintWriter and flush the output to the file
        PrintInFile.close();
        PrintInFile.flush();
    }

}
