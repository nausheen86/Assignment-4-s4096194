package assignment4nausheen;

import java.io.*; // imports everything in io class
import java.util.*; // imports everything in util class
import java.text.SimpleDateFormat; // for date fomatting

public class Prescription {

    private int prescID;
    private String firstName;
    private String lastName;
    private String address;
    private float sphere;
    private float axis;
    private float cylinder;
    private Date examinationDate; 
    private String optometrist;
    private String[] remarkTypes = {"Client", "Optometrist"}; // only valid remark types 
    private ArrayList<String> postRemarks = new ArrayList<>(); // remarks added here

    public boolean addPrescription(int prescID, String firstName, String lastName, String address,
                                   float sphere, float cylinder, float axis,
                                   Date examinationDate, String optometrist) { // parameters needed
        
    	// Condition 1: First Name and Last Name length between 4 and 15 characters
        if (firstName.length() < 4 || firstName.length() > 15 || 
            lastName.length() < 4 || lastName.length() > 15) {
            return false; // wont reach here if conditions are valid
        }

        // Condition 2: Address should have a minimum of 20 characters
        if (address.length() < 20) {
            return false; 
        }

        // Condition 3: Sphere (-20.00 to +20.00), Cylinder (-4.00 to +4.00), Axis (0 to 180)
        if (sphere < -20.00 || sphere > 20.00 || 
            cylinder < -4.00 || cylinder > 4.00 || 
            axis < 0 || axis > 180) {
            return false; 
        }

        // Condition 5: Optometrist's name length between 8 and 25 characters
        if (optometrist.length() < 8 || optometrist.length() > 25) {
            return false; 
        }

        // Assigns valid values to member variables if all if statements pass
        this.prescID = prescID; 
        this.firstName = firstName; 
        this.lastName = lastName; 
        this.address = address; 
        this.sphere = sphere; 
        this.cylinder = cylinder; 
        this.axis = axis; 
        this.examinationDate = examinationDate; 
        this.optometrist = optometrist;

        // Write to presc.txt, FileWriter object created
        try (FileWriter writer = new FileWriter("presc.txt", true)) { // true so it dosent overwrite existing txt in file
            writer.write("Prescription ID: " + this.prescID + "\n");
            writer.write("First Name: " + this.firstName + "\n"); // \n is nextLine
            writer.write("Last Name: " + this.lastName + "\n");
            writer.write("Address: " + this.address + "\n");
            writer.write("Sphere: " + this.sphere + "\n");
            writer.write("Cylinder: " + this.cylinder + "\n");
            writer.write("Axis: " + this.axis + "\n");
            writer.write("Examination Date: " + formatExaminationDate(this.examinationDate) + "\n"); // calls formatExaminationDate
            writer.write("Optometrist: " + this.optometrist + "\n" + "\n");                          // method below
            return true; // written to presc.txt 
        } catch (IOException e) {
            e.printStackTrace(); // handles errors
        }
        return false; // fails to write to presc.txt
    }

    // Helper method to format the examination date (dd/MM/yy)
    private String formatExaminationDate(Date examinationDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        return formatter.format(examinationDate); // returns formatted date as above
    }

    public boolean addRemark(String remark, String category) { // parameters needed
    	
    	// Condition 1. The remark text should have a minimum of 6 words and 
    	//a maximum of 20 words. Moreover, the first character of the first 
    	//word should be an uppercase letter. 
    	
    	// Count the number of words in the remark
        int wordCount = 1; 
        for (int i = 0; i < remark.length(); i++) {
            if (remark.charAt(i) == ' ') {
                wordCount++;
            }
        }

        if (wordCount < 6 || wordCount > 20 || !Character.isUpperCase(remark.charAt(0))) {
            return false; // Invalid remark
        }

        // Condition 2.  Remark belongs to only one of the following 2 categories: 
        //“client” or “optometrist”:
        if (!Arrays.asList(remarkTypes).contains(category)) { // using ArrayList
            return false; // Invalid category
        }

        // Additionally, a prescription cannot have more than 2 remarks.
        if (postRemarks.size() > 2) {
            return false; 
        }

        // adds to ArrayList postRemarks
        postRemarks.add(remark);

        // Write to remark.txt, FileWriter object created
        try (FileWriter writer = new FileWriter("remark.txt", true)) { // true so it dosent overwrite existing txt in file
            writer.write("Remark: " + remark + "\n");
            writer.write("Category: " + category + "\n" + "\n"); //to create a empty line space
            return true; // written to remark.txt 
        } catch (IOException e) {
            e.printStackTrace(); // handles errors
        }
        return false; // fails to write to remark.txt
    }
}
