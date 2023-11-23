/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cpit251project;

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

    /**
     * Test of DeleteFileIdea method, of class CPIT251Project.
     */
    @Test
    public void testDeleteFileIdea() {
        System.out.println("DeleteFileIdea");
        Scanner in = null;
        CPIT251Project.DeleteFileIdea(in);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
