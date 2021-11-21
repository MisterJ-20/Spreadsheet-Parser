
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

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
        ArrayList<Person> people = new ArrayList<Person>();
        
        System.out.println(String.join(" ", args));
        
        // open the file
        try {
            
            fr = new FileReader(String.join(" ", args));
            
            // read the file
            BufferedReader buffer = new BufferedReader(fr);
            while((line = buffer.readLine()) != null) {
                System.out.println(line);
                lineNumber++;
                // after the first line, create objects for each person
                if (lineNumber > 1) {
                    String[] data = line.split(",");
                    for(String x: data) {
                        System.out.println(x);
                    }
                    people.add(new Person(data));
                }
                System.out.println(lineNumber);
                System.out.println("\n");
            }
            
            buffer.close();
            
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
}
