package com.laptrinhjavaweb.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.dto.MyItem;
import com.laptrinhjavaweb.repository.ReportOrderRepository;
import com.laptrinhjavaweb.service.IReportOrderService;

@Service
public class ReportOrderImpl implements IReportOrderService {

	@Autowired
	private ReportOrderRepository reportRepository;

	@Transactional
	@Override
	public List<MyItem> reportOrder(Date date, int limit) {
		List<MyItem> result = new ArrayList<>();
		for (int i = limit - 1; i >= 0; i--) {
			Date d = subDays(date, i);
			MyItem myItem = new MyItem();
			myItem.setTime(convertD2S(d));
			String valueOfDate=convertD2S(d);
			myItem.setValue(countItemByDate(valueOfDate));
			result.add(myItem);
		}
		return result;
	}

	private int countItemByDate(String date) {
		Long obj = reportRepository.count(date);
		return obj.intValue();
	}

	private String convertD2S(Date date) {
		DateFormat df =new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	private Date subDays(Date date, int days) {
		GregorianCalendar cal=new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DATE, -days);
		return cal.getTime();
	}

}
