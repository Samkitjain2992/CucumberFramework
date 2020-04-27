package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {
    public  String getTodayDate(){
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("d/M/yyyy ");

        //get current date time with Date()
        Date date = new Date();

        // Now format the date
        String todayDate= dateFormat.format(date);
        System.out.println(todayDate);
        return todayDate;



    }

//    public static void main(String[] args) {
//        getTodayDate();
//
//    }


}
