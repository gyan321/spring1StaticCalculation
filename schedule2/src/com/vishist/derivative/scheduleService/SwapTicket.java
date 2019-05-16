package com.vishist.derivative.scheduleService;

import com.vishist.derivative.scheduleModel.SwapTicketModel;
import java.lang.Math;
import java.text.DecimalFormat;

public class SwapTicket {
	String htmlxtModStatus="loaded";	 
	SwapTicketModel swapModel=new SwapTicketModel();
	
	
	
	 public void SwapTicketLoad() {
		 
		swapModel.setScheduleEventWork(true); 
		swapModel.setTxtModStatus("loaded");
		swapModel.setNotional(10000000l);
		swapModel.setAccrualFrequency(6);
		swapModel.setFixedQuote(0.0125);
	}
	 
	 
	 public void onScheduleLoad(){
		 
		 
		 if(swapModel.isScheduleEventWork()==true){
		 
		 if(htmlxtModStatus.equals(swapModel.getTxtModStatus()) ){
			 
			
			 //use predefined values from db
			 System.out.println("tenor: 3 years");
			 
			 System.out.println("Marching: semiAnnual\n");
			 System.out.println("first compounding:");
			 System.out.println("--------------------");
			 System.out.println("couponStartDate:27/9/13");
			 System.out.println("couponEndDate:27/3/14");
			 System.out.println("Notional:"+swapModel.getNotional());
			 System.out.println("periodRate:"+swapModel.getFixedQuote());
			 
			 int firstDaysCount=181;
			 
			 double DCF1=((double)181/(double)360);  
			 
			double d=(double)Math.round(DCF1 * 100000d)/100000d;			
			System.out.println("dcf:"+d);
			 
			 
			 
			 double cashFlow1=swapModel.getNotional()*swapModel.getFixedQuote()*DCF1;				 
			 System.out.println("cashFlow: "+cashFlow1);
			 
			 
			 double Zcdf1=Math.exp(-1*DCF1*swapModel.getFixedQuote());
			 System.out.println("Zcdf: "+Zcdf1);
			 
			 
			 double PV1= Math.round((cashFlow1*Zcdf1) * 100d)/100d;			 
			  System.out.println("first PV: "+PV1+"\n");
			 
			 
			  
			  System.out.println("second compounding:");
				 System.out.println("--------------------");
				 System.out.println("couponStartDate:27/3/14");
				 System.out.println("couponEndDate:29/9/14");
				 System.out.println("Notional:"+swapModel.getNotional());
				 System.out.println("periodRate:"+swapModel.getFixedQuote());
				 
				 int secondDaysCount=186;
				 
				 double DCF2=((double)186/(double)360);  
				 
				double d2=(double)Math.round(DCF2 * 100000d) / 100000d;			
				System.out.println("dcf:"+d2);
				 
				 
				 
				 double cashFlow2=swapModel.getNotional()*swapModel.getFixedQuote()*DCF2;				 
				 System.out.println("cashFlow: "+cashFlow2);
				 
				 
				 double Zcdf2=Math.exp(-1*DCF2*swapModel.getFixedQuote());
				 System.out.println("Zcdf: "+Zcdf2);
				 
				 
				 double PV2= Math.round((cashFlow1*Zcdf2) * 100d)/100d;			 
				  System.out.println("second PV: "+PV2+"\n");
				  
				  
				  System.out.println("third compounding:");
					 System.out.println("--------------------");
					 System.out.println("couponStartDate:29/9/14");
					 System.out.println("couponEndDate:27/3/15");
					 System.out.println("Notional:"+swapModel.getNotional());
					 System.out.println("periodRate:"+swapModel.getFixedQuote());
					 
					 int thirdDaysCount=179;
					 
					 double DCF3=((double)179/(double)360);  
					 
					double d3=(double)Math.round(DCF3 * 100000d) / 100000d;			
					System.out.println("dcf:"+d3);
					 
					 
					 
					 double cashFlow3=swapModel.getNotional()*swapModel.getFixedQuote()*DCF3;				 
					 System.out.println("cashFlow: "+cashFlow3);
					 
					 
					 double Zcdf3=Math.exp(-1*DCF3*swapModel.getFixedQuote());
					 System.out.println("Zcdf: "+Zcdf3);
					 
					 
					 double PV3= Math.round((cashFlow1*Zcdf3) * 100d)/100d;			 
					  System.out.println("third PV: "+PV3+"\n");
					  
					  
					  System.out.println("fourth compounding:");
						 System.out.println("--------------------");
						 System.out.println("couponStartDate:27/3/15");
						 System.out.println("couponEndDate:28/9/15");
						 System.out.println("Notional:"+swapModel.getNotional());
						 System.out.println("periodRate:"+swapModel.getFixedQuote());
						 
						 int fourthDaysCount=185;
						 
						 double DCF4=((double)185/(double)360);  
						 
						double d4=(double)Math.round(DCF4 * 100000d) / 100000d;			
						System.out.println("dcf:"+d4);
						 
						 
						 
						 double cashFlow4=swapModel.getNotional()*swapModel.getFixedQuote()*DCF4;				 
						 System.out.println("cashFlow: "+cashFlow4);
						 
						 
						 double Zcdf4=Math.exp(-1*DCF4*swapModel.getFixedQuote());
						 System.out.println("Zcdf: "+Zcdf4);
						 
						 
						 double PV4= Math.round((cashFlow1*Zcdf4) * 100d)/100d;			 
						  System.out.println("fourth PV: "+PV4+"\n");
						  
						  
						  System.out.println("fifth compounding:");
							 System.out.println("--------------------");
							 System.out.println("couponStartDate:28/9/15");
							 System.out.println("couponEndDate:29/3/16");
							 System.out.println("Notional:"+swapModel.getNotional());
							 System.out.println("periodRate:"+swapModel.getFixedQuote());
							 
							 int fifthDaysCount=183;
							 
							 double DCF5=((double)183/(double)360);  
							 
							double d5=(double)Math.round(DCF5 * 100000d) / 100000d;			
							System.out.println("dcf:"+d5);
							 
							 
							 
							 double cashFlow5=swapModel.getNotional()*swapModel.getFixedQuote()*DCF5;				 
							 System.out.println("cashFlow: "+cashFlow5);
							 
							 
							 double Zcdf5=Math.exp(-1*DCF5*swapModel.getFixedQuote());
							 System.out.println("Zcdf: "+Zcdf5);
							 
							 
							 double PV5= Math.round((cashFlow1*Zcdf5) * 100d)/100d;			 
							  System.out.println("fifth PV: "+PV5+"\n");
							  
							  
							  
							  System.out.println("sixth compounding:");
								 System.out.println("--------------------");
								 System.out.println("couponStartDate:29/3/16");
								 System.out.println("couponEndDate:27/9/16");
								 System.out.println("Notional:"+swapModel.getNotional());
								 System.out.println("periodRate:"+swapModel.getFixedQuote());
								 
								 int sixDaysCount=182;
								 
								 double DCF6=((double)182/(double)360);  
								 
								double d6=(double)Math.round(DCF6 * 100000d) / 100000d;			
								System.out.println("dcf:"+d6);
								 
								 
								 
								 double cashFlow6=swapModel.getNotional()*swapModel.getFixedQuote()*DCF6;				 
								 System.out.println("cashFlow: "+cashFlow6);
								 
								 
								 double Zcdf6=Math.exp(-1*DCF6*swapModel.getFixedQuote());
								 System.out.println("Zcdf: "+Zcdf6);
								 
								 
								 double PV6= Math.round((cashFlow1*Zcdf6) * 100d)/100d;			 
								  System.out.println("sixth PV: "+PV6+"\n");
								  
								  
								  System.out.println("-----------------------------------");								  
								  swapModel.setTotalPvAmount(PV1+PV2+PV3+PV4+PV5+PV6);
								  System.out.println("Total PV amount is:"+swapModel.getTotalPvAmount());
								  
								  
								  
								 swapModel.setTotalPaymentAmount(Math.round((cashFlow1+cashFlow2+cashFlow3+cashFlow4+cashFlow5+cashFlow6)*100d)/100d); 
								  System.out.println("Total Payment amount is:"+swapModel.getTotalPaymentAmount());
								  
								  
							  
						  
			 
		 }
		 else{
			 //retrieve value from screen and complete calculation  
		 }
	 }
	 }
	
	 
	
}
