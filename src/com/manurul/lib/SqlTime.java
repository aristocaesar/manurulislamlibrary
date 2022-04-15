/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.manurul.lib;

import java.sql.Timestamp;
import java.util.Calendar;

/**
 *
 * @author caesarhome
 */
public class SqlTime {
    
    public Timestamp getTimeStamp(){
        
        Calendar cal = Calendar.getInstance();
        Timestamp time = new java.sql.Timestamp(cal.getTimeInMillis());
        return time;
    }
    
}
