package cpit251project;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FileMangmant {

    private String IdeaName;
    private String description;
    private String OwnerName;
    private boolean favoriteState;
    private String state;

    FileMangmant() {
    }

    FileMangmant(String IdeaName, String description, String OwnerName) {
        this.IdeaName = IdeaName;
        this.description = description;
        this.OwnerName = OwnerName;
        this.favoriteState = false;
        this.state = "waiting";
    }

    FileMangmant(String IdeaName, String description, String OwnerName, boolean favoriteState, String state) {
        this.IdeaName = IdeaName;
        this.description = description;
        this.OwnerName = OwnerName;
        this.favoriteState = favoriteState;
        this.state = state;
    }

    public String getIdeaName() {
        return IdeaName;
    }

    public String getDescription() {
        return description;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public boolean getFavoriteState() {
        return favoriteState;
    }

    public String getState() {
        return state;
    }

    public void setIdeaName(String IdeaName) {
        this.IdeaName = IdeaName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setOwnerName(String OwnerName) {
        this.OwnerName = OwnerName;
    }

    public void setFavoriteState(boolean favoriteState) {
        this.favoriteState = favoriteState;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void ChangeFavoriteIdea() {
        if (getFavoriteState() == false) {
            setFavoriteState(true);
            System.out.println("\n Succuessful added in favorite place \n");
        } else {
            System.out.println("\n Already in favorite place \n");
        }
    }

    public void ChangeStateIdea() {
        if (getState().equalsIgnoreCase("waiting")) {
            setState("Accept");
        } else if (getState().equalsIgnoreCase("Accept")) {
            System.out.println("The idea has been accepted");
        } else {
            System.out.println("The idea wss Reject");
        }
    }

    //Displays all file ideas and returns the index of the selected file idea
    public static int DisplayIdeaFile(Scanner in, ArrayList<FileMangmant> fileIdeas) {
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

    public static void writeOnFile(ArrayList<FileMangmant> fileMangment) throws FileNotFoundException {
        // Create a PrintWriter to write to the "Ideas.txt" file
        PrintWriter PrintInFile = new PrintWriter("Ideas.txt");

        // Write header and spacing to the file
        PrintInFile.println(" --------------- IDEA FILES ---------------");
        PrintInFile.println("\n");

        // Iterate through the list of fileIdeas
        for (int i = 0; i < fileMangment.size(); i++) {
            // Write the file number and separator to the file
            PrintInFile.println("The number of file: " + (i + 1));
            PrintInFile.println(" ------------------------------------------");

            // Write the information of the current file idea to the file
            PrintInFile.println(fileMangment.get(i).toString());
            PrintInFile.println(); // Add an empty line for better readability
        }

        // Display success message
        System.out.println("Successfully added the ideas!");
        // Close the PrintWriter and flush the output to the file
        PrintInFile.close();
        PrintInFile.flush();
    }

    @Override
    public String toString() {
        return "Idea: " + IdeaName + "\n" + "description: " + description + "\nOwnername: " + OwnerName + "\nState: "
                + state + "\nFavorite: " + favoriteState + "\n";
    }

}
