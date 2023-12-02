
package cpit251project;

import static cpit251project.Main.Quite;
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

    
    @Override
    public String toString() {
        return "Idea: " + IdeaName + "\n" + "description: " + description + "\nOwnername: " + OwnerName + "\nState: "
                + state + "\nFavorite: " + favoriteState + "\n";
    }

}
