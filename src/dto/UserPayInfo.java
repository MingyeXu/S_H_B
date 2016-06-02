package dto;

import java.util.List;
import java.util.Vector;
/**
 * 支付表单类
 * @author 徐名业
 *
 */
public class UserPayInfo {
    private String name;
    private String address;
    private String phone;
    private String type ;
    private String account;
    private List<BookPurchaseInfo> bookInfos;
    private User user;
    
    
	
	public UserPayInfo(String name, String address, String phone, String type,
			String account, List<BookPurchaseInfo> bookInfos, User user) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.type = type;
		this.account = account;
		this.bookInfos = bookInfos;
		this.user = user;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
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
	
}
