package com.kh.god.admin.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Event {
	
	private int eventNo;
	private String eventTitle;
	private String discount;
	private String eventContent;
	private Date startDate;
	private Date endDate;

}
