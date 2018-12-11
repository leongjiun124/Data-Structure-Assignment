/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testing;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;


import org.junit.Rule;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class TestingTest {
    
    public TestingTest() {
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
     * Test of main method, of class Testing.
     *//*
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Testing.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of menu method, of class Testing.
     */
    @Test
    public void testMenu() throws Exception {
        String input = "1\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        InputStream in = new ByteArrayInputStream(input.getBytes());
        //assertEquals(input, in);
        System.out.println("menu");
      
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Login method, of class Testing.
     *//*
    @Test
    public void testLogin() throws Exception {
        String input = "Mia Khalifa\n\n12345";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        //InputStream in2 = new java.io.ByteArrayInputStream(input2.getBytes());
        //System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        //System.setIn(new java.io.ByteArrayInputStream(input2.getBytes()));
        //InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        //assertEquals(input, in);
        System.out.println("Login");
        Testing.Login();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Register method, of class Testing.
     *//*
    @Test
    public void testRegister() throws Exception {
        System.out.println("Register");
        Testing.Register();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Selection method, of class Testing.
     */
    @Test/*
    public void testSelection() throws Exception {
        String input = "1";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
        System.out.println("Selection");
        Testing.Selection();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CustomizedFlowerMenu method, of class Testing.
     *//*
    @Test
    public void testCustomizedFlowerMenu() throws Exception {
        System.out.println("CustomizedFlowerMenu");
        Testing.CustomizedFlowerMenu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Booking method, of class Testing.
     *//*
    @Test
    public void testBooking() throws Exception {
        System.out.println("Booking");
        Testing.Booking();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearScreen method, of class Testing.
     *//*
    @Test
    public void testClearScreen() throws Exception {
        System.out.println("clearScreen");
        Testing.clearScreen();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CustomizedFlower method, of class Testing.
     *//*
    @Test
    public void testCustomizedFlower() throws Exception {
        System.out.println("CustomizedFlower");
        Testing.CustomizedFlower();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetCreditLimit method, of class Testing.
     *//*
    @Test
    public void testSetCreditLimit() throws Exception {
        System.out.println("SetCreditLimit");
        Testing.SetCreditLimit();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PickUpOrder method, of class Testing.
     *//*
    @Test
    public void testPickUpOrder() throws Exception {
        System.out.println("PickUpOrder");
        Testing.PickUpOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PickUpPriority method, of class Testing.
     *//*
    @Test
    public void testPickUpPriority() throws Exception {
        System.out.println("PickUpPriority");
        Testing.PickUpPriority();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TrackProductStock method, of class Testing.
     *//*
    @Test
    public void testTrackProductStock() throws Exception {
        System.out.println("TrackProductStock");
        Testing.TrackProductStock();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Report method, of class Testing.
     *//*
    @Test
    public void testReport() throws Exception {
        System.out.println("Report");
        Testing.Report();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DeliveryList method, of class Testing.
     *//*
    @Test
    public void testDeliveryList() throws Exception {
        System.out.println("DeliveryList");
        Testing.DeliveryList();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Corporate method, of class Testing.
     *//*
    @Test
    public void testCorporate() throws Exception {
        System.out.println("Corporate");
        Testing.Corporate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SalesOrder method, of class Testing.
     *//*
    @Test
    public void testSalesOrder() throws Exception {
        System.out.println("SalesOrder");
        Testing.SalesOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ItemizedBill method, of class Testing.
     */
    

    public void testItemizedBill() throws Exception {
            String input = "1\n";
            String input2 = "0\n";
            String input3 = "9\n";
            //System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
            //System.setIn(new java.io.ByteArrayInputStream(input2.getBytes()));
            System.setIn(new java.io.ByteArrayInputStream(input3.getBytes()));
            System.out.println("ItemizedBill");
            Testing.ItemizedBill();

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testTrackProductStock() throws Exception {
        System.out.println("TrackProductStock");
        String input = "1\n";
        String input2 = "0\n";
        String input3 = "9\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input2.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input3.getBytes()));
        Testing.TrackProductStock();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Report method, of class Testing.
     */
    @Test
    public void testReport() throws Exception {
        System.out.println("Report");
        String input = "1\n";
        String input2 = "0\n";
        String input3 = "9\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input2.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input3.getBytes()));       
        Testing.Report();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of DeliveryList method, of class Testing.
     */
    @Test
    public void testDeliveryList() throws Exception {
        System.out.println("DeliveryList");
        String input = "1\n";
        String input2 = "0\n";
        String input3 = "9\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input2.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input3.getBytes()));      
        Testing.DeliveryList();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of Corporate method, of class Testing.
     */
    @Test
    public void testCorporate() throws Exception {
        String input = "Mia Khalifa\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes())); 
        System.out.println("Corporate");
        Testing.Corporate();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of SalesOrder method, of class Testing.
     */
    @Test
    public void testSalesOrder() throws Exception {
        String input = "Mia Khalifa";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        System.out.println("SalesOrder");
        Testing.SalesOrder();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Testing.
     */
   

    /**
     * Test of PaymentList method, of class Testing.
     */
    @Test
    public void testPaymentList() throws Exception {
        System.out.println("PaymentList");
        String input = "1\n";
        String input2 = "0\n";
        String input3 = "9\n";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input2.getBytes()));
//        System.setIn(new java.io.ByteArrayInputStream(input3.getBytes()));
        Testing.PaymentList();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ResetCreditLimit method, of class Testing.
     */
    @Test
    public void testResetCreditLimit() throws Exception {
        System.out.println("ResetCreditLimit");
        String input = "1\ny\n1\n";
        InputStream in = new java.io.ByteArrayInputStream(input.getBytes());  
        System.setIn(in);
        Testing.ResetCreditLimit();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of PickUpOrder method, of class Testing.
     */

}
