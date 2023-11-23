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

    @Test
    public void testSubmitFileIdea() {
        System.out.println("SubmitFileIdea");
        Scanner in = null;
        CPIT251Project.SubmitFileIdea(in);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

/*
     * Test of DeleteFileIdea method, of class CPIT251Project.
     */
    @Test
    public void testDeleteFileIdea_CheckExistenceFile() {
        CreateFile FileIdea = new CreateFile("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", true, "Accept");
        assertTrue(FileIdea != null);
    }

    @Test
    public void testDeleteFileIdea_DeleteFileIdea() {
        ArrayList<CreateFile> fileIdeas = new ArrayList<>();

        // Crreat some file ideas for testing
        CreateFile file1 = new CreateFile("Community Volunteer Hub", "An online platform connecting volunteers with local community projects, making it easy for individuals to find and contribute to causes they care about.", "Afnan Tariq Farhat");
        CreateFile file2 = new CreateFile("Joyful Sweets", "Description2", "Marya Fawaz Marzuq");
        CreateFile file3 = new CreateFile("Language Learning Game", "A gamified language learning app that uses interactive games and quizzes to make the language learning process fun and engaging for users of all ages.", "Layan Salim Aljohani");
        CreateFile file4 = new CreateFile("VR Home Fitness", "A virtual reality fitness system for home use, providing immersive workouts in various virtual environments. It features AI-driven personalization, virtual trainers, and social connectivity for engaging exercise experiences.", "Ghada Mohmmed Alshehri");

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
        CreateFile FAV_IDEA = new CreateFile("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", false, "Accept");
        boolean currentvalue = FAV_IDEA.getFavoriteState();
        boolean ExpectedValue = false;
        assertSame(ExpectedValue, currentvalue);

    }

    @Test
    public void testAddFavoriteIdea_ChangeFavIdea() {
        CreateFile FAV_IDEA = new CreateFile("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
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
    public void testAcceptance() {
        System.out.println("Acceptance");
        int operationNum = 0;
        Scanner in = null;
        CPIT251Project.Acceptance(operationNum, in);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
