/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

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
 * @author layan
 */
public class CPIT251ProjectTest {

    public CPIT251ProjectTest() {
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

    /* Test of SubmitFileIdea method, of class CPIT251Project.
     */
    @Test
    public void testSubmitFileIdea_checkDescriptionLength() {
        FileMangmant file = new FileMangmant("pickup and walk", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", "ghada mohammed alshehri");
        int CurrentlengthName = file.getDescription().length();
        int ExpectedLenght = 256;
        assertTrue(CurrentlengthName >= ExpectedLenght);

    }

    @Test
    public void testSubmitFileIdea_checkOwnerNameIsNotString() {
        FileMangmant file = new FileMangmant("pickup and walk", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", "Layan 1234");
        String currentOwnerName = file.getOwnerName();

        // Use a regular expression to check if the owner name does not contain any digits
        assertTrue(currentOwnerName.matches(".*\\d.*"));
    }

    /*
     * Test of DeleteFileIdea method, of class CPIT251Project.
     */
    @Test
    public void testDeleteFileIdea_CheckExistenceFile() {
        FileMangmant FileIdea = new FileMangmant("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", true, "Accept");
        assertTrue(FileIdea != null);
    }

    @Test
    public void testDeleteFileIdea_DeleteFileIdea() {
        ArrayList<FileMangmant> fileIdeas = new ArrayList<>();

        // Crreat some file ideas for testing
        FileMangmant file1 = new FileMangmant("Community Volunteer Hub", "An online platform connecting volunteers with local community projects, making it easy for individuals to find and contribute to causes they care about.", "Afnan Tariq Farhat");
        FileMangmant file2 = new FileMangmant("Joyful Sweets", "Description2", "Marya Fawaz Marzuq");
        FileMangmant file3 = new FileMangmant("Language Learning Game", "A gamified language learning app that uses interactive games and quizzes to make the language learning process fun and engaging for users of all ages.", "Layan Salim Aljohani");
        FileMangmant file4 = new FileMangmant("VR Home Fitness", "A virtual reality fitness system for home use, providing immersive workouts in various virtual environments. It features AI-driven personalization, virtual trainers, and social connectivity for engaging exercise experiences.", "Ghada Mohmmed Alshehri");

        // Add some file ideas for testing
        fileIdeas.add(0, file1);
        fileIdeas.add(1, file2);
        fileIdeas.add(2, file3);
        fileIdeas.add(3, file4);

        // Delete file from Idea File
        fileIdeas.remove(0);

        // Check if the fileIdeas list is empty after deletion
        assertFalse(fileIdeas.indexOf(file1) == 0);
    }

    @Test
    public void testAddFavoriteIdea_TheIdeaNotFav() {
        FileMangmant FAV_IDEA = new FileMangmant("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", false, "Accept");
        boolean currentvalue = FAV_IDEA.getFavoriteState();
        boolean ExpectedValue = false;
        assertSame(ExpectedValue, currentvalue);

    }

    @Test
    public void testAddFavoriteIdea_ChangeFavIdea() {
        FileMangmant FAV_IDEA = new FileMangmant("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", false, "Accept");

        FAV_IDEA.ChangeFavoriteIdea();
        boolean ExpectedValue = true;
        assertSame(FAV_IDEA.getFavoriteState(), ExpectedValue);

    }
    

    /**
     * Test of Acceptance method, of class CPIT251Project.
     */
      @Test
    public void testAcceptance_IsWaiting() {

        System.out.println("ChangeStateIdea"); FileMangmant IDEAinfo = new FileMangmant("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats. Our cafe is the perfect blend of good vibes and seamless conversations.");;
        String currentState = IDEAinfo.getState();
        String expectCurrentState = "waiting";
        assertEquals(currentState, expectCurrentState, "waiting");

    }

    @Test
    public void testAcceptance_ChangeAcceptedState() {
        System.out.println("ChangeStateIdea");

        FileMangmant IDEAinfo = new FileMangmant("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats. Our cafe is the perfect blend of good vibes and seamless conversations.");;

        IDEAinfo.ChangeStateIdea();
        String result = IDEAinfo.getState();
        String expResult = "Accept";

        assertEquals(expResult, result, "Accept");
    }



}
