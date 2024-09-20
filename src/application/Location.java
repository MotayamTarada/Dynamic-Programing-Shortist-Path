package application;

public class Location {
	private int hotel;
	private String location;
	private int price;	
	
	public Location(String location, int price, int hotel) {
		this.location = location;
		this.price = price;
		this.hotel = hotel;
		
	}
	public boolean equals(String location){
		return this.location.equals(location);
	}
	public Location(String location) {
		this.location = location;
		
	}

	@Override
	public String toString() {
		return  location+" Cost"+(hotel + price) ;
	}
	

	

	public int getHotel() {
		return hotel;
	}

	public void setHotel(int hotel) {
		this.hotel = hotel;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
