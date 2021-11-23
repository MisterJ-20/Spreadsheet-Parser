package ProgramPackages;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Represents certain attributes of a serving person which can be retrieved,
 * These attributes are first name, last name, date, division, points scored
 * and a summary of their role
 */

/**
 *
 * @author Mathias Jones
 */
public class Person {
    
    // initialise variables
    private String firstName;
    private String lastName;
    private String date;
    private Integer division;
    private Integer points;
    private String summary;
    
    public Person(String[] data) throws ParseException {
                
        // assign variables their corresponding values from the data parameter
        this.firstName = data[0];
        this.lastName = data[1];
        this.date = data[2];
        this.division = Integer.parseInt(data[3]);
        this.points = Integer.parseInt(data[4]);
        this.summary = data[5];
        
    }
    
    /**
     * Retrieves the persons first name
     * @return - a string containing the first name
     */
    public String getFirstName() {
        
        return this.firstName;
        
    }
    
    /**
     * Retrieves the persons last name
     * @return - a string containing the last name
     */
    public String getLastName() {
        
        return this.lastName;
        
    }
    
    /**
     * Retrieves the persons date
     * @return - a date in the form of a date object
     */
    public String getDate() {
        
        return this.date;
        
    }
    
    /**
     * Retrieves the division that the person belongs to
     * @return - an integer representing the division they belong to
     */
    public Integer getDivision() {
        
        return this.division;
        
    }
    
    /**
     * Retrieves the number of points that the person scored
     * @return - an integer that represents the number of points scored
     */
    public Integer getPoints() {
        
        return this.points;
        
    }
    
    /**
     * Retrieves the description of the persons role
     * @return - a string containing their role
     */
    public String getSummary() {
        
        return this.summary;
        
    }
    
}
