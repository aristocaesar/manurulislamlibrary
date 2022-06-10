
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author caesarhome
 */
public class backupDatabase {
    
    public static void main(String[] args) {
        
        Timer timer = new Timer();
        
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Process p = null;
                try {
                    Runtime run = Runtime.getRuntime();
                    p = run.exec("C:/xampp/mysql/bin/mysqldump.exe -uroot -p --add-drop-database -B manurulislam -r F:/");
                    
                    int processComplete = p.waitFor();
                    if(processComplete == 0){
                        System.out.println("ok");
                    }else{
                        System.out.println("no");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(backupDatabase.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(backupDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };
        
        timer.scheduleAtFixedRate(task, 1000, 1000);
        
    }
    
}
