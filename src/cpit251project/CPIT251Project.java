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
    private static CreateFile file = new CreateFile();
    private static String OwnerName;

    private static String desc;
    private static String IdeaName;
    private static String FavIdea;
    private static String Accept;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas");

        System.out.println("Enter the number of file idea that you want to added: ");
        int NoFileIdea = in.nextInt();

     

        String job;
        //} while(!(FavIdea.equalsIgnoreCase("y")&& Accept.equalsIgnoreCase("yes") ));
        do {

            showMenu();
            job = in.next();

            switch (job) {
                case "Owner": {
                    
                    for(int i=1; i<=NoFileIdea; i++){
                    String firstLine = "File number: " + i;
                    PrintInFile.write(firstLine);
                    System.out.println(firstLine);

                    System.out.println("Enter your name as owner idea: ");
                    OwnerName = in.next();
                    System.out.println("Enter the idea name: ");
                    IdeaName = in.next();
                    System.out.println("Enter describtion of idea: ");
                    desc = in.next();

                    file = new CreateFile(IdeaName, desc, OwnerName);

                    fileIdeas.add(file);
                    PrintInFile.println(file.toString());
                    System.out.println("Succuessful added the idea! ");
                    }
                    fileIdeas.remove(file);

                    break;

                }
                case "Investor": {
                    System.out.println("Do you want to add idea to Favorite place (Enter Y for yes or N for no) :");
                    FavIdea = in.next();
                    if (FavIdea.equalsIgnoreCase("Y")) {
                        file.ChangeFavoriteIdea();
                        System.out.println("Succuessful added in favorite place");
                    }
                    file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());
                    PrintInFile.write(file.toString());

                    break;
                }
                case "Staff": {

                    System.out.print("Do you want to change the idea state to accept (if Yes enter Y otherwise enter N for No): ");
                    Accept = in.next();

                    if (Accept.equalsIgnoreCase("Y")) {
                        file.ChangeStateIdea();
                        System.out.println("Succuessful added in accepted file");
                    }
                    file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());
                    PrintInFile.write(file.toString());
                    break;
                }
                case "Stop": {
                    System.exit(0);
                }
                default:
                    break;
            }

            
        } while (!"".equals(job));

        PrintInFile.close();
        PrintInFile.flush();
        in.close();

    }

    public static void showMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------      JOBS     ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. owner                                    |");
        System.out.println("|   2. investor                                 |");
        System.out.println("|   3. staff                                    |");
        System.out.println("|   4. stop                                     |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter your job: ");

    }

}
