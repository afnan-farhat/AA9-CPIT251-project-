/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Afnan
 */
public class Staff extends Person{
    
     public static void UpdateState(Scanner in,int operationNum,Ideas fileIdea,ArrayList<FileMangmant> fileMangment) {
        // Call DisplayIdeaFile method to display all ideas and get the index of the selected file
        int indexFile =FileMangmant.DisplayIdeaFile(in,fileMangment);

        // Change the state of the selected idea to indicate it has been accepted
        fileMangment.get(indexFile).ChangeStateIdea();
        // Print a success message to the console
        System.out.println("Successful added in accepted file");

        // Create a new file instance with the idea's details
        fileIdea = new Ideas(fileIdea.getIdeaName(), fileIdea.getDescription(),fileIdea.getOwnerName(),
                fileIdea.getFavoriteState(), fileIdea.getState());

    }
}
