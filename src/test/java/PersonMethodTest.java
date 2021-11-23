/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ProgramPackages.Person;
import java.text.ParseException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dagre
 */
public class PersonMethodTest {
    
    private Person person;
    
    public PersonMethodTest() throws ParseException {
        
        String[] data = {"Joe", "Smith", "2018-10-12", "2", "33", "General Duties"};
        this.person = new Person(data);
        
    }
    
    @Test
    /*
        Test the first name getter
    */
    public void testGetterFirstName() {
        
        String result = person.getFirstName();
        assertEquals(result, "Joe");
        
    }
    
    @Test
    /*
        Test the last name getter
    */
    public void testGetterLastName() {
        
        String result = person.getLastName();
        assertEquals(result, "Smith");
        
    }
    
    @Test
    /*
        Test the date getter
    */
    public void testGetterDate() {
        
        String result = person.getDate();
        assertEquals(result, "2018-10-12");
        
    }
    
    @Test
    /*
        Test the division getter
    */
    public void testGetterDivision() {
        
        Integer result = person.getDivision();
        assertEquals(result, 2);
        
    }
    
    @Test
    /*
        Test the points getter
    */
    public void testGetterPoints() {
        
        Integer result = person.getPoints();
        assertEquals(result, 33);
        
    }
    
    @Test
    /*
        Test the summary getter
    */
    public void testGetterSummary() {
        
        String result = person.getSummary();
        assertEquals(result, "General Duties");
        
    }
    
}
