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
    private static String Reject;
    private static int NoFileIdea;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas");

        String job;

        do {

            showMenu();
            job = in.next();

            switch (job) {
                case "Owner":
                case "owner":
                case "OWNER":
                case "1": {

                    OwnerMenu();
                    int Operation = in.nextInt();

                    if (Operation == 1) {

                        System.out.println("Enter the number of file idea that you want to added: ");
                        NoFileIdea = in.nextInt();
                        for (int i = 1; i <= NoFileIdea; i++) {
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
                    } else if (Operation == 2) {
                        fileIdeas.remove(file);
                        System.out.println("Succuessful deleted the file idea!");
                    } else if (Operation == 3) {
                        break;
                    }

                    break;

                }
                case "Investor":
                case "investor":
                case "INVESTOR":
                case "2": {
                    //Display all file in (Ideas File)
                    for (int i = 0; i < NoFileIdea; i++) {
                        System.out.println("File number " + (i + 1) + "\tIdea name: " + fileIdeas.get(i).getIdeaName());
                    }

                    // select file number 
                    System.out.println("Enter the number of file that you want to modify on it: ");
                    int selectedFile = in.nextInt();
                    int indexFile = selectedFile - 1;

                    // add idea in favorite place
                    System.out.println("Do you want to add idea to Favorite place (Enter Y for yes or N for no) :");
                    FavIdea = in.next();
                    if (FavIdea.equalsIgnoreCase("Y")) {
                        //file.ChangeFavoriteIdea();
                        fileIdeas.get(indexFile).ChangeFavoriteIdea();
                        System.out.println("Succuessful added in favorite place");
                    }
                    file = new CreateFile(IdeaName, desc, OwnerName, file.getFavoriteState(), file.getState());
                    PrintInFile.write(file.toString());

                    break;
                }
                case "Staff":
                case "staff":
                case "STAFF":
                case "3": {
                    //Display all file in (Ideas File)
                    for (int i = 0; i < NoFileIdea; i++) {
                        System.out.println("File number " + (i + 1) + "\tIdea name: " + fileIdeas.get(i).getIdeaName());
                    }

                    // select file number 
                    System.out.println("Enter the number of file that you want to modify on it: ");
                    int selectedFile = in.nextInt();
                    int indexFile = selectedFile - 1;

                    // change state to accept
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
                case "Stop":
                case "stop":
                case "STOP":
                case "4": {
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
        System.out.println("|------                JOBS               ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. OWNER                                    |");
        System.out.println("|   2. INVESTOR                                 |");
        System.out.println("|   3. STAFF                                    |");
        System.out.println("|   4. STOP                                     |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter your job: ");

    }

    public static void OwnerMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------           OWNER OPERATIONS        ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. add file idea                            |");
        System.out.println("|   2. delete                                   |");
        System.out.println("|   3. quite                                    |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter number of operation for OWNER: ");

    }

    public static void InvestorMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------        INVESTOR OPERATIONS        ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. add in favorite place                    |");
        System.out.println("|   2. quite                                    |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter number of operation for INVESTOR: ");

    }

    public static void StaffMenu() {
        System.out.println("|-----------------------------------------------|");
        System.out.println("|------            STAFF OPERATIONS       ------|");
        System.out.println("|-----------------------------------------------|");
        System.out.println("|   1. change state to accept                   |");
        System.out.println("|   2. quite                                    |");
        System.out.println("|-----------------------------------------------|");
        System.out.println();
        System.out.print("> Please enter number of operation for STAFF: ");

    }

}
