/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SystemNpruPool;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Godonlyknows
 */
public class ClockCheck {
    public void CurrentDate(){
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        //date_txt.setText("Date"+year+"/"+(month+1)+"/"+day);
       // txt_time.setText("Time "+hour+":"+(minute)+":"+second);
                        
    }
}
