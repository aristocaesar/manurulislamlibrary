/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 *
 * @author DKODE Creative
 */
public class InputBorder extends javax.swing.JTextField {
    
    private JTextField Input;
    private int l = 8;
    
    public static void set(JTextField Input,int l){
        Input.setBorder(BorderFactory.createCompoundBorder(Input.getBorder(), BorderFactory.createEmptyBorder(0, l, 0, 0))); 
    }
    
}
