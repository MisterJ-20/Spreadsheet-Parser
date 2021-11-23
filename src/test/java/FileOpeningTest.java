/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class FileOpeningTest {
    
    private Main mn;
    
    public FileOpeningTest() {
        
        mn = new Main();
        
    }
    
    @Test //(expected = FileNotFoundException.class)
    public void testEmptyFilePath() {
        // tests that the program shoudl throw a file not found exception
        // if an empty file path is supplied
    }
}
