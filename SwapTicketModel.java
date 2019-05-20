package com.derivatives.model;

import java.time.LocalDate;
import java.util.Date;

public class SwapTicketModel {

	boolean scheduleEventWork;	
	
	public boolean isScheduleEventWork() {
		return scheduleEventWork;
	}

	public void setScheduleEventWork(boolean scheduleEventWork) {
		this.scheduleEventWork = scheduleEventWork;
	}
	
	
	static long noOfDays;

	public static long getNoOfDays() {
		return noOfDays;
	}

	public static void setNoOfDays(long noOfDays) {
		SwapTicketModel.noOfDays = noOfDays;
	}

	

	String txtModStatus;
	
	public String getTxtModStatus() {
		return txtModStatus;
	}

	public void setTxtModStatus(String txtModStatus) {
		this.txtModStatus = txtModStatus;
	}
	
	

	//static int tenor=3;//remove value later
	static int tenor;

	public static int getTenor() {
		return tenor;
	}

	public void setTenor(int tenor) {
		SwapTicketModel.tenor = tenor;
	}

	
	//static Long notional=10000000l;//remove value later
	static Long notional;  

	public static Long getNotional() {
		return notional;
	}

	public static void setNotional(Long notional) {
		SwapTicketModel.notional = notional;
	}

	
 
	
	
	
	static String accrualFrequency ;//remove value later

	public static String getAccrualFrequency() {
		return accrualFrequency;
	}

	public static void setAccrualFrequency(String accrualFrequency) {
		SwapTicketModel.accrualFrequency = accrualFrequency;

		switch (accrualFrequency) {

		case "Semiannual":
			SwapTicketModel.convertedAccrualFrequency = 6;

			/*
			 * case "Annual": this.convertedAccrualFrequency = 12;
			 * 
			 * case "FourthMonthly": this.convertedAccrualFrequency = 3;
			 * 
			 * case "Monthly": this.convertedAccrualFrequency = 6;
			 * 
			 * case "Biweekly": this.convertedAccrualFrequency = 6;
			 * 
			 * case "Weekly": this.convertedAccrualFrequency = 6;
			 * 
			 * case "Daily": this.convertedAccrualFrequency = 6;
			 */

		}
	}

	static int convertedAccrualFrequency;

	public static int getConvertedAccrualFrequency() {
		return convertedAccrualFrequency;
	}

	public static void setConvertedAccrualFrequency(int convertedAccrualFrequency) {
		SwapTicketModel.convertedAccrualFrequency = convertedAccrualFrequency;
	}

	
	
	static double DBdefaultFixedQuote;
	
	public static double getDBdefaultFixedQuote() {
		return DBdefaultFixedQuote;
	}

	public static void setDBdefaultFixedQuote(double dBdefaultFixedQuote) {
		DBdefaultFixedQuote = dBdefaultFixedQuote*0.01;
	}


	//static double FixedQuote=1;//remove value later
	static double FixedQuote;

	public static double getFixedQuote() {
		return FixedQuote;
	}

	public static void setFixedQuote(double fixedQuote) {
		if (fixedQuote < 0) {
			SwapTicketModel.FixedQuote = (-1 * fixedQuote) * 0.01;

		} else {
			SwapTicketModel.FixedQuote = fixedQuote * 0.01;
		}
	}

	double convertedDayCount;

	public double getConvertedDayCount() {
		return convertedDayCount;
	}

	public void setConvertedDayCount(double convertedDayCount) {
		this.convertedDayCount = convertedDayCount;
	}

	//String dayCount="Act/360";//remove value later
	String dayCount;

	public String getDayCount() {
		return dayCount;
	}

	public void setDayCount(String dayCount) {
		switch (dayCount) {
		case "Act/360":

		}

		this.dayCount = dayCount;
	}

	double totalPvAmount;
	double totalPaymentAmount;
	double cashFlow;
	
	
	//static String startDate="27/9/2013";// remove this later
	static String startDate;
	static LocalDate convertedstartDate;

	public static LocalDate getConvertedstartDate() {
		return convertedstartDate;
	}

	public static void setConvertedstartDate(LocalDate convertedstartDate) {
		SwapTicketModel.convertedstartDate = convertedstartDate;
	}

	//static String endDate="16/9/2016";
	static String endDate;
	LocalDate convertedendDate;

	public LocalDate getConvertedendDate() {
		return convertedendDate;
	}

	public void setConvertedendDate(LocalDate convertedendDate) {
		this.convertedendDate = convertedendDate;
	}

	

	public double getTotalPvAmount() {
		return totalPvAmount;
	}

	public void setTotalPvAmount(double totalPvAmount) {
		this.totalPvAmount = totalPvAmount;
	}

	public double getTotalPaymentAmount() {
		return totalPaymentAmount;
	}

	public void setTotalPaymentAmount(double totalPaymentAmount) {
		this.totalPaymentAmount = totalPaymentAmount;
	}

	public double getCashFlow() {
		return cashFlow;
	}

	public void setCashFlow(double cashFlow) {
		this.cashFlow = cashFlow;
	}

	public static String getStartDate() {
		return startDate;
	}

	public static void setStartDate(String startDate) {
		SwapTicketModel.startDate = startDate;

	}

	public String getEndDate() {
		return endDate;
	}

	public static void setEndDate(String endDate) {
		SwapTicketModel.endDate = endDate;
	}

}
