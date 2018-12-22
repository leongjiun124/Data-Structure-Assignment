/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Admin
 */
public class MaintainCatalogUITest {
    
    public MaintainCatalogUITest() {
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
     * Test of main method, of class MaintainCatalogUI.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        MaintainCatalogUI.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AddProduct method, of class MaintainCatalogUI.
     */
    @Test
    public void testAddProduct() throws Exception {
        System.out.println("AddProduct");
        String input = "xxx\nxxx\n1\n20\n10\n1\ny\n";
        //String input2 = "xxxda\nxxxdasd\n3\n20\n10\n0\ny\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        //InputStream in2 = new java.io.ByteArrayInputStream(input2.getBytes());
        System.setIn(in);   
        //System.setIn(in2);
        MaintainCatalogUI.AddProduct();
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }

    /**
     * Test of UpdateProduct method, of class MaintainCatalogUI.
     */
    @Test
    public void testUpdateProduct() throws Exception {
        System.out.println("UpdateProduct");
        String input = "3\n1\n4\n4\n1\n1\ny\n";
        String input2 = "3\n1\n4\n4\n0\n0\ny\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        InputStream in2 = new java.io.ByteArrayInputStream(input2.getBytes());
        System.setIn(in);
        System.setIn(in2);
        MaintainCatalogUI.UpdateProduct();
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveProduct method, of class MaintainCatalogUI.
     */
    @Test
    public void testRemoveProduct() throws Exception {
        System.out.println("RemoveProduct");
        String input = "3\n1\n1\n.\n";
        String input2 = "3\n1\n0\n.\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        InputStream in2 = new java.io.ByteArrayInputStream(input2.getBytes());
        System.setIn(in); 
        System.setIn(in2);
        MaintainCatalogUI.RemoveProduct();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of MaintainCatalogMenu method, of class MaintainCatalogUI.
     */
    @Test
    public void testMaintainCatalogMenu() throws Exception {
        String input = "1\n";
        String input2 = "2\n";
        String input3 = "3\n";
        String input4 = "4\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        InputStream in2 = new java.io.ByteArrayInputStream(input2.getBytes());
        InputStream in3 = new java.io.ByteArrayInputStream(input3.getBytes());
        InputStream in4 = new java.io.ByteArrayInputStream(input4.getBytes());
        System.setIn(in);
        System.setIn(in2);
        System.setIn(in3);
        System.setIn(in4);
        System.out.println("MaintainCatalogMenu");
        MaintainCatalogUI.MaintainCatalogMenu();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
