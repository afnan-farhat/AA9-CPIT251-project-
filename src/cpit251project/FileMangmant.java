package cpit251project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Scanner;

public class FileMangmant extends Ideas{

    private  Ideas ideas;

    public FileMangmant(Ideas ideas) {
          super(ideas.getIdeaName(), ideas.getDescription(), ideas.getOwnerName(), ideas.getFavoriteState(), ideas.getState());
        this.ideas = ideas;
    }

    public void ChangeFavoriteIdea() {

        if (ideas.getFavoriteState() == false) {
            ideas.setFavoriteState(true);
            System.out.println("\n Succuessful added in favorite place \n");
        } else {
            System.out.println("\n Already in favorite place \n");
        }
    }

    public void ChangeStateIdea() {
        if (ideas.getState().equalsIgnoreCase("waiting")) {
            ideas.setState("Accept");
        } else if (ideas.getState().equalsIgnoreCase("Accept")) {
            System.out.println("The idea has been accepted");
        } else {
            System.out.println("The idea wss Reject");
        }
    }

     //Displays all file ideas and returns the index of the selected file idea
    public static int DisplayIdeaFile(Scanner in, ArrayList<FileMangmant> fileMangment) {
        //Display all file in (Ideas File)
        for (int i = 0; i < fileMangment.size(); i++) {
            System.out.println("File number " + (i + 1) + "\tIdea name: " + fileMangment.get(i).getIdeaName());
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
        File IdeasFile = new File ("Ideas.txt");
        PrintWriter PrintInFile = new PrintWriter(IdeasFile);

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
        return "Idea: " + ideas.getIdeaName() + "\n" + "description: " + ideas.getDescription() + "\nOwnername: " + ideas.getOwnerName() + "\nState: "
                + ideas.getState() + "\nFavorite: " + ideas.getFavoriteState() + "\n";
    }

}
