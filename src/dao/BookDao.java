package dao;

import dto.Book;

public interface BookDao {
	
	public void insert(Book book);
	
	public Book[] findById(String id);
	
	public Book[] findByName(String name);
	
	public boolean deleteBook(String id);

}
