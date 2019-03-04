package com.kh.god.admin.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Report {
	private int reportNo;
	private String category;
	private int reviewNo;
	private String storeNo;
	private String reportDetails;
	private String reportFlag;
}
