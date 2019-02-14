package com.kh.god.storeInfo.model.vo;

import java.io.Serializable;

public class StoreInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String storeNo;
	private String storeName;
	private String storeTel;
	private String storeAddress;
	private String storeGrade;
	private int categoryNo;
	private String storeIntro;
	private String personalDay;
	private String operatingHours;
	private String pmsFlag;
	private String closeFlag;
	private int deliveryMinPrice;
	private String sellerId;
	
	public StoreInfo() {
		super();
	}

	public StoreInfo(String storeNo, String storeName, String storeTel, String storeAddress, String storeGrade,
			int categoryNo, String storeIntro, String personalDay, String operatingHours, String pmsFlag,
			String closeFlag, int deliveryMinPrice, String sellerId) {
		super();
		this.storeNo = storeNo;
		this.storeName = storeName;
		this.storeTel = storeTel;
		this.storeAddress = storeAddress;
		this.storeGrade = storeGrade;
		this.categoryNo = categoryNo;
		this.storeIntro = storeIntro;
		this.personalDay = personalDay;
		this.operatingHours = operatingHours;
		this.pmsFlag = pmsFlag;
		this.closeFlag = closeFlag;
		this.deliveryMinPrice = deliveryMinPrice;
		this.sellerId = sellerId;
	}

	public String getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreTel() {
		return storeTel;
	}

	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreGrade() {
		return storeGrade;
	}

	public void setStoreGrade(String storeGrade) {
		this.storeGrade = storeGrade;
	}

	public int getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getStoreIntro() {
		return storeIntro;
	}

	public void setStoreIntro(String storeIntro) {
		this.storeIntro = storeIntro;
	}

	public String getPersonalDay() {
		return personalDay;
	}

	public void setPersonalDay(String personalDay) {
		this.personalDay = personalDay;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}

	public String getPmsFlag() {
		return pmsFlag;
	}

	public void setPmsFlag(String pmsFlag) {
		this.pmsFlag = pmsFlag;
	}

	public String getCloseFlag() {
		return closeFlag;
	}

	public void setCloseFlag(String closeFlag) {
		this.closeFlag = closeFlag;
	}

	public int getDeliveryMinPrice() {
		return deliveryMinPrice;
	}

	public void setDeliveryMinPrice(int deliveryMinPrice) {
		this.deliveryMinPrice = deliveryMinPrice;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "StoreInfo [storeNo=" + storeNo + ", storeName=" + storeName + ", storeTel=" + storeTel
				+ ", storeAddress=" + storeAddress + ", storeGrade=" + storeGrade + ", categoryNo=" + categoryNo
				+ ", storeIntro=" + storeIntro + ", personalDay=" + personalDay + ", operatingHours=" + operatingHours
				+ ", pmsFlag=" + pmsFlag + ", closeFlag=" + closeFlag + ", deliveryMinPrice=" + deliveryMinPrice
				+ ", sellerId=" + sellerId + "]";
	}
	
	
	
	

}
