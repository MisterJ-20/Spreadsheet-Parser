
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

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
        
        System.out.println(Arrays.toString(args));
        
        // open the file
        try {
            
            fr = new FileReader(args[0]);
            
            // read the file
            BufferedReader buffer = new BufferedReader(fr);
            while((line = buffer.readLine()) != null) {
                System.out.println(line);
                lineNumber++;
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
