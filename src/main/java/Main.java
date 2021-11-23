
import ProgramPackages.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
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
        String line = null;
        Integer lineNumber = 0;
        String[] data = null;
        ArrayList<Person> peopleList = new ArrayList<Person>();
        Comparator<Person> cp = null;
        Stream<Person> sm = null;
        Person[] sortedPeople = null;
                
        // try to open the file
        try {
            
            // create a FileReader object using the command line input as the
            // spreadsheet file address
            fr = new FileReader(String.join(" ", args));
            
            // read the file
            buffer = new BufferedReader(fr);
            while((line = buffer.readLine()) != null) {
                
                // count the number of lines read
                lineNumber++;
                // after the first line, create objects for each person
                // as the first line contains headings
                if (lineNumber > 1) {
                    data = line.split(",");
                    peopleList.add(new Person(data));
                }
                
            }
            
            // close the file
            buffer.close();
            
            // filter Person objects in peopleList by division and points
            cp = Comparator.comparing(Person::getDivision).thenComparing(Person::getPoints);
            
            // sort peopleList
            sm = peopleList.stream().sorted(cp);
            
            // convert the sorted peopleList stream into a Person array
            sortedPeople = sm.toArray(Person[]::new);
            
            // loop through peopleList and print the top three results in YAML format
            System.out.println("Top three results sorted by division and points");
            System.out.println("records:");
            
            for(int x = 0; x < 3; x++) {
                
                // print name
                System.out.println(
                        "- name: " + 
                        sortedPeople[x].getFirstName() + " " + 
                        sortedPeople[x].getLastName()
                );
                
                // print details about person
                System.out.println(
                        "  details: In division " + 
                        sortedPeople[x].getDivision() + 
                        " from " +
                        sortedPeople[x].getDate() + 
                        " performing " + 
                        sortedPeople[x].getSummary()
                );
                
            }
            
        } catch (FileNotFoundException ex) {
            
            System.out.println(ex);
            
        } catch (Exception e) {
            
            System.out.println(e);
            
        }
        
    }
    
}
