/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author caesarhome
 */
public class GenKode {
    
    
    public static String RandomInt(String prefix, int length){
    
        Random Rand = new Random();
        
        prefix = prefix.toUpperCase();
        
        String num = "";
        
        for(int i = 0; i < length; i++){
            num += Rand.nextInt(9);
        }
        
        return prefix + " - " + num;
        
    }
    
    private static String getTimeMiliSecond(){
    
        String miliSecond = Long.toString(System.currentTimeMillis());
        return miliSecond;
        
    }
    
    public static String Transaksi(){
        
        //get milisdecond
        return "TR-" + getTimeMiliSecond();
        
    }
    
    public static String TransaksiGetDate(){
    
        Date date = new Date(Long.parseLong(getTimeMiliSecond()));
        SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss");
        return dateFormater.format(date);
    
    }
    
}
