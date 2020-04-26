package com.laptrinhjavaweb.service;

import java.util.Date;
import java.util.List;

import com.laptrinhjavaweb.dto.MyItem;

public interface IReportOrderService {
	public List<MyItem> reportOrder(Date date, int limit);
}
