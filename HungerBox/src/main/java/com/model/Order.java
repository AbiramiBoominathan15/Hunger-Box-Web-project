package com.model;

public class Order {
	public int orderId;
	public int hotelId;
	public String foodName;
	public String address;
	public double totalAmount;
	public String paymentMode;
	public String orderDelivery;

	public Order() {
	}

	public Order(int orderId, int hotelId, String foodName, String address, double totalAmount, String paymentMode,
			String orderDelivery) {
		this.orderId = orderId;
		this.hotelId = hotelId;
		this.foodName = foodName;
		this.address = address;
		this.totalAmount = totalAmount;
		this.paymentMode = paymentMode;
		this.orderDelivery = orderDelivery;
	}

	
	
	
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getOrderDelivery() {
		return orderDelivery;
	}

	public void setOrderDelivery(String orderDelivery) {
		this.orderDelivery = orderDelivery;
	}

	@Override
	public String toString() {
		return "Order{" + "orderId=" + orderId + ", hotelId=" + hotelId + ", foodName='" + foodName + '\''
				+ ", address='" + address + '\'' + ", totalAmount=" + totalAmount + ", paymentMode='" + paymentMode
				+ '\'' + ", orderDelivery='" + orderDelivery + '\'' + '}';
	}
}
