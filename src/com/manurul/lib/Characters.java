/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

/**
 *
 * @author caesarhome
 */
public class Characters {
    
    public static String ucwords(String str){
        
        if(str.equals("")){
            return "";
        }
        
        String result = "";
        
        String[] strs = str.split(" ");

        for(String res: strs){
            
            res = res.toLowerCase();
            
            res = res.substring(0, 1).toUpperCase() + res.substring(1);
            
            result += " " + res;
        }
        
        return result.trim();
        
    }
    
}
