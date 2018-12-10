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
        MaintainCatalogUI.UpdateProduct();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoveProduct method, of class MaintainCatalogUI.
     */
    @Test
    public void testRemoveProduct() throws Exception {
        System.out.println("RemoveProduct");
        MaintainCatalogUI.RemoveProduct();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MaintainCatalogMenu method, of class MaintainCatalogUI.
     */
    @Test
    public void testMaintainCatalogMenu() throws Exception {
        String input = "1\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.out.println("MaintainCatalogMenu");
        MaintainCatalogUI.MaintainCatalogMenu();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
