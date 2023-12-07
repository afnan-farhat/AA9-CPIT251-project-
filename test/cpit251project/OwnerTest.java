/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Afnan
 */
public class OwnerTest {

    public OwnerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of SubmitFileIdea method, of class Owner.
     */
    @Test
    public void testSubmitFileIdea() {
        // Arrange
        ArrayList<FileMangmant> fileMangment = new ArrayList<>();
        
        // Crreat some file ideas for testing
        Ideas file1 = new Ideas("Community Volunteer Hub", "An online platform connecting volunteers with local community projects,"
                + " making it easy for individuals to find and contribute to causes they care about.", "Afnan Tariq Farhat");
        Ideas file2 = new Ideas("Joyful Sweets", "Artistic Sweets Inspired by Cultures Worldwide: Offering a diverse range "
                + "of artistically crafted sweets inspired by various cultures globally", "Marya Fawaz Marzuq");
        // cast from Ideas to FileMangmant
        FileMangmant file_mng1 = new FileMangmant(file1);
        FileMangmant file_mng2 = new FileMangmant(file2);
        // Add some file ideas for testing
        fileMangment.add(0, file_mng1);
        fileMangment.add(1, file_mng2);
         // Assert (Verify that the file "Ideas.txt" has been created and contains expected content)
        File ideasFile = new File("Ideas.txt");
        assertTrue("File should exist", ideasFile.exists());
        // Act
        try {
            FileMangmant.writeOnFile(fileMangment);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
       
        // Read the content of the file
        try (Scanner scanner = new Scanner(ideasFile)) {
            // Perform assertions on the file content based on your expectations
            // For example, you can check if the file contains specific lines or patterns
            assertTrue("Successfully added!", !scanner.nextLine().isEmpty()); // Empty line after the header

            // Add more assertions based on your file writing logic
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    /*
     * Test of DeleteFileIdea method, of class CPIT251Project.
     */
    @Test
    public void testDeleteFileIdea() {
        ArrayList<FileMangmant> fileMangment = new ArrayList<>();

        // Crreat some file ideas for testing
        Ideas file1 = new Ideas("Community Volunteer Hub", "An online platform connecting volunteers with local community projects, making it easy for individuals to find and contribute to causes they care about.", "Afnan Tariq Farhat");
        Ideas file2 = new Ideas("Joyful Sweets", "Artistic Sweets Inspired by Cultures Worldwide: Offering a diverse range of artistically crafted sweets inspired by various cultures globally", "Marya Fawaz Marzuq");
        Ideas file3 = new Ideas("Language Learning Game", "A gamified language learning app that uses interactive games and quizzes to make the language learning process fun and engaging for users of all ages.", "Layan Salim Aljohani");
        Ideas file4 = new Ideas("VR Home Fitness", "A virtual reality fitness system for home use, providing immersive workouts in various virtual environments. It features AI-driven personalization, virtual trainers, and social connectivity for engaging exercise experiences.", "Ghada Mohmmed Alshehri");

        FileMangmant file_mng1 = new FileMangmant(file1);
        FileMangmant file_mng2 = new FileMangmant(file2);
        FileMangmant file_mng3 = new FileMangmant(file3);
        FileMangmant file_mng4 = new FileMangmant(file4);

        // Add some file ideas for testing
        fileMangment.add(0, file_mng1);
        fileMangment.add(1, file_mng2);
        fileMangment.add(2, file_mng3);
        fileMangment.add(3, file_mng4);

        // check file exist or not 
        assertTrue("file existence!", fileMangment.get(0) != null);

        // Delete file from Idea File
        fileMangment.remove(0);

        // Check if the fileMangment list is empty after deletion
        assertFalse("file was deleted!", fileMangment.indexOf(file1) == 0);
    }

    /**
     * Additions Test method of SubmitFileIdea method, of class Owner. that
     * check on content that will add in submit file idea
     */
    @Test
    public void checkContantsOfFile() {
        Ideas file = new Ideas("pickup and walk", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", "ghada mohammed alshehri");
        int CurrentlengthName = file.getDescription().length();
        int ExpectedLenght = 256;
        assertTrue("Successfully added description!", CurrentlengthName >= ExpectedLenght);
        String currentOwnerName = file.getOwnerName();

        // Use a regular expression to check if the owner name does not contain any digits
        assertFalse("Successfully added owner name!", currentOwnerName.matches(".*\\d.*"));
    }

}
