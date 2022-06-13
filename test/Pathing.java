
import com.barcodelib.barcode.Linear;
import java.io.File;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caesarhome
 */
public class Pathing {
    
    public String Anjay(){
    
        System.out.println(getClass().getResourceAsStream("com/manurul/src/ICON_ADD.png"));
        return "ok";
    }
    
    public static void main(String[] args) {
        
        System.out.println(new Pathing().Anjay());
        
    }
    
}
