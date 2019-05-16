package com.vishist.derivative.scheduleTest;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.vishist.derivative.scheduleService.SwapTicket; 

public class Test {
	
	
	public static void main(String[] args) {
		
		SwapTicket swapObject=new  SwapTicket();
		swapObject.SwapTicketLoad();
		swapObject.onScheduleLoad();
		
		/*counting the number of days between two date*/
		
		//24-May-2017, change this to your desired Start Date
		LocalDate dateBefore = LocalDate.of(2017, Month.FEBRUARY,1);
	        //29-July-2017, change this to your desired End Date
		LocalDate dateAfter = LocalDate.of(2017, Month.FEBRUARY,28);
		long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		System.out.println(noOfDaysBetween+1);
		
		
		
		String dateBeforeString = "2017-05-24";
		String dateAfterString = "2017-07-29";
			
		//Parsing the date
		LocalDate dateBefore1 = LocalDate.parse(dateBeforeString);
		LocalDate dateAfter1 = LocalDate.parse(dateAfterString);
			
		//calculating number of days in between
		long noOfDaysBetween1 = ChronoUnit.DAYS.between(dateBefore1, dateAfter1);
			
		//displaying the number of days
		System.out.println(noOfDaysBetween1);
		
		System.out.println("---------------------------------");
		
		/*converting date from one format to another date format
		 * */
		
        String utcDateStr = "07/05/2018";
        try {
            convert(utcDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
 
    public static void convert(String dateString) throws ParseException {
        System.out.println("Given date is " + dateString);
 
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdf.parse(dateString);
        System.out.println("yyyy-MM-dd formatted date : " + new SimpleDateFormat("yyyy-MM-dd").format(date));
 
    }

}
