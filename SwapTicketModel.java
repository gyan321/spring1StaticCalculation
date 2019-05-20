package com.derivatives.model;

import java.time.LocalDate;

public class SwapTicketModel {

	boolean scheduleEventWork;

	public boolean isScheduleEventWork() {
		return scheduleEventWork;
	}

	public void setScheduleEventWork(boolean scheduleEventWork) {
		this.scheduleEventWork = scheduleEventWork;
	}

	long noOfDays;

	public long getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(long noOfDays) {
		this.noOfDays = noOfDays;
	}

	String txtModStatus;

	public String getTxtModStatus() {
		return txtModStatus;
	}

	public void setTxtModStatus(String txtModStatus) {
		this.txtModStatus = txtModStatus;
	}

	// static int tenor=3;//remove value later
	  int tenor; 

	public int getTenor() {
		return tenor;
	}

	public void setTenor(int tenor) {
		this.tenor = tenor;
	}

	  Long notional;
 

	public Long getNotional() {
		return notional;
	}

	public void setNotional(Long notional) {
		this.notional = notional;
	}

	  String accrualFrequency;

	public   String getAccrualFrequency() {
		return accrualFrequency;
	}

	public   void setAccrualFrequency(String accrualFrequency) {
		getModelInstance().accrualFrequency = accrualFrequency;

		switch (accrualFrequency) {

		case "Semiannual":
			getModelInstance().convertedAccrualFrequency = 6;

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

	  int convertedAccrualFrequency;

	 

	public int getConvertedAccrualFrequency() {
		return convertedAccrualFrequency;
	}

	public void setConvertedAccrualFrequency(int convertedAccrualFrequency) {
		this.convertedAccrualFrequency = convertedAccrualFrequency;
	}

	  double DBdefaultFixedQuote;

	 

	public double getDBdefaultFixedQuote() {
		return DBdefaultFixedQuote;
	}

	public void setDBdefaultFixedQuote(double dBdefaultFixedQuote) {
		DBdefaultFixedQuote = dBdefaultFixedQuote;
	}

	// static double FixedQuote=1;//remove value later
	  double FixedQuote;

	public   double getFixedQuote() {
		return FixedQuote;
	}

	public   void setFixedQuote(double fixedQuote) {
		if (fixedQuote < 0) {
			getModelInstance().FixedQuote = (-1 * fixedQuote) * 0.01;

		} else {
			getModelInstance().FixedQuote = fixedQuote * 0.01;
		}
	}

	double convertedDayCount;

	public double getConvertedDayCount() {
		return convertedDayCount;
	}

	public void setConvertedDayCount(double convertedDayCount) {
		this.convertedDayCount = convertedDayCount;
	}

	// String dayCount="Act/360";//remove value later
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

 
	  String startDate;
	  
	  
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	  LocalDate convertedstartDate;

	public   LocalDate getConvertedstartDate() {
		return convertedstartDate;
	}

	public   void setConvertedstartDate(LocalDate convertedstartDate) {
		getModelInstance().convertedstartDate = convertedstartDate;
	}

	// static String endDate="16/9/2016";
	  String endDate;
	  
	  public String getEndDate() {
			return endDate;
		}

		public static void setEndDate(String endDate) {
			getModelInstance().endDate = endDate;
		}
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

	 

	

	/* creating singleton object */
	static SwapTicketModel swapTicketModelObject = new SwapTicketModel();

	private SwapTicketModel() {

	}

	public static SwapTicketModel getModelInstance() {
		return swapTicketModelObject;
	}

}
