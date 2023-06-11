package application;

public class User {
	private String username;
	private String pass;
	private double total;
	private int cardNum;
	
	
	public User(String username, String pass) {
		this.username = username;
		this.pass = pass;
	}
	
	public String getUsername(){
		return username;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	
	public String getPass(){
		return pass;
	}
	
	public void setPass(String pass){
		this.pass = pass;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	public int getCardNum() {
		return cardNum;
	}
	
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
}
