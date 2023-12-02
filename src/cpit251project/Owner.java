/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

import static cpit251project.Main.DeleteFileIdea;
import static cpit251project.Main.Quite;
//import static cpit251project.Main.SubmitFileIdea;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Owner extends Person {

    public static void SubmitFileIdea(Scanner in, int NoFileIdea, FileMangmant file, ArrayList<FileMangmant> fileIdeas) {
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
            file = new FileMangmant(IdeaName, desc, OwnerName);
            // Add the file to the list of file ideas
            fileIdeas.add(file);
            // Display a success message for adding the idea
            System.out.println("Succuessful added the idea! ");
        }

    }

}
