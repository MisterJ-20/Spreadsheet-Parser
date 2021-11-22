
import ProgramPackages.Person;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mathias Jones
 */
public class Main {
    
    public static void main(String[] args) {
        
        // initialise variables
        FileReader fr = null;
        String line = null;
        Integer lineNumber = 0;
        ArrayList<Person> peopleList = new ArrayList<Person>();
        Comparator<Person> cp = null;
        Stream<Person> sm = null;
                
        // open the file
        try {
            
            fr = new FileReader(String.join(" ", args));
            
            // read the file
            BufferedReader buffer = new BufferedReader(fr);
            while((line = buffer.readLine()) != null) {
                lineNumber++;
                // after the first line, create objects for each person
                if (lineNumber > 1) {
                    String[] data = line.split(",");
                    peopleList.add(new Person(data));
                }
            }
            
            // close the file
            buffer.close();
            
            // filter Person objects in peopleList by division and points
            cp = Comparator.comparing(Person::getDivision).thenComparing(Person::getPoints);
            
            // sort peopleList
            sm = peopleList.stream().sorted(cp);
            
            // loop through peopleList and print the top three results in YAML format
            System.out.println("Top three results sorted by division and points");
            System.out.println("records:");
            
            for(int x = 0; x < 3; x++) {
                
                // print name
                System.out.println(
                        "- name: " + 
                        peopleList.get(x).getFirstName() + " " + 
                        peopleList.get(x).getLastName()
                );
                
                // print details about person
                System.out.println(
                        "- details: In division " + 
                        peopleList.get(x).getDivision() + 
                        " from " +
                        peopleList.get(x).getDate() + 
                        " performing " + 
                        peopleList.get(x).getSummary()
                );
                
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
