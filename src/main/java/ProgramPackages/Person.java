package ProgramPackages;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mathias Jones
 */
public class Person {
    
    // initialise variables
    private String firstName;
    private String lastName;
    private Date date;
    private Integer division;
    private Integer points;
    private String summary;
    private SimpleDateFormat dateFormat;
    
    public Person(String[] data) throws ParseException {
        
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        this.firstName = data[0];
        this.lastName = data[1];
        this.date = dateFormat.parse(data[2]);
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
    public Date getDate() {
        
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
