package cpit251project;

import java.util.ArrayList;
import java.util.Scanner;

public class Investor {

    //Add ideas to Favorite place
    public static void AddFavoriteIdea(Scanner in, ArrayList<FileMangmant> fileMangment, Ideas fileIdea) {
        // Call DisplayIdeaFile method to display all ideas and get the index of the selected file
        int indexFile = FileMangmant.DisplayIdeaFile(in, fileMangment);

        // Update the favorite status of the selected file
        fileMangment.get(indexFile).ChangeFavoriteIdea();

        // Create a new file object with the updated information
        fileIdea = new Ideas(fileIdea.getIdeaName(), fileIdea.getOwnerName(), fileIdea.getDescription(), 
                fileIdea.getFavoriteState(), fileIdea.getState());

    }

}
