package dto;

public class BookPurchaseInfo {
	private Book book;	
	private int quantities;
	
	public BookPurchaseInfo(Book book, int quantities) {
		super();
		this.book = book;
		this.quantities = quantities;
	}
	public BookPurchaseInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantities() {
		return quantities;
	}
	public void setQuantities(int quantities) {
		this.quantities = quantities;
	}
	
}
