
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
public class InvestorTest {
    
    public InvestorTest() {
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
     * Test of AddFavoriteIdea method, of class Investor.
     */
 @Test
    public void testAddFavoriteIdea() {
        Ideas FAV_IDEA = new Ideas("pickup and walk", "ghada mohammed alshehri", "Enhance your university experience with our app,"
                + " allowing you to effortlessly order premium coffee for delivery or pickup within the university range. Immerse yourself in a welcoming atmosphere,"
                + " savor top-notch coffee, and indulge in a variety of delightful treats."
                + " Our cafe is the perfect blend of good vibes and seamless conversations.", false, "Accept");
        boolean currentvalue = FAV_IDEA.getFavoriteState();
        boolean ExpectedValue = false;
        assertSame(ExpectedValue, currentvalue);

        FileMangmant file_mng = new FileMangmant(FAV_IDEA);
        file_mng.ChangeFavoriteIdea();
        boolean ExpectedResult = true;
        assertSame("Successfully added in favorite place!", FAV_IDEA.getFavoriteState(), ExpectedResult);

    }
    
}
