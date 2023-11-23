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
 * @author DELL
 */
public class CPIT251ProjectIT {
    
    public CPIT251ProjectIT() {
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
     * Test of main method, of class CPIT251Project.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        CPIT251Project.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showMenu method, of class CPIT251Project.
     */
    @Test
    public void testShowMenu() {
        System.out.println("showMenu");
        CPIT251Project.showMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OwnerMenu method, of class CPIT251Project.
     */
    @Test
    public void testOwnerMenu() {
        System.out.println("OwnerMenu");
        CPIT251Project.OwnerMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of OwnerOperation method, of class CPIT251Project.
     */
    @Test
    public void testOwnerOperation() {
        System.out.println("OwnerOperation");
        Scanner in = null;
        CPIT251Project.OwnerOperation(in);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InvestorOperation method, of class CPIT251Project.
     */
    @Test
    public void testInvestorOperation() {
        System.out.println("InvestorOperation");
        Scanner in = null;
        CPIT251Project.InvestorOperation(in);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InvestorMenu method, of class CPIT251Project.
     */
    @Test
    public void testInvestorMenu() {
        System.out.println("InvestorMenu");
        CPIT251Project.InvestorMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of StaffMenu method, of class CPIT251Project.
     */
    @Test
    public void testStaffMenu() {
        System.out.println("StaffMenu");
        CPIT251Project.StaffMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SubmitFileIdea method, of class CPIT251Project.
     */
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

    /**
     * Test of AddFavoriteIdea method, of class CPIT251Project.
     */
    @Test
    public void testAddFavoriteIdea() {
        System.out.println("AddFavoriteIdea");
        Scanner in = null;
        CPIT251Project.AddFavoriteIdea(in);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

    /**
     * Test of DisplayIdeaFile method, of class CPIT251Project.
     */
    @Test
    public void testDisplayIdeaFile() {
        System.out.println("DisplayIdeaFile");
        Scanner in = null;
        int expResult = 0;
        int result = CPIT251Project.DisplayIdeaFile(in);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Quite method, of class CPIT251Project.
     */
    @Test
    public void testQuite() {
        System.out.println("Quite");
        String job = "";
        CPIT251Project.Quite(job);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeOnFile method, of class CPIT251Project.
     */
    @Test
    public void testWriteOnFile() throws Exception {
        System.out.println("writeOnFile");
        CPIT251Project.writeOnFile();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
