/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CPIT251Project {

    private static ArrayList<CreateFile> fileIdeas = new ArrayList<>();
    private static String FavIdea;
    private static String Accept;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas");

        System.out.println("Enter the number of file idea that you want to added: ");
        int NoFileIdea = in.nextInt();
        
        int count = 1;

        do {
            String firstLine = "File number: " + count;

            PrintInFile.write(firstLine);
            System.out.println(firstLine);

            System.out.println("Enter your name as owner idea: ");
            String OwnerName = in.next();
            System.out.println("Enter the idea name: ");
            String IdeaName = in.next();
            System.out.println("Enter describtion of idea: ");
            String desc = in.next();

            CreateFile file = new CreateFile(IdeaName, desc, OwnerName);
            fileIdeas.add(file);

            PrintInFile.println(file.toString());
            System.out.println("Succuessful added the idea! ");

            System.out.println("Do you want to add idea to Favorite place (Enter Y for yes or N for no) :");
            FavIdea = in.next();
            if (FavIdea.equalsIgnoreCase("Y")) {
                file.ChangeFavoriteIdea();
                System.out.println("Succuessful added in favorite place");
            }

            file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());
            PrintInFile.write(file.toString());

            System.out.print("Do you want to change the idea state to accept (if Yes enter Y otherwise enter N for No): ");
            Accept = in.next();

            if (Accept.equalsIgnoreCase("Y")) {
                file.ChangeStateIdea();
                System.out.println("Succuessful added in accepted file");
            }
            file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());
            PrintInFile.write(file.toString());
            
            ++count;
        } while (NoFileIdea != count);

        PrintInFile.close();
        PrintInFile.flush();
        in.close();

    }

}
