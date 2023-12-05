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
        // Add some sample FileMangmant objects to the list

        // Act
        try {
            FileMangmant.writeOnFile(fileMangment);
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }

        // Assert
        // Verify that the file "Ideas.txt" has been created and contains expected content
        File ideasFile = new File("Ideas.txt");
        assertTrue( "File should exist", ideasFile.exists());

        // Read the content of the file
        try (Scanner scanner = new Scanner(ideasFile)) {
            // Perform assertions on the file content based on your expectations
            // For example, you can check if the file contains specific lines or patterns
            assertTrue(scanner.nextLine().contains(" --------------- IDEA FILES ---------------"));
            assertTrue(scanner.nextLine().isEmpty()); // Empty line after the header

            // Add more assertions based on your file writing logic
        } catch (FileNotFoundException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
    }

    /**
     * Test of DeleteFileIdea method, of class Owner.
     */
    @Test
    public void testDeleteFileIdea() {
        System.out.println("DeleteFileIdea");
        Scanner in = null;
        ArrayList<FileMangmant> fileMangment = null;
        Owner.DeleteFileIdea(in, fileMangment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
