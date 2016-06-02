package dto;

import java.util.List;
import java.util.Vector;

import dao.UserDaoImpl;
import dao.shoppingCartDaoImpl;

public class shoppingCart {
	 public List<BookPurchaseInfo> bookInfos;
	 public User user;
	 
	 
	public shoppingCart(List<BookPurchaseInfo> bookInfos, User user) {
		super();
		this.bookInfos = bookInfos;
		this.user = user;
	}

	public shoppingCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<BookPurchaseInfo> getBookInfos() {
		return bookInfos;
	}

	public void setBookInfos(List<BookPurchaseInfo> bookInfos) {
		this.bookInfos = bookInfos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void addBookInfo(BookPurchaseInfo bookinfos){
			this.bookInfos.add(bookinfos);

	}
	public void deleteBookInfo(String bookID){
		for(int i=0;i<this.bookInfos.size();i++){
			if(this.bookInfos.get(i).getBook().getId().equals(bookID)){
				this.bookInfos.remove(i);
			}
		}
	}
	public void check(String bookID,User user){
		for(int i=0;i<this.bookInfos.size();i++){
			if(this.bookInfos.get(i).getBook().getId().equals(bookID)){
				deleteInfoInDB(this.bookInfos.get(i), user);
				this.bookInfos.remove(i);
				
			}
		}
		
	}	
	public void deleteInfoInDB(BookPurchaseInfo bookPurInfo,User user){
		shoppingCartDaoImpl sci=new shoppingCartDaoImpl();
		sci.delete(bookPurInfo, user);
		
	}

}
