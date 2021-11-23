
import ProgramPackages.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

/*
 * This is the main class of the application
 * This class takes a file name from the command line,
 * reads through the file, and prints the three highest
 * ranking people based on division and points in YAML
 * format
 */

/**
 * @author Mathias Jones
 */
public class Main {
    
    public static void main(String[] args) {
        
        // initialise variables
        FileReader fr = null;
        BufferedReader buffer = null;
        ArrayList<Person> peopleList = new ArrayList<Person>();
        Person[] sortedPeople = null;
                
        // try to open the file
        try {
            
            // create a FileReader object using the command line input as the
            // spreadsheet file address
            fr = new FileReader(String.join(" ", args));
            
            // read the file
            buffer = new BufferedReader(fr);
            
            // reads the file and makes an ArrayList of Person objects
            peopleList = readFile(buffer);
            
            // sorts the people objects by division and points
            sortedPeople = sortPeopleByDivisionAndPoints(peopleList);
            
            // print the results to the console in YAML format
            printResultsToConsole(sortedPeople);
            
        } catch (FileNotFoundException ex) {
            
            System.out.println(ex);
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        
    }
    
    /*
        Takes a buffered reader object and traverses each line to scrape data
        about each person to create Person objects
        @var br - a BufferedReader object created from a file name
        @return - an ArrayList of Person objects to be used for comparisons
    */
    public static ArrayList<Person> readFile(BufferedReader br) {
        
        // initialise variables
        String line = null; // for each row in the .csv file
        Integer lineNumber = 0; // counts the number of lines
        String[] data = null; // temp value to store current row data
        ArrayList<Person> result = new ArrayList<Person>(); // holds Person objects
        
        try {
            
            while((line = br.readLine()) != null) {
                
                // count the number of lines read
                lineNumber++;
                // after the first line, create objects for each person
                // as the first line contains headings
                if (lineNumber > 1) {
                    data = line.split(",");
                    result.add(new Person(data));
                }
                
            }
            
            // close the file
            br.close();
            
        } catch (IOException e1) {
            
            System.out.println(e1);
            
        } catch (ParseException e2) {
            
            System.out.println(e2);
            
        }
            
        return result;
        
    }
    
    /*
        Sorts people by division and points
        @var arrList - an ArrayList data structure with Person objects
        @return - an array of Person objects that has been sorted by division
        and points
    */
    public static Person[] sortPeopleByDivisionAndPoints(ArrayList<Person> arrList) {
        
        // initialise comparator and stream variables
        Comparator<Person> cp = null;
        Stream<Person> sm = null;
        
        // filter Person objects in peopleList by division and points
        cp = Comparator.comparing(Person::getDivision).thenComparing(Person::getPoints);
            
        // sort peopleList
        sm = arrList.stream().sorted(cp);
        
        // convert the sorted peopleList stream into a Person array
        return sm.toArray(Person[]::new);
        
    }
    
    /*
        Prints the details of people to the console that have been sorted by
        division and points
        @var arr - an array of Person objects that have been sorted
        @return - nothing
    */
    public static void printResultsToConsole(Person[] arr) {
        
        // loop through peopleList and print the top three results in YAML format
        System.out.println("Top three results sorted by division and points");
        System.out.println("records:");
            
        for(int x = 0; x < 3; x++) {
                
            // print name
            System.out.println(
                    "- name: " + 
                    arr[x].getFirstName() + " " + 
                    arr[x].getLastName()
            );
                
            // print details about person
            System.out.println(
                    "  details: In division " + 
                    arr[x].getDivision() + 
                    " from " +
                    arr[x].getDate() + 
                    " performing " + 
                    arr[x].getSummary()
            );
             
        }
        
    }
    
}
