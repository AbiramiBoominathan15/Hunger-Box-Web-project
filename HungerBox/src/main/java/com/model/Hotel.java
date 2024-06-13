package com.model;

public class Hotel {
	public int hotelId;
	public String hotelName;
	public String hotelType;
	public String hotelCity;
	public String hotelLocation;
	public String hotelPhoneNumber;
	public double rating;
	public String feedback;

	public int getHotelId() {
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public String getHotelType() {
		return hotelType;
	}
	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}
	public String getHotelCity() {
		return hotelCity;
	}
	public void setHotelCity(String hotelCity) {
		this.hotelCity = hotelCity;
	}
	public String getHotelLocation() {
		return hotelLocation;
	}
	
	
	
	
	
	public void setHotelLocation(String hotelLocation) {
		this.hotelLocation = hotelLocation;
	}
	public String getHotelPhoneNumber() {
		return hotelPhoneNumber;
	}
	public void setHotelPhoneNumber(String hotelPhoneNumber) {
		this.hotelPhoneNumber = hotelPhoneNumber;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Hotel(int hotelId, String hotelName, String hotelType, String hotelCity, String hotelLocation,
			String hotelPhoneNumber, double rating, String feedback) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelCity = hotelCity;
		this.hotelLocation = hotelLocation;
		this.hotelPhoneNumber = hotelPhoneNumber;
		this.rating = rating;
		this.feedback = feedback;
	}
	public Hotel(String hotelName, String hotelLocation, String phoneNumber) {
		this.hotelName = hotelName;
		this.hotelLocation = hotelLocation;
		this.hotelPhoneNumber = phoneNumber;

	}
	public Hotel() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelType=" + hotelType + ", hotelCity="
				+ hotelCity + ", hotelLocation=" + hotelLocation + ", hotelPhoneNumber=" + hotelPhoneNumber
				+ ", rating=" + rating + ", feedback=" + feedback + ", getHotelId()=" + getHotelId()
				+ ", getHotelName()=" + getHotelName() + ", getHotelType()=" + getHotelType() + ", getHotelCity()="
				+ getHotelCity() + ", getHotelLocation()=" + getHotelLocation() + ", getHotelPhoneNumber()="
				+ getHotelPhoneNumber() + ", getRating()=" + getRating() + ", getFeedback()=" + getFeedback() + "]";
	}

}