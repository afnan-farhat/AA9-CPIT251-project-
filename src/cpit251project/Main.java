package cpit251project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static ArrayList<FileMangmant> fileMangment = new ArrayList<>();
    private static Ideas fileIdea = new Ideas();
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
                OwnerOperation(in, operationNum, NoFileIdea, fileIdea, fileMangment);
            } else if ("Investor".equalsIgnoreCase(job) || "2".equals(job)) {
                InvestorOperation(in);
            } else if ("Staff".equalsIgnoreCase(job) || "3".equals(job)) {
                StaffOperation(in);
            } else if ("Stop".equalsIgnoreCase(job) || "4".equals(job)) {
                // Execute the following block for "Stop" job
                // Save data to file and exit the program
                FileMangmant.writeOnFile(fileMangment);
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

    public static void OwnerOperation(Scanner in, int operationNum, int NoFileIdea, Ideas fileIdea, ArrayList<FileMangmant> fileMangment) {
        // Execute the following block for "Owner" job
        do {
            try {
                // Display the owner menu and prompt for an operation choice
                OwnerMenu();
                // Get the user's operation choice
                operationNum = in.nextInt();
                if (operationNum == 1) {
                    // If the user chooses to add a file idea, invoke the SubmitFileIdea method
                    Owner.SubmitFileIdea(in, NoFileIdea, fileIdea, fileMangment);
//                    for (int i = 0; i < fileMangment.size(); i++) {
//                        System.out.println("File number " + (i + 1) + "\tIdea name: " + fileMangment.get(i).getIdeaName());
//                    }
                    //System.out.println(Arrays.toString(fileMangment.toArray()));

                } else if (operationNum == 2) {
                    // If the user chooses to delete a file idea, invoke the DeleteFileIdea method
                    Owner.DeleteFileIdea(in, fileMangment);
                } else {
                    // If the user chooses to quit the owner job, exit the loop
                    FileMangmant.Quite("owner");
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
        if (fileMangment.isEmpty()) {
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
                        Investor.AddFavoriteIdea(in, fileMangment, fileIdea);
                    } else {
                        // If the user chooses any other operation, exit the specified job
                        FileMangmant.Quite("investor");
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
        if (fileMangment.isEmpty()) {
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
                        Staff.UpdateState(in, operationNum, fileIdea, fileMangment);
                    } else {
                        // If the user chooses to quit the staff job, exit the loop
                        FileMangmant.Quite("staff");
                    }
                } catch (InputMismatchException e) {
                    // Handle InputMismatchException (non-integer input)
                    System.out.println("Invalid input. Please enter a valid integer.");
                    in.nextLine(); // Clear the buffer
                }

            } while (operationNum != 2);
        }
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
 

}
