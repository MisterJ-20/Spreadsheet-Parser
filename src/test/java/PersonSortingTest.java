/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ProgramPackages.Person;
import java.text.ParseException;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author dagre
 */
public class PersonSortingTest {
    
    private ArrayList<Person> testList;
    private Person[] resultList;
    private Main mn;
    
    public PersonSortingTest() throws ParseException {
        
        String[] data1 = {"Terza", "Lowton", "2017-09-15", "1", "53", "Defensive Duties"};
        testList.add(new Person(data1));
        String[] data2 = {"Kayle", "Trayes", "2017-10-23", "9", "83", "Offensive Duties"};
        testList.add(new Person(data2));
        String[] data3 = {"Reba", "Crosi", "2017-10-23", "6", "84", "Offensive Duties"};
        testList.add(new Person(data3));
        String[] data4 = {"Barnett", "Dunnico", "2018-02-26", "5", "24", "Offensive Duties"};
        testList.add(new Person(data4));
        String[] data5 = {"Elke", "Collete", "2017-06-19", "6", "68", "Oversight Duties"};
        testList.add(new Person(data5));
        String[] data6 = {"Tess", "Gosson", "2017-12-22", "9", "22", "Defensive Duties"};
        testList.add(new Person(data6));
        String[] data7 = {"Zedekiah", "Miller", "2018-04-09", "3", "89", "Offensive Duties"};
        testList.add(new Person(data7));
        String[] data8 = {"Zelma", "Ivatt", "2018-01-02", "1", "72", "Offensive Duties"};
        testList.add(new Person(data8));
        String[] data9 = {"Vivia", "Twidell", "2017-11-17", "9", "72", "Offensive Duties"};
        testList.add(new Person(data9));
        String[] data10 = {"Alvira", "Elger", "2017-05-02", "6", "58", "Oversight Duties"};
        testList.add(new Person(data10));
        
        mn = new Main();
        
    }
    
    @Test
    /*
        Tests the order in which the Person objects are sorted, and asserts]
        the three top results
    */
    public void testSortingOrder() {
        
        // get the Person objects sorted
        resultList = mn.sortPeopleByDivisionAndPoints(testList);
        
        // use the first name of the top three results to check whether
        // the objects were sorted correctly
        assertEquals(resultList[0].getFirstName(), "Terza");
        assertEquals(resultList[1].getFirstName(), "Zelma");
        assertEquals(resultList[2].getFirstName(), "Zedekiah");
        
    }
}
