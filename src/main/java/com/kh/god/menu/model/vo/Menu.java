package com.kh.god.menu.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Menu {
	private String menuCode;
	private int categoryNo;
	private String menuName;
	private int menuPrice;
	private String storeNo;

}