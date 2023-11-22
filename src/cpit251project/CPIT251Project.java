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

        // TODO code application logic here
        System.out.println("Genius Growth - CPIT251 Project");
        System.out.println("Fali Junit test");

        Scanner in = new Scanner(System.in);
        PrintWriter PrintInFile = new PrintWriter("Ideas");
        System.out.println("Enter your name as owner idea: ");
        String OwnerName = in.next();
        System.out.println("Enter the idea name: ");
        String IdeaName = in.next();
        System.out.println("Enter describtion of idea: ");
        String desc = in.next();
        
        PrintInFile.print("Owner name: " + OwnerName + "\n");
        PrintInFile.print("Idea name: " + IdeaName + "\n");
        PrintInFile.print("Idea Describtion: " + desc );
        
        System.out.println("Succuessful added the idea! ");
        
        PrintInFile.close();
        in.close();

    }

}
