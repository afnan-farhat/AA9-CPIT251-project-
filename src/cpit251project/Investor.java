package cpit251project;

import java.util.ArrayList;
import java.util.Scanner;

public class Investor {

    //Add ideas to Favorite place
    public static void AddFavoriteIdea(Scanner in, ArrayList<FileMangmant> fileIdeas, FileMangmant file) {
        // Call DisplayIdeaFile method to display all ideas and get the index of the selected file
        int indexFile = FileMangmant.DisplayIdeaFile(in, fileIdeas);

        // Update the favorite status of the selected file
        fileIdeas.get(indexFile).ChangeFavoriteIdea();

        // Create a new file object with the updated information
        file = new FileMangmant(file.getIdeaName(), file.getOwnerName(), file.getDescription(), file.getFavoriteState(), file.getState());

    }

}
