package assignment4nausheen;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;


public class Testers {
	
	// addPrescription

    @Test
    public void testAddPrescriptionValid() {
        Date d1 = new Date();
        Prescription post1 = new Prescription();
        // Test Data 1: Valid input
        assertTrue(post1.addPrescription(1, "Liam", "Smith", "123 Bourke Street, Melbourne, 3000, Australia", -19.50f, -3.50f, 100f, d1, "Dr. Optometrist"));
        // Test Data 2: Valid input
        assertTrue(post1.addPrescription(2, "Bobby", "Lamar", "456 Sydney Road, Sydney, 2000, Australia", 15.25f, -2.25f, 80f, d1, "Dr. Optometrist"));
    }

    @Test
    public void testAddPrescriptionInvalidFirstName() {
        Date d1 = new Date();
        Prescription post2 = new Prescription();
        // Test Data 1: Too short first name
        assertFalse(post2.addPrescription(3, "Li", "Smith", "123 Bourke Street, Melbourne, 3000, Australia", -10.00f, -2.00f, 90f, d1, "Dr. Optometrist"));
        // Test Data 2: Too long first name
        assertFalse(post2.addPrescription(4, "JonathanJonathanJonathan", "Smith", "456 Bourke Street, Melbourne, 3000, Australia", -10.00f, -2.00f, 90f, d1, "Dr. Optometrist"));
    }

    @Test
    public void testAddPrescriptionInvalidLastName() {
        Date d1 = new Date();
        Prescription post3 = new Prescription();
        // Test Data 1: Too short last name
        assertFalse(post3.addPrescription(5, "Liam", "S", "123 Bourke Street, Melbourne, 3000, Australia", -5.00f, -2.00f, 70f, d1, "Dr. Optometrist"));
        // Test Data 2: Too long last name
        assertFalse(post3.addPrescription(6, "Liam", "WashingtonWashingtonWashington", "456 Bourke Street, Melbourne, 3000, Australia", -5.00f, -2.00f, 70f, d1, "Dr. Optometrist"));
    }

    @Test
    public void testAddPrescriptionInvalidAddress() {
        Date d1 = new Date();
        Prescription post4 = new Prescription();
        // Test Data 1: Address too short
        assertFalse(post4.addPrescription(7, "Liam", "Smith", "123 St", -15.00f, -2.50f, 180f, d1, "Dr. Optometrist"));
        // Test Data 2: Address too short
        assertFalse(post4.addPrescription(8, "Liam", "Smith", "456 Dr", -15.00f, -2.50f, 180f, d1, "Dr. Optometrist"));
    }

    @Test
    public void testAddPrescriptionInvalidSphere() {
        Date d1 = new Date();
        Prescription post5 = new Prescription();
        // Test Data 1: Sphere value too big
        assertFalse(post5.addPrescription(9, "Liam", "Smith", "123 Henry Street, Sydney, 2000, Australia", -25.00f, -2.50f, 160f, d1, "Dr. Optometrist"));
        // Test Data 2: Sphere value too small
        assertFalse(post5.addPrescription(10, "Liam", "Smith", "456 Henry Street, Sydney, 2000, Australia", 30.00f, -2.50f, 160f, d1, "Dr. Optometrist"));
    }

    @Test
    public void testAddPrescriptionInvalidOptometrist() {
        Date d1 = new Date();
        Prescription post6 = new Prescription();
        // Test Data 1: Optometrist name too short
        assertFalse(post6.addPrescription(11, "Liam", "Smith", "123 Henry Street, Brisbane, 4000, Australia", -5.00f, -3.00f, 60f, d1, "Dr. O"));
        // Test Data 2: Optometrist name too long
        assertFalse(post6.addPrescription(12, "Liam", "Smith", "456 Henry Street, Brisbane, 4000, Australia", -5.00f, -3.00f, 60f, d1, "Dr. OptometristOptometristOptometrist"));
    }

    // addRemark

    @Test
    public void testAddRemarkValidClient() {
        Prescription one = new Prescription();
        // Test Data 1: Valid remark
        assertTrue(one.addRemark("This is a valid client remark for testing.", "Client"));
        // Test Data 2: Another valid remark
        assertTrue(one.addRemark("The client was very happy with the service.", "Client"));
    }

    @Test
    public void testAddRemarkInvalidWordCount() {
        Prescription two = new Prescription();
        // Test Data 1: Too few words
        assertFalse(two.addRemark("Too short", "Client"));
        // Test Data 2: Too many words
        assertFalse(two.addRemark("This is a remark that is exceeding the twenty word limit for testing purposes and should therefore fail fail fail fail fail.", "Client"));
    }

    @Test
    public void testAddRemarkInvalidFirstLetterLowerCase() {
        Prescription three = new Prescription();
        // Test Data 1: First letter not capitalized
        assertFalse(three.addRemark("this is invalid because the first word is lowercase.", "Client"));
        // Test Data 2: First letter not capitalized
        assertFalse(three.addRemark("remark text starts in lowercase.", "Client"));
    }

    @Test
    public void testAddRemarkInvalidCategory() {
        Prescription four = new Prescription();
        // Test Data 1: Invalid category
        assertFalse(four.addRemark("This is a valid remark with invalid category.", "Doctor"));
        // Test Data 2: Invalid category
        assertFalse(four.addRemark("Another valid remark with invalid category.", "Admin"));
    }

    @Test
    public void testAddRemarkExceedingLimit() {
        Prescription five = new Prescription();
        // Test Data 1: Adding two valid remarks
        five.addRemark("This is the first remark.", "Client");
        five.addRemark("This is the second remark.", "Optometrist");
        // Test Data 2: Exceeding limit (third remark)
        assertFalse(five.addRemark("This is the third remark.", "Client"));
    }

    @Test
    public void testAddRemarkValidOptometrist() {
        Prescription six = new Prescription();
        // Test Data 1: Valid optometrist remark
        assertTrue(six.addRemark("This is a valid optometrist remark for testing.", "Optometrist"));
        // Test Data 2: Valid optometrist remark
        assertTrue(six.addRemark("The optometrist recommends a follow-up visit.", "Optometrist"));
    }

}
