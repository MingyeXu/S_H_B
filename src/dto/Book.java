package dto;

import java.io.Serializable;
import java.sql.Date;

public class Book implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;
	private String author;
	private String press;
	private String pressDate;
	private double price;
	private int amount;
	public Book()
	{
		
	}
	
	public Book(String id, String name, String author, String press, String pressDate, double price, int amount)
	{
		System.out.println("Book!");
		this.id = id;
		this.name = name;
		this.author = author;
		this.press = press;
		this.pressDate = pressDate;
		this.price = price;
		this.amount = amount;
		
	}
	


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPressDate() {
		return pressDate;
	}
	public void setPressDate(String pressDate) {
		this.pressDate = pressDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString()
	{
		StringBuffer buffer = new StringBuffer();
		
		buffer.append(this.id + ",");
		buffer.append(this.name + ",");
		buffer.append(this.author + ",");
		buffer.append(this.press + ",");
		buffer.append(this.pressDate + ",");
		buffer.append(this.price + ",");
		buffer.append(this.amount);
		
		return buffer.toString();
	}
	
	
	
}
