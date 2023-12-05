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
 * @author DELL
 */
public class StaffTest {
    
    public StaffTest() {
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
 * Test methods for the functionality of changing the state of an idea in class CPIT251Project.
 */
@Test
public void testUpdateStateIdea() {
    // Test the initial state (waiting)
    Ideas IDEAinfo = new Ideas("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
            + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
            + " savor top-notch coffee, and indulge in a variety of delightful treats. Our cafe is the perfect blend of good vibes and seamless conversations.");
    
    String currentState = IDEAinfo.getState();
    String expectCurrentState = "waiting";
    assertEquals(expectCurrentState,currentState, "waiting");

    // Test changing the state to "Accept"
    FileMangmant file_mng = new FileMangmant(IDEAinfo);
    file_mng.ChangeStateIdea();
    
    String result = IDEAinfo.getState();
    String expResult = "Accept";
    assertEquals(expResult, result, "Accept");
}

}
