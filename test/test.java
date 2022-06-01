/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class test {
    
    void Gas(){
    
        int epoch = 14;
        int masa_pinjam = 5;
        
        int hasil = epoch - masa_pinjam;
        
        int satuHari = 1;
        int dataHari = 0;
        while(hasil >= satuHari){
            hasil = hasil - satuHari;
            dataHari++;
        }
        
        System.out.println(dataHari);
        
    }
    
    public static void main(String[] args) {
        
        new test().Gas();
    }
    
}
