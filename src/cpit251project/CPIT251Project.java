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

    public static void main(String[] args) throws FileNotFoundException {
  String FavIdea;
   String Accept;
        // TODO code application logic here
     

        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas");

        System.out.println("Enter the number of file idea that you want to added: ");
        int NoFileIdea = in.nextInt();

       do {
            System.out.println("Enter your name as owner idea: ");
            String OwnerName = in.next();
            System.out.println("Enter the idea name: ");
            String IdeaName = in.next();
            System.out.println("Enter describtion of idea: ");
            String desc = in.next();

            CreateFile file = new CreateFile(IdeaName, desc, OwnerName);

            PrintInFile.println(file.toString());
            System.out.println("Succuessful added the idea! ");
    
          System.out.println("Do you w1ant to add idea to Favorite place (enter Y for yes or N for no) :");
                        FavIdea = in.next();
                        if (FavIdea.equalsIgnoreCase("Y")) {
           file.ChangeFavoriteIdea();
                        }
                            file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());
            PrintInFile.write(file.toString());
            
             System.out.print("Dose the idea accepted?(if Yes enter YES)");
                        Accept = in.next();

                        if (Accept.equalsIgnoreCase("yes")) {
                            file.ChangeStateIdea();
                        }
                        file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());
                        PrintInFile.write(file.toString()); 
           --NoFileIdea;
        }while(NoFileIdea!=0);

        PrintInFile.close();
        PrintInFile.flush();
        in.close();

    }

}
