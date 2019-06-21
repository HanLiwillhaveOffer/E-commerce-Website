package jspservlet.vo;

public class Shop {
private String username;
private String goodname;
private int price;
private int state;
private String image;
private int number;
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getGoodname() {
	return goodname;
}
public void setGoodname(String goodname) {
	this.goodname = goodname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getState() {
	return state;
}
public void setState(int state) {
	this.state = state;
}
}
