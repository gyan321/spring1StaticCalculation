package com.derivatives.controller;

import com.derivatives.swapticket.SwapTicketFixed;
import com.derivatives.swapticket.SwapTicketFloat;
import com.derivatives.swapticket.SwapTicketPay;
import com.derivatives.swapticket.SwapTicketRec;
import com.derivatives.model.SwapTicketModel;

 

public class SwapTicketController {
	public static void main(String[] args) {
		
		
		 
		 SwapTicketPay stp=new SwapTicketPay();
		stp.swapticketpay();
		
		//System.out.println(stp.swapticketpay());
		
		
		SwapTicketRec str=new SwapTicketRec();
		str.swapticketrec(); 
		
		//System.out.println(str.swapticketrec());
		
		
		
		//gyan's code
		 
		SwapTicketFixed swapTicketFixedObject=new SwapTicketFixed();
		SwapTicketFloat swapTicketFloatObject=new SwapTicketFloat();
		SwapTicketModel swapTicketModelObject = SwapTicketModel.getModelInstance();
		

		/*
		 * @ calling method to change the given start date into executable formate
		 * 
		 */
	 	swapTicketFixedObject.FixedchangeStartDateFormat(swapTicketModelObject.getStartDate()); 
		
		
		/*
		 * @ calling  RecSwapTicketLoad() method to preset
		 * @ ScheduleEventWork value
		 * @ TxtModStatus
		 *  
		 */
		 swapTicketFixedObject.FixedSwapTicketLoad();  
		
		/*
		 * @ calling  onFixedScheduleLoad() method to calculate PV amount
		 * @ each fixed Accuralfrequency
		 * @ also to calculate Total PV amount and
		 * @ Total Payment Amount
		 */
 	   swapTicketFixedObject.onFixedScheduleLoad();
		
		
		
		/*
		 * @ calling method to change the given start date into executable formate
		 * 
		 */
		 swapTicketFloatObject.FloatchangeStartDateFormat(swapTicketModelObject.getStartDate());

		/*
		 * @ calling  SwapTicketLoad() method to preset
		 * @ ScheduleEventWork value
		 * @ TxtModStatus
		 *  
		 */
		 swapTicketFloatObject.FloatPaySwapTicketLoad();  
		
		/*
		 * @ calling  onFloatScheduleLoad() method to calculate PV amount
		 * @ each Float Accuralfrequency
		 * @ also to calculate Total PV amount and
		 * @ Total Payment Amount
		 */  
		 swapTicketFloatObject.onFloatScheduleLoad();
		
	
	}
	
	}


