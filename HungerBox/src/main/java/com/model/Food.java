package com.model;

import java.io.InputStream;
import java.util.Arrays;

public class Food {
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
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
	public int getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(int foodPrice) {
		this.foodPrice = foodPrice;
	}
	public String getFoodCategories() {
		return foodCategories;
	}
	public void setFoodCategories(String foodCategories) {
		this.foodCategories = foodCategories;
	}
	public byte[] getFoodImage() {
		return foodImage;
	}
	public void setFoodImage(byte[] foodImage) {
		this.foodImage = foodImage;
	}
	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", hotelId=" + hotelId + ", foodName=" + foodName + ", foodPrice=" + foodPrice
				+ ", foodCategories=" + foodCategories + ", foodImage=" + Arrays.toString(foodImage) + ", getFoodId()="
				+ getFoodId() + ", getHotelId()=" + getHotelId() + ", getFoodName()=" + getFoodName()
				+ ", getFoodPrice()=" + getFoodPrice() + ", getFoodCategories()=" + getFoodCategories()
				+ ", getFoodImage()=" + Arrays.toString(getFoodImage()) + "]";
	}
	public Food(int foodId, int hotelId, String foodName, int foodPrice, String foodCategories, byte[] foodImage) {
		super();
		this.foodId = foodId;
		this.hotelId = hotelId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodCategories = foodCategories;
		this.foodImage = foodImage;
	}
	public Food() {
		// TODO Auto-generated constructor stub
	}
	public int foodId;
	public int hotelId;
	public String foodName;
	public int foodPrice;
	public String foodCategories; 
	public byte[] foodImage;
	
}