
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caesarhome
 */
public class deleteFile {
    
    public static void main(String[] args) throws IOException {
        
        File currentFile = new File("src\\com\\manurul\\report\\barcode\\TR-1654619569606.png");
        Files.deleteIfExists(Paths.get(currentFile.getAbsolutePath()));
        
    }
    
}
