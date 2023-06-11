package application;

public class Food {
	private String name;
	private String imgSrc;
	private double price;
	private String color;
	private String desc;
	private int pax;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImgSrc() {
		return imgSrc;
	}
	
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void setPax(int pax) {
		this.pax = pax;
	}
	
	public int getPax() {
		return pax;
	}
}
