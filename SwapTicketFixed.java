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
	SwapTicketModel swapTicketModelObject = SwapTicketModel.getModelInstance();
	/*
	 * @formating start date values
	 * 
	 */
	public void FixedchangeStartDateFormat(String startDate) {
		try {
			swapTicketModelObject.setConvertedstartDate(LocalDate.parse(dateFormatProcess(startDate)));
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
		swapTicketModelObject.setNoOfDays(ChronoUnit.DAYS.between(randomStartDate, randomEndDate));

	}
	

	/*
	 * @determining next possible date from the given start date ,considering	  
	 * @ AccrualFrequency
	 * 
	 */
	LocalDate randomStartDate = swapTicketModelObject.getConvertedstartDate();

	public LocalDate nextDate(LocalDate randomStartDate) {
		return randomStartDate.plusMonths(swapTicketModelObject.getConvertedAccrualFrequency());
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
		double roundOffValued = (double) Math.round(anyCalulatedValue * 1000d) / 1000d;
		return roundOffValued; 
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

				System.out.println("Tenor :" + swapTicketModelObject.getTenor());

				System.out.println("AccuralFrequency :" + swapTicketModelObject.getAccrualFrequency()+"\n");
				
				
				/*
				 * @ Calculating PV for the first compounding period
				 * 
				 */
				System.out.println("first compounding:");
				System.out.println("--------------------");
				//System.out.println("couponStartDate :" + SwapTicketModel.getConvertedstartDate());
				System.out.println("couponStartDate :" + requiredDateFormat(swapTicketModelObject.getConvertedstartDate()));
				swapTicketModelObject.setAccrualFrequency(swapTicketModelObject.getAccrualFrequency());

				LocalDate firstNextDate = nextDate(swapTicketModelObject.getConvertedstartDate());
				System.out.println("couponEndDate :" + requiredDateFormat(firstNextDate));  
				
				System.out.println("Notional:" + swapTicketModelObject.getNotional());		 
				System.out.println("periodRate:" + swapTicketModelObject.getFixedQuote());

				// int firstDaysCount = 181;
				countingNoOfDays(swapTicketModelObject.getConvertedstartDate(), firstNextDate);
				System.out.println("number of days between:"+swapTicketModelObject.getNoOfDays());

				double DCF1 = ((double) swapTicketModelObject.getNoOfDays() / (double) 360);
				
				//double modifiedDCF1 = (double) Math.round(DCF1 * 100000d) / 100000d;
				double modifiedDCF1 = SwapTicketFixed.RoundingOff(DCF1) ;
				 
				System.out.println("dcf:" + modifiedDCF1);

				double cashFlow1 = swapTicketModelObject.getNotional() * swapTicketModelObject.getFixedQuote() * DCF1;
				System.out.println("cashFlow: " + SwapTicketFixed.RoundingOff(cashFlow1));

				double Zcdf1 = Math.exp(-1 * DCF1 * swapTicketModelObject.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf1);

				double PV1 = (cashFlow1 * Zcdf1) ;
				System.out.println("first PV: " + SwapTicketFixed.RoundingOff(PV1) + "\n");
				
				
				
				/*
				 * @ Calculating PV for the second compounding period
				 * 
				 */

				System.out.println("second compounding:");
				System.out.println("--------------------");
				LocalDate secondNextDate = nextDate(firstNextDate);
				System.out.println("couponStartDate :" +requiredDateFormat(firstNextDate));

				System.out.println("couponEndDate :" + requiredDateFormat(secondNextDate));
				System.out.println("Notional:" + swapTicketModelObject.getNotional());
				System.out.println("periodRate:" + swapTicketModelObject.getFixedQuote());

				// int secondDaysCount = 186;
				countingNoOfDays(firstNextDate, secondNextDate);
				System.out.println("number of days between:"+swapTicketModelObject.getNoOfDays());

				double DCF2 = ((double) swapTicketModelObject.getNoOfDays() / (double) 360);
				
				double d2 = SwapTicketFixed.RoundingOff(DCF2);
				System.out.println("dcf:" + d2);

				double cashFlow2 = swapTicketModelObject.getNotional() * swapTicketModelObject.getFixedQuote() * DCF2;
				System.out.println("cashFlow: " + SwapTicketFixed.RoundingOff(cashFlow2));

				double Zcdf2 = Math.exp(-1 * DCF2 * swapTicketModelObject.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf2);

				double PV2 = Math.round((cashFlow1 * Zcdf2) * 100d) / 100d;
				System.out.println("second PV: " +  SwapTicketFixed.RoundingOff(PV2) + "\n");
				
				
				
				/*
				 * @ Calculating PV for the third compounding period
				 * 
				 */
				System.out.println("third compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate :" + requiredDateFormat(secondNextDate));
				LocalDate thirdNextDate = nextDate(secondNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(thirdNextDate));
				System.out.println("Notional:" + swapTicketModelObject.getNotional());
				System.out.println("periodRate:" + swapTicketModelObject.getFixedQuote());

				// int thirdDaysCount = 179;
				countingNoOfDays(secondNextDate, thirdNextDate);
				System.out.println("number of days between:"+swapTicketModelObject.getNoOfDays());

				double DCF3 = ((double) swapTicketModelObject.getNoOfDays() / (double) 360);

				double d3 = SwapTicketFixed.RoundingOff(DCF3);
				System.out.println("dcf:" + d3);

				double cashFlow3 = swapTicketModelObject.getNotional() * swapTicketModelObject.getFixedQuote() * DCF3;
				System.out.println("cashFlow: " + SwapTicketFixed.RoundingOff(cashFlow3));

				double Zcdf3 = Math.exp(-1 * DCF3 * swapTicketModelObject.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf3);

				double PV3 = Math.round((cashFlow1 * Zcdf3) * 100d) / 100d;
				System.out.println("third PV: " +  SwapTicketFixed.RoundingOff(PV3) + "\n");
				
				
				/*
				 * @ Calculating PV for the fourth compounding period
				 * 
				 */
				System.out.println("fourth compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate : " + requiredDateFormat(thirdNextDate));
				LocalDate fourthNextDate = nextDate(thirdNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(fourthNextDate));
				System.out.println("Notional:" + swapTicketModelObject.getNotional());
				System.out.println("periodRate:" + swapTicketModelObject.getFixedQuote());

				// int fourthDaysCount = 185;
				countingNoOfDays(thirdNextDate, fourthNextDate);
				System.out.println("number of days between:"+swapTicketModelObject.getNoOfDays());

				double DCF4 = ((double) swapTicketModelObject.getNoOfDays() / (double) 360);

				double d4 = SwapTicketFixed.RoundingOff(DCF4);
				System.out.println("dcf:" + d4);

				double cashFlow4 = swapTicketModelObject.getNotional() * swapTicketModelObject.getFixedQuote() * DCF4;
				System.out.println("cashFlow: " +  SwapTicketFixed.RoundingOff(cashFlow4));

				double Zcdf4 = Math.exp(-1 * DCF4 * swapTicketModelObject.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf4);

				double PV4 = Math.round((cashFlow1 * Zcdf4) * 100d) / 100d;
				System.out.println("fourth PV: " +  SwapTicketFixed.RoundingOff(PV4) + "\n");
				
				
				/*
				 * @ Calculating PV for the fifth compounding period
				 * 
				 */
				System.out.println("fifth compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate :" +requiredDateFormat(fourthNextDate));
				LocalDate fifthNextDate = nextDate(fourthNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(fifthNextDate));
				System.out.println("Notional:" + swapTicketModelObject.getNotional());
				System.out.println("periodRate:" + swapTicketModelObject.getFixedQuote());

				// int fifthDaysCount = 183;
				countingNoOfDays(fourthNextDate, fifthNextDate);
				System.out.println("number of days between:"+swapTicketModelObject.getNoOfDays());

				double DCF5 = ((double) swapTicketModelObject.getNoOfDays() / (double) 360);

				double d5 = SwapTicketFixed.RoundingOff(DCF5);
				System.out.println("dcf:" + d5);

				double cashFlow5 = swapTicketModelObject.getNotional() * swapTicketModelObject.getFixedQuote() * DCF5;
				System.out.println("cashFlow: " + SwapTicketFixed.RoundingOff(cashFlow5));

				double Zcdf5 = Math.exp(-1 * DCF5 * swapTicketModelObject.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf5);

				double PV5 = Math.round((cashFlow1 * Zcdf5) * 100d) / 100d;
				System.out.println("fifth PV: " +  SwapTicketFixed.RoundingOff(PV5) + "\n");
				
				

				/*
				 * @ Calculating PV for the sixth compounding period
				 * 
				 */
				System.out.println("sixth compounding:");
				System.out.println("--------------------");
				System.out.println("couponStartDate:" + requiredDateFormat(fifthNextDate));
				LocalDate sixthNextDate = nextDate(fifthNextDate);
				System.out.println("couponEndDate :" + requiredDateFormat(sixthNextDate));
				System.out.println("Notional:" + swapTicketModelObject.getNotional());
				System.out.println("periodRate:" + swapTicketModelObject.getFixedQuote());

				// int sixDaysCount = 182;
				countingNoOfDays(fifthNextDate, sixthNextDate);
				System.out.println("number of days between:"+swapTicketModelObject.getNoOfDays());

				double DCF6 = ((double) swapTicketModelObject.getNoOfDays() / (double) 360);

				double d6 = SwapTicketFixed.RoundingOff(DCF6);
				System.out.println("dcf:" + d6);

				double cashFlow6 = swapTicketModelObject.getNotional() * swapTicketModelObject.getFixedQuote() * DCF6;
				System.out.println("cashFlow: " +  SwapTicketFixed.RoundingOff(cashFlow6));

				double Zcdf6 = Math.exp(-1 * DCF6 * swapTicketModelObject.getFixedQuote());
				System.out.println("Zcdf: " + Zcdf6);

				double PV6 = Math.round((cashFlow1 * Zcdf6) * 100d) / 100d;
				System.out.println("sixth PV: " +  SwapTicketFixed.RoundingOff(PV6) + "\n");

				

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