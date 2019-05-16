package com.vishist.derivative.scheduleModel;

public class SwapTicketModel {

	boolean scheduleEventWork;	
	public boolean isScheduleEventWork() {
		return scheduleEventWork;
	}
	public void setScheduleEventWork(boolean scheduleEventWork) {
		this.scheduleEventWork = scheduleEventWork;
	}
	String txtModStatus;
	Long notional;
	int accrualFrequency;
	double FixedQuote;
	double dayCount;
	double totalPvAmount;
	double totalPaymentAmount;
	double cashFlow;
	String startDate;
	String endDate;
	
	 
	 
	public String getTxtModStatus() {
		return txtModStatus;
	}
	public void setTxtModStatus(String txtModStatus) {
		this.txtModStatus = txtModStatus;
	}
	public Long getNotional() {
		return notional;
	}
	public void setNotional(Long notional) {
		this.notional = notional;
	}
	public int getAccrualFrequency() {
		return accrualFrequency;
	}
	public void setAccrualFrequency(int accrualFrequency) {
		this.accrualFrequency = accrualFrequency;
	}
	public double getFixedQuote() {
		return FixedQuote;
	}
	public void setFixedQuote(double fixedQuote) {
		FixedQuote = fixedQuote;
	}
	public double getDayCount() {
		return dayCount;
	}
	public void setDayCount(double dayCount) {
		this.dayCount = dayCount;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	 
	
	
}
