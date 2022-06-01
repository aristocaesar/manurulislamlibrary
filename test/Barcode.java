
import com.barcodelib.barcode.Linear;
import java.io.File;
import static javax.swing.text.html.HTML.Tag.TR;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class Barcode {

    public Barcode() {
    try{
                
        Linear barcode = new Linear();
        barcode.setType(Linear.CODE128B);
        barcode.setData("TR-1653882287217");
        barcode.setI(11.0f);
        File filePath = new File("src/com/manurul/report/barcode/TR-1653882287217.png");
        barcode.renderBarcode(filePath.getAbsolutePath());
                    
            
    }catch(Exception error){
        
        System.out.println(error.getMessage());
    }
    
}
    
    public static void main(String[] args) {
        new Barcode();
    }
    
}
