package dao;

import java.util.List;

import dto.Book;
import dto.BookPurchaseInfo;
import dto.User;
import dto.shoppingCart;

public interface shoppingCartDao {
	public void insert(BookPurchaseInfo bookPurInfo,User user);
	public boolean delete(BookPurchaseInfo bookPurInfo,User user);
	public List<BookPurchaseInfo> getInfoFromDB(String user_id);
}
