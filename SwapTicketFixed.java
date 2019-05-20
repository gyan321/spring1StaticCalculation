package com.derivatives.swapticket;

import java.lang.Math;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import com.derivatives.model.SwapTicketModel;

public class SwapTicketFixed {
	String htmlxtModStatus = "loaded"; 
	SwapTicketModel swapTicketModelObject = new SwapTicketModel();

	/*
	 * @formating start date values
	 * 
	 */
	public void FixedchangeStartDateFormat(String startDate) {
		try {
			SwapTicketModel.setConvertedstartDate(LocalDate.parse(dateFormatProcess(startDate)));
		} catch (ParseException exception) {
			exception.printStackTrace();
		}

	}
	

	/*
	 * @formating end date values
	 * 
	 */
	public void changeEndDateFormat(String endDate) {
		try {
			SwapTicketModel.setEndDate(dateFormatProcess(endDate));
		} catch (ParseException exception) {
			exception.printStackTrace();
		}
	}

	
	/*
	 * @ common date formating process for both startDate and endDate
	 * 
	 */
	public static String dateFormatProcess(String dateString) throws ParseException {

		DateFormat givenDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date parsedDateFormate = givenDateFormat.parse(dateString);
		return new SimpleDateFormat("yyyy-MM-dd").format(parsedDateFormate);

	}

	/*
	 * @Counting number of days between two dates
	 * 
	 */
	public void countingNoOfDays(LocalDate randomStartDate, LocalDate randomEndDate) { 

		// calculating number of days in between
		SwapTicketModel.setNoOfDays(ChronoUnit.DAYS.between(randomStartDate, randomEndDate));

	}
	

	/*
	 * @determining next possible date from the given start date ,considering	  
	 * @ AccrualFrequency
	 * 
	 */
	LocalDate randomStartDate = SwapTicketModel.getConvertedstartDate();

	public LocalDate nextDate(LocalDate randomStartDate) {
		return randomStartDate.plusMonths(SwapTicketModel.getConvertedAccrualFrequency());
		// return randomStartDate.plusMonths(6);
	}

	
	
	/*
	 * @method to convert the "dd-mm-yyyy" date format to requied "dd/MM/yyy"
	 * 
	 */
	public String requiredDateFormat(LocalDate date){  
		
		String formattedDate2 =date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
		return formattedDate2; 
	}
	
	
	/*
	 * @method to be executed where roundingOff a calculated value is required.
	 * 
	 */
	public static double  RoundingOff(double anyCalulatedValue)
	{
		double modifiedDCF1 = (double) Math.round(anyCalulatedValue * 1000d) / 1000d;
		return modifiedDCF1; 
	}
	
	
	/*
	 * @method to be executed on swap ticket button's click
	 * 
	 */
	public void FixedSwapTicketLoad()
	{
		swapTicketModelObject.setScheduleEventWork(true);
		swapTicketModelObject.setTxtModStatus("loaded"); 
	}
	
	
	
	/*
	 * @method to be executed on schedule button's click
	 * 
	 */
	public void onFixedScheduleLoad() {

		if (swapTicketModelObject.isScheduleEventWork() == true) {

			if (htmlxtModStatus.equals(swapTicketModelObject.getTxtModStatus())) {
				
				System.out.println("PV Calculation on REC side for fixed FixedQuote Rate");
				System.out.println("-----------------------------------------------------");

				System.out.println("Tenor :" + SwapTicketModel.getTenor());

				System.out.println("AccuralFrequency :" + SwapTicketModel.getAccrualFrequency()+"\n");
				
				
				/*
				 * @ Calculating PV for the first compounding period
				 * 
				 */
				System.out.println("first compounding:");
				System.out.println("--------------------");
				//System.out.println("couponStartDate :" + SwapTicketModel.getConvertedstartDate());
				System.out.println("couponStartDate :" + requiredDateFormat(SwapTicketModel.getConvertedstartDate()));
				SwapTicketModel.setAccrualFrequency(SwapTicketModel.getAccrualFrequency());

				LocalDate firstNextDate = nextDate(SwapTicketModel.getConvertedstartDate());
				System.out.println("couponEndDate :" + requiredDateFormat(firstNextDate));  
				
				System.out.println("Notional:" + SwapTicketModel.getNotional());		 
				System.out.println("periodRate:" + SwapTicketModel.getFixedQuote());

				// int firstDaysCount = 181;
				countingNoOfDays(SwapTicketModel.getConvertedstartDate(), firstNextDate);
				System.out.println("number of days between:"+SwapTicketModel.getNoOfDays());

				double DCF1 = ((double) SwapTicketModel.getNoOfDays() / (double) 360);
				
				//double modifiedDCF1 = (double) Math.round(DCF1 * 100000d) / 100000d;
				double modifiedDCF1 = SwapTicketFixed.RoundingOff(DCF1) ;
				
				System.out.println("dcf:" + modifiedDCF1);

				double cashFlow1 = SwapTicketModel.getNotional() * SwapTicketModel.getFixedQuote() * DCF1;
				System.out.println("cashFlow: " + cashFlow1);

				double Zcdf1 = Math.exp(-1 * DCF1 * SwapTicketModel.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf1);

				double PV1 = Math.round((cashFlow1 * Zcdf1) * 100d) / 100d;
				System.out.println("first PV: " + PV1 + "\n");
				
				
				
				/*
				 * @ Calculating PV for the second compounding period
				 * 
				 */

				System.out.println("second compounding:");
				System.out.println("--------------------");
				LocalDate secondNextDate = nextDate(firstNextDate);
				System.out.println("couponStartDate :" +requiredDateFormat(firstNextDate));

				System.out.println("couponEndDate :" + requiredDateFormat(secondNextDate));
				System.out.println("Notional:" + SwapTicketModel.getNotional());
				System.out.println("periodRate:" + SwapTicketModel.getFixedQuote());

				// int secondDaysCount = 186;
				countingNoOfDays(firstNextDate, secondNextDate);
				System.out.println("number of days between:"+SwapTicketModel.getNoOfDays());

				double DCF2 = ((double) SwapTicketModel.getNoOfDays() / (double) 360);
				
				double d2 = (double) Math.round(DCF2 * 100000d) / 100000d;
				System.out.println("dcf:" + d2);

				double cashFlow2 = SwapTicketModel.getNotional() * SwapTicketModel.getFixedQuote() * DCF2;
				System.out.println("cashFlow: " + cashFlow2);

				double Zcdf2 = Math.exp(-1 * DCF2 * SwapTicketModel.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf2);

				double PV2 = Math.round((cashFlow1 * Zcdf2) * 100d) / 100d;
				System.out.println("second PV: " + PV2 + "\n");
				
				
				
				/*
				 * @ Calculating PV for the third compounding period
				 * 
				 */
				System.out.println("third compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate :" + requiredDateFormat(secondNextDate));
				LocalDate thirdNextDate = nextDate(secondNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(thirdNextDate));
				System.out.println("Notional:" + SwapTicketModel.getNotional());
				System.out.println("periodRate:" + SwapTicketModel.getFixedQuote());

				// int thirdDaysCount = 179;
				countingNoOfDays(secondNextDate, thirdNextDate);
				System.out.println("number of days between:"+SwapTicketModel.getNoOfDays());

				double DCF3 = ((double) SwapTicketModel.getNoOfDays() / (double) 360);

				double d3 = (double) Math.round(DCF3 * 100000d) / 100000d;
				System.out.println("dcf:" + d3);

				double cashFlow3 = SwapTicketModel.getNotional() * SwapTicketModel.getFixedQuote() * DCF3;
				System.out.println("cashFlow: " + cashFlow3);

				double Zcdf3 = Math.exp(-1 * DCF3 * SwapTicketModel.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf3);

				double PV3 = Math.round((cashFlow1 * Zcdf3) * 100d) / 100d;
				System.out.println("third PV: " + PV3 + "\n");
				
				
				/*
				 * @ Calculating PV for the fourth compounding period
				 * 
				 */
				System.out.println("fourth compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate : " + requiredDateFormat(thirdNextDate));
				LocalDate fourthNextDate = nextDate(thirdNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(fourthNextDate));
				System.out.println("Notional:" + SwapTicketModel.getNotional());
				System.out.println("periodRate:" + SwapTicketModel.getFixedQuote());

				// int fourthDaysCount = 185;
				countingNoOfDays(thirdNextDate, fourthNextDate);
				System.out.println("number of days between:"+SwapTicketModel.getNoOfDays());

				double DCF4 = ((double) SwapTicketModel.getNoOfDays() / (double) 360);

				double d4 = (double) Math.round(DCF4 * 100000d) / 100000d;
				System.out.println("dcf:" + d4);

				double cashFlow4 = SwapTicketModel.getNotional() * SwapTicketModel.getFixedQuote() * DCF4;
				System.out.println("cashFlow: " + cashFlow4);

				double Zcdf4 = Math.exp(-1 * DCF4 * SwapTicketModel.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf4);

				double PV4 = Math.round((cashFlow1 * Zcdf4) * 100d) / 100d;
				System.out.println("fourth PV: " + PV4 + "\n");
				
				
				/*
				 * @ Calculating PV for the fifth compounding period
				 * 
				 */
				System.out.println("fifth compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate :" +requiredDateFormat(fourthNextDate));
				LocalDate fifthNextDate = nextDate(fourthNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(fifthNextDate));
				System.out.println("Notional:" + SwapTicketModel.getNotional());
				System.out.println("periodRate:" + SwapTicketModel.getFixedQuote());

				// int fifthDaysCount = 183;
				countingNoOfDays(fourthNextDate, fifthNextDate);
				System.out.println("number of days between:"+SwapTicketModel.getNoOfDays());

				double DCF5 = ((double) SwapTicketModel.getNoOfDays() / (double) 360);

				double d5 = (double) Math.round(DCF5 * 100000d) / 100000d;
				System.out.println("dcf:" + d5);

				double cashFlow5 = SwapTicketModel.getNotional() * SwapTicketModel.getFixedQuote() * DCF5;
				System.out.println("cashFlow: " + cashFlow5);

				double Zcdf5 = Math.exp(-1 * DCF5 * SwapTicketModel.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf5);

				double PV5 = Math.round((cashFlow1 * Zcdf5) * 100d) / 100d;
				System.out.println("fifth PV: " + PV5 + "\n");
				
				

				/*
				 * @ Calculating PV for the sixth compounding period
				 * 
				 */
				System.out.println("sixth compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate:" + requiredDateFormat(fifthNextDate));
				LocalDate sixthNextDate = nextDate(fifthNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(sixthNextDate));
				System.out.println("Notional:" + SwapTicketModel.getNotional());
				System.out.println("periodRate:" + SwapTicketModel.getFixedQuote());

				// int sixDaysCount = 182;
				countingNoOfDays(fifthNextDate, sixthNextDate);
				System.out.println("number of days between:"+SwapTicketModel.getNoOfDays());

				double DCF6 = ((double) SwapTicketModel.getNoOfDays() / (double) 360);

				double d6 = (double) Math.round(DCF6 * 100000d) / 100000d;
				System.out.println("dcf:" + d6);

				double cashFlow6 = SwapTicketModel.getNotional() * SwapTicketModel.getFixedQuote() * DCF6;
				System.out.println("cashFlow: " + cashFlow6);

				double Zcdf6 = Math.exp(-1 * DCF6 * SwapTicketModel.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf6);

				double PV6 = Math.round((cashFlow1 * Zcdf6) * 100d) / 100d;
				System.out.println("sixth PV: " + PV6 + "\n");

				

				/*
				 * @ calculating TotalPVamount
				 * 
				 */
				System.out.println("-----------------------------------");
				swapTicketModelObject.setTotalPvAmount(PV1 + PV2 + PV3 + PV4 + PV5 + PV6);
				System.out.println("Total PV amount is:" + swapTicketModelObject.getTotalPvAmount());
				
				
				/*
				 * @ calculating TotalPaymentAmount
				 * 
				 */
				swapTicketModelObject.setTotalPaymentAmount(
						Math.round((cashFlow1 + cashFlow2 + cashFlow3 + cashFlow4 + cashFlow5 + cashFlow6)*100d)/100d);
								
				System.out.println("Total Payment amount is:" + swapTicketModelObject.getTotalPaymentAmount()+"\n");

			}
			
			else 
			{
				// retrieve value from screen and complete calculation
			}
		}
	}

}