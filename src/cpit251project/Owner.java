/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

//import static cpit251project.Main.SubmitFileIdea;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Owner extends Person {

    public static void SubmitFileIdea(Scanner in, int NoFileIdea, Ideas fileIdea, ArrayList<FileMangmant> fileMangment) {
        System.out.println("Enter the number of file idea that you want to added: ");
        NoFileIdea = in.nextInt();
        for (int i = 1; i <= NoFileIdea; i++) {
            // Display and write the file number
            String firstLine = "File number: " + i;
            System.out.println(firstLine);
            // Prompt the user to enter the owner's name, idea name, and description
            System.out.println("Enter your name as owner idea: ");
            String OwnerName = in.next();
            System.out.println("Enter the idea name: ");
            String IdeaName = in.next();
            System.out.println("Enter describtion of idea: ");
            String desc = in.next();
            // Create a new file with the provided information
            fileIdea = new Ideas(IdeaName, desc, OwnerName);
            FileMangmant file_mangment = new FileMangmant(fileIdea);
            // Add the file to the list of file ideas
            fileMangment.add(file_mangment);

            // Display a success message for adding the idea
            System.out.println("Succuessful added the idea! ");
        }

    }

    //Deletes a file idea from the list of fileIdeas
    public static void DeleteFileIdea(Scanner in, ArrayList<FileMangmant> fileMangment) {
        // Check if the list of fileIdeas is empty

        if (fileMangment.isEmpty()) {
            System.out.println("the file is empty");
        } else {

            // Display the list of file ideas and get the index to delete
            int indexFile = FileMangmant.DisplayIdeaFile(in, fileMangment); // call DisplayIdeaFile method
            // Remove the file idea at the specified index
            fileMangment.remove(indexFile);
            System.out.println("Succuessful deleted the file idea!");

        }

    }

}
