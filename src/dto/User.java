package dto;

import java.io.Serializable;

public class User implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String psw;
	
	private String name;
	
	private String address;
	
	private String tel;
	
	public User()
	{
		
	}
	
	public User(String id, String psw,String name,String address,String tel)
	{
		this.id = id;
		this.name = name;
		this.psw = psw;
		this.address=address;
		this.tel=tel;
	}
	public void display(){
		System.out.println("id:"+id+"; passworld:"+psw+"; name:"+name+"; address:"+address+"; tel:"+tel);
		
	}
	public String getId() 
	{
		return id;
	}

	public void setId(String id) 
	{
		this.id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPsw() 
	{
		return psw;
	}

	public void setPsw(String psw) 
	{
		this.psw = psw;
	}
	


	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	
	
	public boolean equals(Object _other)
	{
		if(_other == null)
		{
			return false;			
		}
		if(_other == this)
		{
			return true;
		}
		if(!(_other instanceof User))
		{
			return false;
		}
		
//		final User _cast = (User)_other;
//		
//		if(id == null ? _cast.id != id : !)
//		{
//			
//		}
		
		return true;
	}
	

	public int hashCode()
	{
		int _hashCode = 0;
		
		if(id == null)
		{
			_hashCode = 29 * _hashCode + id.hashCode();
			
		}
		if(name == null)
		{
			_hashCode = 29 * _hashCode + name.hashCode();
			
		}
		if(psw == null)
		{
			_hashCode = 29 * _hashCode + psw.hashCode();
			
		}		
		if(address == null)
		{
			_hashCode = 29 * _hashCode + name.hashCode();
			
		}
		if(tel == null)
		{
			_hashCode = 29 * _hashCode + psw.hashCode();
			
		}			
		return _hashCode;
	}
	
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		
		ret.append("id = " + id + "/r/n");
		ret.append("name = " + name + "/r/n");
		ret.append("psw = " + psw + "/r/n");
		ret.append("address = " + address + "/r/n");
		ret.append("tel = " + tel + "/r/n");
		return ret.toString();
	}
	

}
