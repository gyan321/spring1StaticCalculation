package com.derivatives.swapticket;

import java.util.ArrayList;
import java.util.List;

import com.derivatives.dao.AccrualBusDayDao;
import com.derivatives.dao.AccrualFreqDao;
import com.derivatives.dao.CalendarsDao;
import com.derivatives.dao.CompoundingDao;
import com.derivatives.dao.CurrencyDao;
import com.derivatives.dao.DayCountDao;
import com.derivatives.dao.DiscountCurveDao;
import com.derivatives.dao.EndRollDao;
import com.derivatives.dao.EomDao;
import com.derivatives.dao.MarchingDao;
import com.derivatives.dao.NotionalExchangeDao;
import com.derivatives.dao.PayConvDao;
import com.derivatives.dao.RollDayDao;
import com.derivatives.dao.StartRollDao;
import com.derivatives.dao.SwapLagBusDayDao;
import com.derivatives.dao.SwapLegListDao;
import com.derivatives.dao.SwapTenorDao;
import com.derivatives.dao.WeekDayDao;
import com.derivatives.model.AccrualBusDay;
import com.derivatives.model.AccrualFreq;
import com.derivatives.model.Calendars;
import com.derivatives.model.Compounding;
import com.derivatives.model.Currency;
import com.derivatives.model.DayCount;
import com.derivatives.model.DiscountCurve;
import com.derivatives.model.EndRoll;
import com.derivatives.model.Eom;
import com.derivatives.model.Marching;
import com.derivatives.model.NotionalExchange;
import com.derivatives.model.PayConv;
import com.derivatives.model.RollDay;
import com.derivatives.model.StartRoll;
import com.derivatives.model.SwapLagBusDay;
import com.derivatives.model.SwapLegList;
import com.derivatives.model.SwapTenor;
import com.derivatives.model.SwapTicketModel;
import com.derivatives.model.WeekDay;

public class SwapTicketPay {

	SwapTicketModel swapTicketModelObject ;

	@SuppressWarnings("unchecked")
	public List swapticketpay() {
		
		SwapTicketModel swapTicketModelObject = SwapTicketModel.getModelInstance();

		List swapticketpay = new ArrayList();

		// creating objects for dao's and model classes
		CurrencyDao c = new CurrencyDao();
		Currency currency = c.getCurrency();
		// System.out.println(currency.getId());

		swapticketpay.add(currency.getId());

		NotionalExchangeDao n = new NotionalExchangeDao();
		NotionalExchange ne = n.getNotionalExchange();

		swapticketpay.add(ne.getId());

		RollDayDao roll = new RollDayDao();
		RollDay rd = roll.getRollDay();
		swapticketpay.add(rd.getId());

		SwapLagBusDayDao slbd = new SwapLagBusDayDao();
		SwapLagBusDay sl = slbd.getSwapLagBusDay();
		swapticketpay.add(sl.getId());

		DayCountDao dcount = new DayCountDao();
		DayCount dc = dcount.getDayCount();
		swapticketpay.add(dc.getId());

		 
		//System.out.println("dayCount::" + dc.getId().get(0));
		//System.out.println("dayCount::" + dc.getId());
		
		
		
		swapTicketModelObject.setDayCount(dc.getId().get(0));
		//swapTicketModelObject.setDayCount("Act/360");
		
		
		

		WeekDayDao weekday = new WeekDayDao();
		WeekDay wd = weekday.getWeekDay();
		swapticketpay.add(wd.getId());

		PayConvDao conv = new PayConvDao();
		PayConv pc = conv.getPayConv();
		swapticketpay.add(pc.getId());

		DiscountCurveDao dcurve = new DiscountCurveDao();
		DiscountCurve dcu = dcurve.getDiscountCurve();
		swapticketpay.add(dc.getId());

		CompoundingDao com = new CompoundingDao();
		Compounding comp = com.getCompounding();
		swapticketpay.add(comp.getId());

		CalendarsDao calendars = new CalendarsDao();
		Calendars cal = calendars.getCalendars();
		swapticketpay.add(cal.getId());

		AccrualBusDayDao accrual = new AccrualBusDayDao();
		AccrualBusDay abd = accrual.getAccrualBusDay();
		swapticketpay.add(abd.getId());

		EomDao e = new EomDao();
		Eom eom = e.getEom();
		swapticketpay.add(eom.getId());

		AccrualFreqDao acc = new AccrualFreqDao();
		AccrualFreq af = acc.getAccrualFreq();

		swapticketpay.add(af.getId());
		//System.out.println("fequency::" + af.getId().get(2));
		//System.out.println("fequency::" + af.getId());
		
		swapTicketModelObject.setAccrualFrequency(af.getId().get(2));
       // SwapTicketModel.setAccrualFrequency("6");
        

		MarchingDao march = new MarchingDao();
		Marching m = march.getMarching();
		swapticketpay.add(m.getId());

		StartRollDao start = new StartRollDao();
		StartRoll sr = start.getStartRoll();
		swapticketpay.add(sr.getId());

		EndRollDao end = new EndRollDao();
		EndRoll er = end.getEndRoll();
		swapticketpay.add(er.getId());

		SwapTenorDao swapda = new SwapTenorDao();
		SwapTenor st = new SwapTenor();
		st.setSwaptenor(swapda.getTenor());
		//System.out.println("tenor:" + st.getSwaptenor());
		//swapTicketModelObject.setTenor(Integer.parseInt(st.getSwaptenor()));
		
		
		swapTicketModelObject.setTenor(Integer.parseInt(st.getSwaptenor()));
		//swapTicketModelObject.setTenor(3);
		
		// Integer.parseInt
		swapticketpay.add(st.getSwaptenor());

		SwapLegListDao sll = new SwapLegListDao();
		SwapLegList leg = new SwapLegList();
		leg.setSwapleg(sll.getSwapLegList());

		//System.out.println("notional :" + sll.getSwapLegList().get(0));
		
		
		swapTicketModelObject.setNotional(Long.parseLong(sll.getSwapLegList().get(0)));
		//SwapTicketModel.setNotional(10000000l);
		
		
		

		//System.out.println("startDate :" + sll.getSwapLegList().get(1));
		
		
		
		swapTicketModelObject.setStartDate(sll.getSwapLegList().get(1));
		//SwapTicketModel.setStartDate("27/9/13");
		
		
		
		
		//System.out.println("enddate :" + sll.getSwapLegList().get(2));
		
		
		SwapTicketModel.setEndDate(sll.getSwapLegList().get(2));
		//SwapTicketModel.setEndDate("27/9/16");
		
		
		
		
		
		//System.out.println("FixedQuote :" + sll.getSwapLegList().get(3));
		
		swapTicketModelObject.setFixedQuote(Double.parseDouble(sll.getSwapLegList().get(3)));
		//SwapTicketModel.setFixedQuote(1);
		
		

		// System.out.println(leg.getSwapleg());
		swapticketpay.add(leg.getSwapleg());
		return swapticketpay;

	}

}
