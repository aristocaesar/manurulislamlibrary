/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

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
    
    public static void main(String[] args) {
        System.out.println(RandomInt("PGS", 10));
    }
    
}
