package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import jdbc.ResourceManager;
import dto.Book;
import dto.BookPurchaseInfo;
import dto.User;
import dto.shoppingCart;

public class shoppingCartDaoImpl implements shoppingCartDao{
	private Connection cartConn;
	protected final String SQL_INSERT = "insert into " + getTableName() + "(user_id, book_id,book_name, book_price,quantities) values(?, ?, ?, ?, ?)";
	protected  String SQL_DELETE = "DELETE FROM "  + getTableName()  + " ";

	protected static final int COLUMN_USER_ID = 1;
	protected static final int COLUMN_BOOK_ID= 2;
	protected static final int COLUMN_BOOK_NAME= 3;
	protected static final int COLUMN_BOOK_PRICE=4;
	protected static final int COLUMN_QUANTITIES=5;
	@Override
	public void insert(BookPurchaseInfo bookPurInfo,User user) {
		// TODO Auto-generated method stub
	final boolean isConnSupplied = (cartConn != null);
		
		Connection conn = null;
		CallableStatement stmt = null;
	try{
		System.out.println("Insert" + isConnSupplied);
		conn = isConnSupplied ? cartConn : ResourceManager.getConnection();  // 这行代码有问题
		stmt = conn.prepareCall(SQL_INSERT);//准备调用语句
		stmt.setString(COLUMN_USER_ID,user.getId());
		stmt.setString(COLUMN_BOOK_ID, bookPurInfo.getBook().getId());
		stmt.setString(COLUMN_BOOK_NAME, bookPurInfo.getBook().getName());
		stmt.setDouble(COLUMN_BOOK_PRICE,bookPurInfo.getBook().getPrice() );
		stmt.setInt(COLUMN_QUANTITIES, bookPurInfo.getQuantities());
		
		stmt.execute();  //执行
		
		//System.out.println("conn"+conn);
//		stmt.executeUpdate();
//		int rows = stmt.getUpdateCount();
//		System.out.println("Insert affect rows:" + rows);
		
	}
	catch(SQLException _e)
	{
		System.out.println("新增购物车信息失败");
//		throw new UserDaoException("")
	}
	finally
	{
		ResourceManager.close(stmt);
		if(!isConnSupplied)
		{	
			ResourceManager.close(conn);
		}			
	}		
	return ;
}

public String getTableName(){				
		return "shoppingCart";
	}
/**
 * 从数据库中删除书籍
 */
@Override
public boolean delete(BookPurchaseInfo bookPurInfo,User user)
{
	System.out.println("Delete Book! id = " + bookPurInfo.getBook().getId());
	final boolean isConnSupplied = (cartConn != null);
	
	Connection conn = null;
	CallableStatement stmt = null;
	
	String sql = SQL_DELETE + "WHERE book_id = '" + bookPurInfo.getBook().getId() + "' AND user_id = '"+user.getId()+"'";
	System.out.println("DELETESQL:"+sql);
	try
	{
		// 从ResourceManager获取连接
		conn = isConnSupplied ? cartConn : ResourceManager.getConnection();
		
		stmt = conn.prepareCall(sql);
		
//		stmt.execute();  
		 stmt.executeUpdate(sql);
		
		int rows = stmt.getUpdateCount();
		System.out.println("delete affect rows：" + rows);
		
	}
	catch(SQLException _e)
	{			
//		throw new UserDaoException("")
		System.out.println("Exception...");
	}
	finally
	{
		ResourceManager.close(stmt);
		if(!isConnSupplied)
		{	
			ResourceManager.close(conn);
		}			
	}			
	
	return false;
}
/**
 * 获取某个用户的购物信息
 */
public List<BookPurchaseInfo> getInfoFromDB(String user_id){
	  String sql="SELECT user_id,book_id,quantities FROM " + getTableName() + " where user_id = '" + user_id + "'";

	  Connection conn = null;
	  Statement stmt = null;
	  ResultSet rs = null;	  
	  final boolean isConnSupplied = (cartConn != null);
	  try 
	  {	   
		  conn = isConnSupplied ? cartConn : ResourceManager.getConnection();
	  	   stmt = conn.prepareCall(sql);
		   // 从连接中获取状态
		   stmt = conn.createStatement();
		   rs = stmt.executeQuery(sql);//执行sql语句 
		   List<BookPurchaseInfo> resultList = new ArrayList<BookPurchaseInfo>();
			try 
			{
				while (rs.next())
				{
					BookPurchaseInfo bpinfo = populateDto(rs);
					resultList.add(bpinfo);
				}
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return resultList;			   
	  } 
	  catch (SQLException e)
	  {
		   System.out.println("数据操作错误");
		   e.printStackTrace();
	  }
	  
	//关闭数据库
	  try 
	  {
		   if(stmt != null)
		   {
			    stmt.close();
			    stmt = null;
		   }
		   if(conn != null) 
		   {
			    conn.close();
			    conn = null;
		   }
	  }
	  catch(Exception e)
	  {
		   System.out.println("数据库关闭错误");
		   e.printStackTrace();
	  }
	System.out.println("从购物车获取用户信息失败");
	return null;
	
	
	
}







/**
 * 将一条数据库记录组装成一个对象
 * @param rs
 * @return
 */
protected BookPurchaseInfo populateDto(ResultSet rs)
{
	BookPurchaseInfo bpc=new BookPurchaseInfo();
	BookDaoImpl bdi=new BookDaoImpl();
	try 
	{
		bpc.setBook(bdi.findById(rs.getString("book_id"))[0]);
		bpc.setQuantities(rs.getInt("quantities"));
	} 
	catch (SQLException e) 
	{
		e.printStackTrace();
	}
	
	
	return bpc;
}




}







