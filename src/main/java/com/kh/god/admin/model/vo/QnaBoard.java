package com.kh.god.admin.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class QnaBoard {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardwriter;
	private int boardLevel;
	private int boardRef;
	private String category;
	private Date boardDate;
	

}
